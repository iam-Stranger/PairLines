package by.htp.shape.service.impl;

import by.htp.shape.entity.Line;
import by.htp.shape.entity.Point;
import by.htp.shape.exception.PairLinesException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class PairLinesServiceTest {
    private static PairLinesService pairLinesService;

    @BeforeClass
    public static void init() {
        pairLinesService = new PairLinesService();
    }

    @Test(expected = PairLinesException.class)
    public void calculateDistanceNullData() throws PairLinesException {
        Line line1 = null;
        Line line2 = null;
        double distance = pairLinesService.calculateDistance(line1, line2);
    }

    @Test(expected = PairLinesException.class)
    public void calculateAngleNullData() throws PairLinesException {
        Line line1 = null;
        Line line2 = null;
        double distance = pairLinesService.calculateAngle(line1, line2);
    }

    @Test
    public void calculateCorrectAngle45Degree() throws Exception {
        Point line1PointA = new Point(1, 1);
        Point line1PointB = new Point(1, 2);
        Line line1 = new Line(line1PointA, line1PointB);

        Point line2PointA = new Point(1, 1);
        Point line2PointB = new Point(2, 2);
        Line line2 = new Line(line2PointA, line2PointB);

        assertEquals(45, pairLinesService.calculateAngle(line1, line2), 0.0);
    }

    @Test
    public void calculateCorrectAngle90Degree() throws Exception {
        Point line1PointA = new Point(2, 1);
        Point line1PointB = new Point(2, 2);
        Line line1 = new Line(line1PointA, line1PointB);

        Point line2PointA = new Point(1, 1);
        Point line2PointB = new Point(2, 1);
        Line line2 = new Line(line2PointA, line2PointB);

        assertEquals(90, pairLinesService.calculateAngle(line1, line2), 0.0);
    }

    @Test
    public void calculateIncorrectAngle() throws Exception {
        Point line1PointA = new Point(2, 2);
        Point line1PointB = new Point(3, 2);
        Line line1 = new Line(line1PointA, line1PointB);

        Point line2PointA = new Point(2, 3);
        Point line2PointB = new Point(3, 3);
        Line line2 = new Line(line2PointA, line2PointB);
        assertEquals("Angle is incorrect", 0, pairLinesService.calculateAngle(line1, line2), 0.0);
    }

    @Test
    public void calculateDistanceBetweenParallelLines() throws PairLinesException {
        Point line1pointA = new Point(1, 1);
        Point line1pointB = new Point(1, 2);
        Line line1 = new Line(line1pointA, line1pointB);

        Point line2pointA = new Point(2, 1);
        Point line2pointB = new Point(2, 2);
        Line line2 = new Line(line2pointA, line2pointB);

        double distance = pairLinesService.calculateDistance(line1, line2);

        assertNotEquals(0, distance, 0.0);
    }


    @Test
    public void calculateDistanceBetweenNotParallelLines() throws Exception {
        Point line1pointA = new Point(1, 1);
        Point line1pointB = new Point(2, 1);
        Line line1 = new Line(line1pointA, line1pointB);

        Point line2pointA = new Point(2, 1);
        Point line2pointB = new Point(2, 2);
        Line line2 = new Line(line2pointA, line2pointB);

        double distance = pairLinesService.calculateDistance(line1, line2);

        assertEquals("Distance is incorrect", 0, distance, 0.0);
    }

    @Test
    public void possibleLineByTwoPoint() {
        Point line1point1 = new Point(1, 1);
        Point line1point2 = new Point(2, 1);

        assertNotEquals(line1point1, line1point2);
    }

    @Test
    public void impossibleLineByTwoPoint() {
        Point line1point1 = new Point(1, 1);
        Point line1point2 = new Point(1, 1);

        assertEquals(line1point1, line1point2);
    }

}