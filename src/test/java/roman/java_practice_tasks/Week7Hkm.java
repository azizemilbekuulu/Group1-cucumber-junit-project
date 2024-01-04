package roman.java_practice_tasks;
import java.util.PriorityQueue;

public class Week7Hkm {
    public static int findMax(int[] array) {
        if (array.length == 0)
            throw new IllegalArgumentException();

        int max = array[0];
        for (int each : array) {
            if (each > max)
                max = each;
        }

        return max;
    }

    public static int[] sortAscending(int[] array) {
        var priorityQueue = new PriorityQueue<Integer>();
        for (int each : array) {
            priorityQueue.add(each);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = priorityQueue.remove();
        }

        return array;
    }

    public static int[] sortDescending(int[] array) {
        var priorityQueue = new PriorityQueue<Integer>();
        for (int each : array) {
            priorityQueue.add(each);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = priorityQueue.remove();
        }

        return array;
    }
}
