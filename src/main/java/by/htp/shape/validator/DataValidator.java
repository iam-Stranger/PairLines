package by.htp.shape.validator;

import by.htp.shape.entity.Point;
import by.htp.shape.exception.PairLinesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DataValidator {
    private static Logger logger = LogManager.getLogger();

    public boolean isPairLines(Point a, Point b, Point c, Point d) throws PairLinesException {
        if (a == null || b == null || c == null || d == null) {
            throw new PairLinesException("One or more points is null");
        }

        return (!a.equals(b) && !c.equals(d));
    }

}
