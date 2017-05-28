package by.htp.shape.service;

import by.htp.shape.entity.Line;

public interface DataService {
    double calculateAngle(Line line1, Line line2);
    double calculateDistance(Line line1, Line line2);

}
