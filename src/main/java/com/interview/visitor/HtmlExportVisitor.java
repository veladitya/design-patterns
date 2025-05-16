package com.interview.visitor;

import org.springframework.stereotype.Component;

@Component("htmlExportVisitor")
public class HtmlExportVisitor implements Visitor {
    @Override
    public void visitText(TextElement text) {
        System.out.println("<p>" + text.getText() + "</p>");
    }

    @Override
    public void visitImage(ImageElement image) {
        System.out.println("<img src='" + image.getUrl() + "'/> ");
    }

    @Override
    public void visitTable(TableElement table) {
        System.out.println("<table>");
        for (var row : table.getRows()) {
            System.out.print("  <tr>");
            for (var cell : row) {
                System.out.print("<td>" + cell + "</td>");
            }
            System.out.println("</tr>");
        }
        System.out.println("</table>");
    }
}