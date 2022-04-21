package by.suprun.task4.reader.impl;

import by.suprun.task4.exception.CustomCompositeException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataReaderImplTest {
    private static final String PATH_TO_FILE = "src/test/resources/dataTest.txt";
    private static final String EXPECTED = " It has survived - not only (five) centuries, but also the leap into electronic typesetting,\n" +
            "remaining -3-5 essentially 6*9/(3+4) unchanged. It was popularised in the 5*(1+2*(3/(4-(1-56-\n" +
            "47)*73)+(-89+4/(42/7)))+1) with the release of Letraset sheets containing Lorem Ipsum passages,\n" +
            "and more recently with desktop publishing software like Aldus PageMaker including versions of\n" +
            "Lorem Ipsum.\n" +
            " It is a long established fact that a reader will be distracted by the readable content of a page\n" +
            "when looking at its layout. The point of using (-71+(2+3/(3*(2+1/2+2)-2)/10+2))/7 Ipsum is that it has\n" +
            "a more-or-less normal distribution of letters, as opposed to using (Content here), content here',\n" +
            "making it look like readable English.\n" +
            " It is a (7+5*12*(2+5-2-71))/12 established fact that a reader will be of a page when looking\n" +
            "at its layout.\n" +
            " Bye.\n";

    @Test
    public void DataReaderImplTest() throws CustomCompositeException {
        DataReaderImpl reader = new DataReaderImpl();
        String actual = reader.readFile(PATH_TO_FILE);
        Assert.assertEquals(actual, EXPECTED);
    }

}