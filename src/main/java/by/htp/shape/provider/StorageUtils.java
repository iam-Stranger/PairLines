package by.htp.shape.provider;

import by.htp.shape.creator.PairLinesCreator;
import by.htp.shape.entity.PairLines;
import by.htp.shape.exception.PairLinesException;
import by.htp.shape.parser.DataParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StorageUtils {
    private static Logger logger = LogManager.getLogger();

    public void init(List<String> stringList) {
        StorageProvider storageProvider = StorageProvider.getInstance();
        PairLinesCreator pairLinesCreator = new PairLinesCreator();
        DataParser dataParser = new DataParser();

        for (String line : stringList) {
            double[] arrValues = dataParser.parseDataLine(line);

            PairLines pairLines = null;
            try {
                pairLines = pairLinesCreator.createPairLines(arrValues);
                storageProvider.addRecord(pairLines);
            } catch (PairLinesException e) {
                logger.warn("Can not create PairLines "+ e);
            }


        }


    }

}
