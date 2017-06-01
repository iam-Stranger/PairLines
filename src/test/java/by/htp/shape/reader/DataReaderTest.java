package by.htp.shape.reader;

import by.htp.shape.exception.PairLinesException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DataReaderTest {
    private static DataReader dataReader;
    final String DATAFILE_PATH = "files/data.txt";
    final String WRONG_PATH = "does_not_exist.txt";

    @BeforeClass
    public static void init() {
        dataReader = new DataReader();
    }

    @Test (expected = RuntimeException.class)
    public void readDataFileNotFound() throws PairLinesException {
        List<String> dataList = dataReader.readDataFile(WRONG_PATH);
    }

    @Test
    public void readDataFileSuccess() throws PairLinesException {
        List<String> dataList = dataReader.readDataFile(DATAFILE_PATH);
        int realCountLines = dataList.size();
        int expectedCountLines = 7;
        assertEquals(expectedCountLines, realCountLines);
    }

}