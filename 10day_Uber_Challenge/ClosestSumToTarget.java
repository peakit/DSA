import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Given two unsorted arrays of same length and a target,
// find the pair such that the sum is closest to the target
public class ClosestSumToTarget {

    private static class Pair {
        Integer first;
        Integer second;

        Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer first() {
            return this.first;
        }

        public Integer second() {
            return this.second;
        }

        @Override
        public String toString() {
            return "Pair [first=" + first + ", second=" + second + "]";
        }

    }

    public static void main(String[] args) {
        Integer[] l1 = { -1, 2, 4, 3, 5 };
        Integer[] l2 = { 7, 8, 10, 5, 4 };
        Integer target = 17;

        System.out.println(findClosest(sortArrays(l1), sortArrays(l2), target));
    }

    public static Integer[] sortArrays(Integer[] a) {
        List<Integer> aArray = Arrays.asList(a);
        Collections.sort(aArray);
        return aArray.toArray(new Integer[aArray.size()]);
    }

    public static Pair findClosest(Integer[] a, Integer[] b, Integer target) {
        int startIdx = 0, endIdx = a.length - 1;
        Integer minDiff = Integer.MAX_VALUE;
        Pair closestPair = null;
        for (int i = 0; i < a.length - 1; i++) {
            Integer diff = Math.abs(a[startIdx] + b[endIdx] - target);
            if (diff < minDiff) {
                minDiff = diff;
                startIdx++;
                closestPair = new Pair(a[startIdx], b[endIdx]);
            } else {
                endIdx--;
            }
        }
        return closestPair;
    }
}
