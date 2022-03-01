import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Build a DS which allows insert, delete and get operations in O(1). The get
 * operation needs to return a random number from the list.
 */
public class RandomDS {

    private static class ConstantTimeDS<T> {

        private List<T> internalDS;
        // Val => Index map
        private Map<T, Integer> internalPosMap;

        public ConstantTimeDS() {
            internalDS = new ArrayList<>();
            internalPosMap = new HashMap<>();
        }

        /**
         * Insert a new value
         * 
         * @param val
         */
        public synchronized void insert(T val) {
            Integer idx = internalDS.size();
            internalDS.add(val);
            internalPosMap.putIfAbsent(val, idx);
        }

        /**
         * Delete element from list
         * 
         * @param val
         */
        public synchronized void delete(T val) {
            Integer idx = internalPosMap.get(val);
            if (idx != null) {
                // Swap value with the last value in the array for O(1) removal. As an
                // alternative, it would be wrong to use list.add(idx, val) since that
                // internally shifts the values to the right.
                Integer lastIdx = internalDS.size() - 1;
                T lastValue = internalDS.get(lastIdx);

                Collections.swap(internalDS, idx, lastIdx);
                internalPosMap.put(lastValue, idx);

                // now remove the last element
                internalDS.remove(lastIdx.intValue());
                internalPosMap.remove(val);
            }
        }

        /**
         * Returns a random number from DS
         * 
         * @return a random number from DS
         */
        public synchronized T get() {
            Integer min = 0;
            Integer max = internalDS.size();

            int randomIdx = (int) (Math.random() * (max - min) + min);
            return internalDS.get(randomIdx);
        }

        public String print() {
            return internalDS.toString();
        }
    }

    public static void main(String[] args) {
        ConstantTimeDS<String> csDS = new ConstantTimeDS<>();
        csDS.insert("1");
        csDS.insert("2");
        csDS.insert("3");
        csDS.insert("4");
        csDS.insert("5");

        System.out.println(csDS.print());
        System.out.println(csDS.get());
        System.out.println(csDS.print());

        csDS.delete("2");
        System.out.println(csDS.print());
    }
}
