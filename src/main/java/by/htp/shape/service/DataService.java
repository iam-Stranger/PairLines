package by.htp.shape.service;

import by.htp.shape.entity.Line;
import by.htp.shape.exception.PairLinesException;

public interface DataService {
    double calculateAngle(Line line1, Line line2) throws PairLinesException;
    double calculateDistance(Line line1, Line line2) throws PairLinesException;

}
