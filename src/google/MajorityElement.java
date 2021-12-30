package google;

import java.util.*;

public class MajorityElement {

    public static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map) {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {

                int comp = map.get(k2).compareTo(map.get(k1));

                if (comp == 0)
                    return 1;
                else
                    return comp;
            }
        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    public int majorityElement(final int[] A) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == null) {
                map.put(A[i], 0);
            }
            map.put(A[i], map.get(A[i]) + 1);
        }

        Map<Integer, Integer> sortedMap = valueSort(map);

        System.out.println(map);
        System.out.println(sortedMap.keySet());

        Iterator<Integer> iterator = sortedMap.keySet().iterator();

        return iterator.next();
    }

    public int majorityElement(final List<Integer> A) {

        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.size(); i++) {
            if (hm.containsKey(A.get(i))) {
                hm.put(A.get(i), hm.get(A.get(i)) + 1);
            } else {
                hm.put(A.get(i), 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int majority = -1;

        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                majority = entry.getKey();
            }
        }

        return majority;
    }

    public static void main(String[] args) {

        int[] A = new int[5];

        A[0] = 5;
        A[1] = 5;
        A[2] = 1;
        A[3] = 3;
        A[4] = 5;

        MajorityElement majorityElement = new MajorityElement();

        System.out.println(majorityElement.majorityElement(A));
    }
}
