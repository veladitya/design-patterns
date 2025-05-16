package com.interview.visitor;

public interface Element {
    void accept(Visitor visitor);
}