package by.htp.shape.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    final static String REGEX = "^([-]?\\d+(\\.\\d+)*+\\s){7}[-]?\\d+(\\.\\d+)*$";
    private static Logger logger = LogManager.getLogger();

    public double[] parseDataLine(String line) {

        double[] arrValues;
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            arrValues = Arrays.stream(line.split("(\\s)+")).mapToDouble(Double::parseDouble).toArray();
        } else {
            arrValues = null;
            logger.warn("Data line incorrect >> passed...");
        }

        return arrValues;
    }
}
