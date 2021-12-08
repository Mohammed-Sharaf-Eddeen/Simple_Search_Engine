package search.strategies;

import search.SearchStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static search.Main.invertedIndex;

public class NoneSearchStrategy implements SearchStrategy {
    @Override
    public List<Integer> search(String keywords) {
        Set<Integer> linePositions = new HashSet<>();
        //adding all the values to the set in order for the intersect(retainAll) function to be applied on it later
        invertedIndex.forEach((key, val) -> linePositions.addAll(val));

        for (String keyword : keywords.split("\\s")) {
            if (invertedIndex.containsKey(keyword)) {
                //Applying the intersect function on the full list of all values
                linePositions.removeAll(invertedIndex.get(keyword));
            }
        }

        return new ArrayList<>(linePositions);
    }
}
