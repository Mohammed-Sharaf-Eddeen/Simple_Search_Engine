package search;

import java.util.List;

public class SearchStrategyContext {
    SearchStrategy strategy;

    public SearchStrategyContext(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> search(String keywords) {
        return this.strategy.search(keywords);
    }
}
