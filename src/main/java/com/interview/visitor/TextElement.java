package com.interview.visitor;

import org.springframework.stereotype.Component;

@Component
public class TextElement implements Element {
    private final String text = "The quick brown fox jumps over the lazy dog";

    @Override
    public void accept(Visitor visitor) {
        visitor.visitText(this);
    }

    public String getText() {
        return text;
    }
}