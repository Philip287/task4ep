package by.suprun.task4.reader;

import by.suprun.task4.exception.CustomCompositeException;

public interface DataReader {
    public String readFile(String path) throws CustomCompositeException;
}
