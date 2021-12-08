package search.strategies;

import search.SearchStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static search.Main.invertedIndex;

public class AnySearchStrategy implements SearchStrategy {
    @Override
    public List<Integer> search(String keywords) {
        Set<Integer> linePositions = new HashSet<>();

        for (String keyword : keywords.split("\\s")) {
            if (invertedIndex.containsKey(keyword)) {
                linePositions.addAll(invertedIndex.get(keyword));
            }
        }
        return new ArrayList<>(linePositions);
    }
}
