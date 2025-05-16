package com.interview.visitor;

import org.springframework.stereotype.Component;

@Component
public class ImageElement implements Element {
    private final String url = "http://example.com/image.png";

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImage(this);
    }

    public String getUrl() {
        return url;
    }
}