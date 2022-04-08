package by.suprun.task4.service.impl;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.exception.CustomCompositeException;
import by.suprun.task4.service.TextCompositeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCompositeServiceImpl implements TextCompositeService {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String WORD_REGEX = "[\\wА-яа-я]([\\wА-яа-я]|[^\\)]|!=)*[^.?,!\\)]";
    private static final String VOWEL_REGEX = "[aoiuyeоаиеуёэюяы]";
    private static final String LETTERS_REGEX = "\\w|[А-Яа-я]";

    @Override
    public void paragraphSort(TextComponent textComponent) throws CustomCompositeException {
        LOGGER.info("Method to sort paragraph called");
        if (textComponent == null || textComponent.getComponentType() != TextComponentType.TEXT) {
            throw new CustomCompositeException("Introduced text component null or has incorrect type. " +
                    "Must be Text find: " + textComponent.getComponentType());
        }
        textComponent.getComponentList().sort(Comparator.comparingInt(o -> o.getComponentList().size()));
    }

    @Override
    public List<String> maxWordSentences(TextComponent textComponent) throws CustomCompositeException {
        LOGGER.info("Method to find sentences with word which has max length called");
        if (textComponent == null || textComponent.getComponentType() != TextComponentType.TEXT) {
            throw new CustomCompositeException("Introduced text component null or has incorrect type. " +
                    "Must be Text find: " + textComponent.getComponentType());
        }
        List<String> tempList = new ArrayList<>();
        List<TextComponent> componentList = textComponent.getComponentList();
        int maxsize = 0;
        for (TextComponent component : componentList) {
            TextComponent tempParagraphComponent = component;
            List<TextComponent> sentencesList = tempParagraphComponent.getComponentList();
            for (TextComponent sentence : sentencesList) {
                TextComponent tempSentenceComponent = sentence;
                List<TextComponent> lexemeList = tempSentenceComponent.getComponentList();
                for (TextComponent lexeme : lexemeList) {
                    if (lexeme.getComponentType() == TextComponentType.WORD) {
                        if (lexeme.getComponentList().size() == maxsize) {
                            tempList.add(sentence.toString());
                        }
                        if (lexeme.getComponentList().size() > maxsize) {
                            maxsize = lexeme.getComponentList().size();
                            tempList.removeAll(tempList);
                            tempList.add(sentence.toString());
                        }
                    }
                }
            }
        }
        return tempList;
    }

    @Override
    public void removeSentencesWithWordCountLessThan(TextComponent textComponent, int count) throws CustomCompositeException {
        LOGGER.info("Method to remove sentences with word count less than " + count);
        if (textComponent == null || textComponent.getComponentType() != TextComponentType.TEXT) {
            throw new CustomCompositeException("Introduced text component null or has incorrect type. " +
                    "Must be Text find: " + textComponent.getComponentType());
        }
        List<String> tempList = new ArrayList<>();
        List<TextComponent> componentList = textComponent.getComponentList();
        for (TextComponent component : componentList) {
            TextComponent tempParagraphComponent = (TextComponent) component;
            List<TextComponent> sentencesList = tempParagraphComponent.getComponentList();
            List<TextComponent> listForDeleteComponent = new ArrayList<>();
            for (TextComponent sentence : sentencesList) {
                if (sentence.getComponentList().size() < count) {
                    listForDeleteComponent.add(sentence);
                }
            }
            for (TextComponent deleteComponent : listForDeleteComponent) {
                tempParagraphComponent.remove(deleteComponent);
            }
        }
    }

    @Override
    public Map<String, Integer> findIdenticalWords(TextComponent textComponent) throws CustomCompositeException {
        LOGGER.info("Method to find identical words called");
        if (textComponent == null || textComponent.getComponentType() != TextComponentType.TEXT) {
            throw new CustomCompositeException("Introduced text component null or has incorrect type. " +
                    "Must be Text find: " + textComponent.getComponentType());
        }
        List<TextComponent> componentList = textComponent.getComponentList();
        List<String> lexemesList = new ArrayList<>();
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher;
        for (TextComponent component : componentList) {
            TextComponent tempParagraphComponent = component;
            List<TextComponent> tempSentencesList = tempParagraphComponent.getComponentList();
            for (TextComponent sentence : tempSentencesList) {
                TextComponent tempSentenceComponent = sentence;
                List<TextComponent> tempLexemeList = tempSentenceComponent.getComponentList();
                for (TextComponent lexeme : tempLexemeList) {
                    String tempStringLexeme = lexeme.toString();
                    matcher = pattern.matcher(tempStringLexeme);
                    if (matcher.find()) {
                        lexemesList.add(matcher.group());
                    }
                }
            }
        }
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < lexemesList.size(); i++) {
            String word = lexemesList.get(i);
            if (!wordMap.containsKey(word)) {
                int count = 1;
                for (int j = i + 1; j < lexemesList.size(); j++) {
                    if (word.equalsIgnoreCase(lexemesList.get(j))) {
                        count++;
                    }
                }
                if (count > 1) {
                    wordMap.put(word, count);
                }
            }
        }
        return wordMap;
    }

    @Override
    public String numberOfLetters(TextComponent textComponent) throws CustomCompositeException {
        LOGGER.info("Method to find number of vowels and consonants letters called.");
        if (textComponent == null || textComponent.getComponentType() != TextComponentType.SENTENCE) {
            throw new CustomCompositeException("Incorrect type. Must be: Sentence find: " + textComponent.getComponentType());
        }
        String sentence = textComponent.toString();
        int vowelsCount = findCountWithRegex(sentence, VOWEL_REGEX);
        int consonantsCount = findCountWithRegex(sentence, LETTERS_REGEX) - vowelsCount;
        String result = "number of vowels letters in sentence: " + vowelsCount +
                "\nnumber of consonants letters in sentence: " + consonantsCount;
        return result;
    }

    private int findCountWithRegex(String string, String regex) {
        int count = 0;
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

}
