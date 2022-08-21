package rootcg.range_extraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static String rangeExtraction(int[] ints) {
        List<String> solution = new ArrayList<>();
        List<Integer> range = new ArrayList<>();

        range.add(ints[0]);
        for (int i = 1; i < ints.length; i++) {
            if (Math.abs(range.get(range.size() - 1) - ints[i]) != 1) {
                solution.add(compact(range));
                range.clear();
            }

            range.add(ints[i]);
        }

        solution.add(compact(range));
        return concat(solution, ",");
    }

    private static String compact(List<Integer> range) {
        if (range.size() < 3) {
            return concat(range, ",");
        }

        return String.format("%d-%d", range.get(0), range.get(range.size() - 1));
    }

    private static <T> String concat(Collection<T> collection, CharSequence delimiter) {
        return collection.stream().map(String::valueOf).collect(Collectors.joining(delimiter));
    }

}
