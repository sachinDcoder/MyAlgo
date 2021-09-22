package myalgo.hashing.countingtriangle;

import java.util.HashMap;

public class CountTriangleMain {
    public static void main(String[] args) {
        int[][] points = {{1, 2}, {2, 0}, {2, 2}, {2, 3}, {4, 2}};

        System.out.println(countNumberOfRightAngledTriangle(points));
    }

    private static int countNumberOfRightAngledTriangle(int[][] points) {
        HashMap<Integer, Integer> xCounts = new HashMap<>();
        HashMap<Integer, Integer> yCounts = new HashMap<>();
        int count = 0;

        for(int i = 0; i < points.length; i++) {
            if(xCounts.containsKey(points[i][0])) {
                xCounts.put(points[i][0], xCounts.get(points[i][0]) + 1);
            } else {
                xCounts.put(points[i][0], 1);
            }

            if(yCounts.containsKey(points[i][1])) {
                yCounts.put(points[i][1], yCounts.get(points[i][1]) + 1);
            } else {
                yCounts.put(points[i][1], 1);
            }
        }

        for(int i = 0; i < points.length; i++) {
            count += (xCounts.get(points[i][0]) - 1) * (yCounts.get(points[i][1]) - 1);
        }

        return count;
    }
}
