package com.interview.visitor;

public interface Visitor {
    void visitText(TextElement text);

    void visitImage(ImageElement image);

    void visitTable(TableElement table);
}