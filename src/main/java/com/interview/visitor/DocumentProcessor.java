package com.interview.visitor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentProcessor {
    private final List<Element> elements;

    public DocumentProcessor(List<Element> elements) {
        this.elements = elements;
    }

    public void process(Visitor visitor) {
        elements.forEach(e -> e.accept(visitor));
    }
}

