package myalgo.prioritqueue.findingcars;

public class Car {
    String id;
    int x;
    int y;

    public Car(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int distanceCompare() {
        return x*x + y*y;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
