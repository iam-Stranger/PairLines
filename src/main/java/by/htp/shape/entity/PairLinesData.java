package by.htp.shape.entity;

public class PairLinesData {
    private double angle;
    private double distance;

    public PairLinesData() {
    }

    public PairLinesData(double angle, double distance) {
        this.angle = angle;
        this.distance = distance;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PairLinesData that = (PairLinesData) o;

        if (Double.compare(that.angle, angle) != 0) return false;
        return Double.compare(that.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(angle);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(distance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PairLinesData{" +
                "angle=" + angle +
                ", distance=" + distance +
                '}';
    }
}
