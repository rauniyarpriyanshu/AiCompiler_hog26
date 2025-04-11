package com.hog26.aicompiler.component;

import javafx.embed.swing.SwingNode;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class SwingRsyntaxCode {
    public InputStream resourceClass;
    private RSyntaxTextArea codeArea;

    public SwingRsyntaxCode() {

    }

    public SwingRsyntaxCode(InputStream stream) {
        resourceClass = stream;
    }

    public RSyntaxTextArea getCodeArea() {
        return codeArea;
    }

    public void createView(SwingNode node) {
        SwingUtilities.invokeLater(() -> {
            codeArea = new RSyntaxTextArea(25, 120);
            codeArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
            codeArea.setCodeFoldingEnabled(true);
            codeArea.setBackground(Color.BLACK);
            codeArea.setForeground(Color.WHITE);
            codeArea.setHighlightCurrentLine(false);
            codeArea.setCurrentLineHighlightColor(Color.WHITE);

            RTextScrollPane pane = new RTextScrollPane(codeArea);
            pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
            pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


            node.setContent(pane);

        });
    }



}
