package by.htp.shape.entity;

public class Line {
    private Point a;
    private Point b;

    public Line() {
    }

    public Line(Point point1, Point point2) {
        this.a = point1;
        this.b = point2;
    }

    public Point getPointA() {
        return a;
    }

    public void setPointA(Point a) {
        this.a = a;
    }

    public Point getPointB() {
        return b;
    }

    public void setPointB(Point b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (a != null ? !a.equals(line.a) : line.a != null) return false;
        return b != null ? b.equals(line.b) : line.b == null;
    }

    @Override
    public int hashCode() {
        int result = a != null ? a.hashCode() : 0;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointA=" + a +
                ", pointB=" + b +
                '}';
    }
}
