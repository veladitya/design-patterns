package com.interview.visitor;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TableElement implements Element {
    private final List<List<String>> rows = Arrays.asList(
            Arrays.asList("Name", "Age"),
            Arrays.asList("Alice", "30"),
            Arrays.asList("Bob", "25")
    );

    @Override
    public void accept(Visitor visitor) {
        visitor.visitTable(this);
    }

    public List<List<String>> getRows() {
        return rows;
    }
}