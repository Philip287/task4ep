package by.suprun.task4.parser;

import by.suprun.task4.entity.AbstractTextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractTextParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String SENTENCE_REGEX = "[A-ZА-Я]((!=|\\w+\\.\\w+)|[^?!.(]|\\([^)]*)*[.?!]{1,3}";

    public SentenceParser() {

    }

    public SentenceParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parser(AbstractTextComponent textComponent, String data) {
        logger.info("Sentence parser start work!");
        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> sentenceList = new ArrayList<>();
        while (matcher.find()) {
            sentenceList.add(matcher.group());
        }
        for (String sentence : sentenceList) {
            TextComposite sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
            textComponent.add(sentenceComponent);
            if (nextParser != null) {
                nextParser.parser(sentenceComponent, sentence);
            }
        }
    }
}
