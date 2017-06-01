package by.htp.shape;

import by.htp.shape.creator.PairLinesCreator;
import by.htp.shape.entity.Line;
import by.htp.shape.entity.PairLines;
import by.htp.shape.entity.PairLinesData;
import by.htp.shape.entity.Point;
import by.htp.shape.exception.PairLinesException;
import by.htp.shape.parser.DataParser;
import by.htp.shape.provider.StorageProvider;
import by.htp.shape.provider.StorageUtils;
import by.htp.shape.reader.DataReader;
import by.htp.shape.service.DataService;
import by.htp.shape.service.ServiceFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class MainTest {
    @Parameterized.Parameter
    public String line;

    private static final String PATH_TO_DATAFILE = "files/data.txt";
    private static final long NUMBER_OF_RECORD = 1000;

    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
                { "-2.4 2 4.3 -2 2 2.9 2 4"},
                { "1 2 -3 4 4 3 2 1"},
                { "1 3 1 5 2 3 2 5"}
        });
    }

    @Test
    public void mainTestApplication() throws PairLinesException {

        DataReader dataReader = new DataReader();
        StorageProvider storageProvider = StorageProvider.getInstance();
        PairLinesCreator pairLinesCreator = new PairLinesCreator();
        DataParser dataParser = new DataParser();

        ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
        DataService dataService = serviceFactoryObject.getDataService();

        double[] arrValues = dataParser.parseDataLine(line);

        PairLines pairLinesTemp = pairLinesCreator.createPairLines(arrValues);
        storageProvider.addRecord(pairLinesTemp);

        Point a = new Point(2, 3);
        Point b = new Point(3, 3);
        Point c = new Point(3, 3);
        Point d = new Point(3, 0);

        double angle = dataService.calculateAngle(new Line(a, b), new Line(c,d));
        double distance = dataService.calculateDistance(new Line(a, b), new Line(c,d));
        PairLinesData testPairLinesData = new PairLinesData(angle, distance);

        PairLines pairLines = storageProvider.findPairLinesById(NUMBER_OF_RECORD);
        pairLines.setFirst(a, b);
        pairLines.setSecond(c, d);
        PairLinesData pairLinesData = storageProvider.findPairLinesDataById(NUMBER_OF_RECORD);

        assertEquals(pairLinesData, testPairLinesData);

    }


}
