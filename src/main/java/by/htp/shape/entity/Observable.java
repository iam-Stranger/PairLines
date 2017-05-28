package by.htp.shape.entity;

import by.htp.shape.provider.Observer;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();

}
