package by.suprun.task4.reader.impl;

import by.suprun.task4.exception.CustomCompositeException;
import by.suprun.task4.reader.DataReader;
import by.suprun.task4.validator.impl.ValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {
    @Override
    public String readFile(String path) throws CustomCompositeException {
        ValidatorImpl fileValidate = new ValidatorImpl();
        if (!fileValidate.validateFilePath(path)) {
            throw new CustomCompositeException("File is not exist or is empty or incorrect path");
        }
        ArrayList<String> lines;
        Path pathFile = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(pathFile)) {
            lines = lineStream.collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            throw new CustomCompositeException("Reading file is fail ", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : lines) {
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }
}

