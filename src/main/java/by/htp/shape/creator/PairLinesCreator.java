package by.htp.shape.creator;


import by.htp.shape.entity.Line;
import by.htp.shape.entity.PairLines;
import by.htp.shape.entity.Point;
import by.htp.shape.exception.PairLinesException;
import by.htp.shape.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PairLinesCreator {
    private static Logger logger = LogManager.getLogger();

    public PairLines createPairLines(double[] dataArray) throws  PairLinesException{
        if (dataArray == null){
            throw  new PairLinesException("Data Array is empty");
        }

        DataValidator dataValidator = new DataValidator();

        Point a = new Point(dataArray[0], dataArray[1]);
        Point b = new Point(dataArray[2], dataArray[3]);
        Point c = new Point(dataArray[4], dataArray[5]);
        Point d = new Point(dataArray[6], dataArray[7]);

        PairLines pairLines = null;
        try {
            if (dataValidator.isPairLines(a, b, c, d)) {
                Line first = new Line(a, b);
                Line second = new Line(c, d);

                pairLines = new PairLines(first, second);
                logger.info("Add new " + pairLines);

            } else {
                logger.warn("Can not create PairLines >> points is equals");
            }
        } catch (PairLinesException e) {
            logger.warn("Can not create PairLines: ", e);
        }

        return pairLines;
    }

}
