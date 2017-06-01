package by.htp.shape.service.impl;

import by.htp.shape.entity.Line;
import by.htp.shape.exception.PairLinesException;
import by.htp.shape.service.DataService;

public class PairLinesService implements DataService {

    @Override
    public double calculateAngle(Line line1, Line line2) throws PairLinesException {
        if (line1 == null || line2 == null) {
            throw new PairLinesException("One line or both lines is null");
        }

        double angle1 = calculateAngle(line1);
        double angle2 = calculateAngle(line2);
        return Math.abs(angle1 - angle2);
    }

    @Override
    public double calculateDistance(Line line1, Line line2) throws PairLinesException {
        if (line1 == null || line2 == null) {
            throw new PairLinesException("One line or both lines is null");
        }

        if (!isLinesParallel(line1, line2)) {
            return 0D;
        }
        double x1 = line1.getPointA().getX();
        double x2 = line1.getPointB().getX();
        double y1 = line1.getPointA().getY();
        double y2 = line1.getPointB().getY();

        double normalLength = Math.hypot((x2 - x1), (y2 - y1));

        double px = line2.getPointA().getX();
        double py = line2.getPointA().getY();

        return Math.abs((px - x1) * (y2 - y1) - (py - y1) * (x2 - x1)) / normalLength;

    }

    private double calculateAngle(Line line) {
        double y = line.getPointA().getY() - line.getPointB().getY();
        double x = line.getPointA().getX() - line.getPointB().getX();
        return Math.abs(Math.toDegrees(Math.atan2(y, x)));
    }

    private boolean isLinesParallel(Line line1, Line line2) throws PairLinesException {
        double angle = calculateAngle(line1, line2);
        return Double.compare(angle, 0.0) == 0;
    }

}
