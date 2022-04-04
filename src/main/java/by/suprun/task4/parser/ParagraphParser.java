package by.suprun.task4.parser;

import by.suprun.task4.entity.AbstractTextComponent;
import by.suprun.task4.entity.TextComponentType;
import by.suprun.task4.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractTextParser {
    private static final Logger logger = LogManager.getLogger();
    private static final String PARAGRAPH_REGEX = "[^\\n\\t]+";

    public ParagraphParser() {
    }

    public ParagraphParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parser(AbstractTextComponent abstractTextComponent, String data) {
        logger.info("Start work paragraph parser!");
        Pattern pattern = Pattern.compile(PARAGRAPH_REGEX);
        Matcher matcher = pattern.matcher(data);
        ArrayList<String> listParagraphs = new ArrayList<>();
        while (matcher.find()) {
            listParagraphs.add(matcher.group());
        }
        for (String paragraph : listParagraphs) {
            TextComposite paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
            abstractTextComponent.add(paragraphComponent);
            if (nextParser != null) {
                nextParser.parser(paragraphComponent, paragraph);
            }
        }

    }
}
