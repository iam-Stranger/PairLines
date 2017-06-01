package by.htp.shape.parser;

import by.htp.shape.exception.PairLinesException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DataParserTest {
    @Parameterized.Parameter
    public String line;

    private static DataParser dataParser;

    @BeforeClass
    public static void init() {
        dataParser = new DataParser();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][]{
                {"-2.2 2 4 2 2.5 2 1 8"},
                {"2 0 0 2.2 2 -3 2.1 8"},
                {"-1 2 -2 0 8 1 9 11"},
                {"0 2 0 7777 2 7 1 1.1"}
        });
    }


    @Test
    public void parseDataLineTest() throws PairLinesException {
        double[] dataArray = dataParser.parseDataLine(line);
        int actual = dataArray.length;
        assertEquals(8, actual);
    }

}