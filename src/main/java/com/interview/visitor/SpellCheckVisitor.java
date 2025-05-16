package com.interview.visitor;

import org.springframework.stereotype.Component;

@Component("spellCheckVisitor")
public class SpellCheckVisitor implements Visitor {
    @Override
    public void visitText(TextElement text) {
        System.out.println("Spell-checking text: '" + text.getText() + "'");
        // dummy spell-check logic...
    }

    @Override
    public void visitImage(ImageElement image) {
        // nothing to spell-check
    }

    @Override
    public void visitTable(TableElement table) {
        // nothing to spell-check
    }
}
