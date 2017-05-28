package by.htp.shape.service.impl;

import by.htp.shape.entity.Line;
import by.htp.shape.service.DataService;

public class PairLinesService implements DataService {

    @Override
    public double calculateAngle(Line line1, Line line2) {
        double angle1 = calculateAngle(line1);
        double angle2 = calculateAngle(line2);
        return Math.abs(angle1 - angle2);
    }

    @Override
    public double calculateDistance(Line line1, Line line2) {
        return 0;
    }


    private double calculateAngle(Line line) {
        double y = line.getPointA().getY() - line.getPointB().getY();
        double x = line.getPointA().getX() - line.getPointB().getX();
        return Math.abs(Math.toDegrees(Math.atan2(y, x)));
    }

}
