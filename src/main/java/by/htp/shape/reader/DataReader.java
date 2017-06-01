package by.htp.shape.reader;

import by.htp.shape.exception.PairLinesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {
    private static Logger logger = LogManager.getLogger();

    public List<String> readDataFile(String filename) throws PairLinesException {
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(Paths.get(filename), Charset.forName("UTF-8"));
        } catch (IOException e) {
           logger.fatal("Data file not found, application stopped", e);
           throw new PairLinesException(e);
        }

        return stringList;
    }

}
