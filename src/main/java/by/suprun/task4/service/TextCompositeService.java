package by.suprun.task4.service;

import by.suprun.task4.entity.TextComponent;
import by.suprun.task4.exception.CustomCompositeException;

import java.util.List;
import java.util.Map;

public interface TextCompositeService {
    public void paragraphSort(TextComponent textComponent) throws CustomCompositeException;

    public List<String> maxWordSentences(TextComponent textComponent) throws CustomCompositeException;

    public void removeSentencesWithWordCountLessThan(TextComponent textComponent, int count) throws CustomCompositeException;

    public Map<String, Integer> findIdenticalWords(TextComponent textComponent) throws CustomCompositeException;

    public String numberOfLetters(TextComponent textComponent) throws CustomCompositeException;
}
