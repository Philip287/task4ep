package by.suprun.task4.validator.impl;

import by.suprun.task4.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ValidatorImpl implements Validator {
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public boolean validateFilePath(String path) {
        LOGGER.info("Method of validation filepath called with next options: " + path);
        if (path == null || path.isEmpty() || path.trim().isEmpty()) {
            return false;
        }
        boolean flag = false;
        File file = new File(path);
        if (file.exists()) {
            if (file.length() > 0) {
                flag = true;
            }
        }
        return flag;
    }
}
