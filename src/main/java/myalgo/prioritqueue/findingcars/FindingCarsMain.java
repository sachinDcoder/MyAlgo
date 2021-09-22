package myalgo.prioritqueue.findingcars;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindingCarsMain {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("c1", 1, 1));
        cars.add(new Car("c2", 2, 1));
        cars.add(new Car("c3", 3, 2));
        cars.add(new Car("c4", 0, 1));
        cars.add(new Car("c5", 2, 3));

        getMinDistCars(cars, n, k).stream().forEach(System.out::println);
    }

    private static List<String> getMinDistCars(List<Car> cars, int n, int k) {
        List<String> kDistCars = new ArrayList<>();

        PriorityQueue<Car> priorityQueue = new PriorityQueue<>((c1, c2) -> c2.distanceCompare() - c1.distanceCompare());
        for(int i = 0; i < k; i++) {
            priorityQueue.add(cars.get(i));
        }

        System.out.println(priorityQueue.peek());

        for(int i = k; i < n; i++) {

            if(cars.get(i).distanceCompare() < priorityQueue.peek().distanceCompare()) {
                priorityQueue.poll();
                priorityQueue.add(cars.get(i));
            }
        }

        while(!priorityQueue.isEmpty()) {
            kDistCars.add(priorityQueue.poll().id);
        }

        return kDistCars;
    }
}
