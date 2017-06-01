package by.htp.shape.validator;

import by.htp.shape.entity.Point;
import by.htp.shape.exception.PairLinesException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DataValidatorTest {
    private static DataValidator dataValidator;

    @BeforeClass
    public static void init() {
        dataValidator = new DataValidator();
    }


    @Test (expected = PairLinesException.class)
    public void isPointsNull() throws PairLinesException{
        Point a = null;
        Point b = new Point(7,7);
        Point c = new Point(3,4);
        Point d = new Point(2,1);
        dataValidator.isPairLines(a,b,c,d);
    }


    @Test
    public void isPointsEquals() throws PairLinesException {
        DataValidator dataValidator = new DataValidator();
        Point a = new Point(7,7);
        Point b = new Point(7,7);
        Point c = new Point(3,4);
        Point d = new Point(2,1);
        assertFalse(dataValidator.isPairLines(a,b,c,d));
    }

    @Test
    public void isPointsNotEquals() throws PairLinesException {
        DataValidator dataValidator = new DataValidator();
        Point a = new Point(7,3);
        Point b = new Point(3,7);
        Point c = new Point(3,4);
        Point d = new Point(2,1);
        assertTrue(dataValidator.isPairLines(a,b,c,d));
    }

}