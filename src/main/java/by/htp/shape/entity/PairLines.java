package by.htp.shape.entity;

import by.htp.shape.provider.Observer;

import java.util.ArrayList;

public class PairLines implements Observable {
    private int id;
    private Line first;
    private Line second;
    private ArrayList<Observer> observerList = new ArrayList<Observer>();

    public PairLines() {
    }

    public PairLines(int id, Line first, Line second) {
        this.id = id;
        this.first = first;
        this.second = second;
    }

    @Override
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        int i = observerList.indexOf(observer);
        if (i >= 0){
            observerList.remove(i);
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer item : observerList) {
            Observer observer = (Observer) item;
            observer.update(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Line getFirst() {
        return first;
    }

    public void setFirst(Point a, Point b) {
        first.setPointA(a);
        first.setPointB(b);
        notifyObservers();
    }

    public Line getSecond() {
        return second;
    }

    public void setSecond(Point a, Point b) {
        second.setPointA(a);
        second.setPointB(b);
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairLines pairLines = (PairLines) o;

        if (first != null ? !first.equals(pairLines.first) : pairLines.first != null) return false;
        return second != null ? second.equals(pairLines.second) : pairLines.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PairLines{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
