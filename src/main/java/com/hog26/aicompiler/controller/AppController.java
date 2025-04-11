package com.hog26.aicompiler.controller;

import com.hog26.aicompiler.component.SwingRsyntaxCode;
import com.hog26.aicompiler.util.ApplicationHelper;
import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.fife.ui.rsyntaxtextarea.Theme;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    private final String FONT_PATH = "/fonts/";
    private final String BOLD_POPPIN = FONT_PATH + "Poppins-Bold.ttf";
    private final String MEDIUM_POPPIN = FONT_PATH + "Poppins-Medium.ttf";
    SwingRsyntaxCode code;
    @FXML
    private Label titleText;
    @FXML
    private AnchorPane codeArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titleText.setFont(ApplicationHelper.getFont(getClass().getResourceAsStream(MEDIUM_POPPIN), 24));


        SwingNode node = new SwingNode();
        code = new SwingRsyntaxCode();
        code.createView(node);
        Platform.runLater(() -> {
                    codeArea.getChildren().add(node);
                    applyDarkTheme();
                }
        );
    }

    private void applyDarkTheme() {
        SwingUtilities.invokeLater(() -> {
            try (InputStream in = getClass().getResourceAsStream(
                    "/org/fife/ui/rsyntaxtextarea/themes/dark.xml")) {
                if (in != null) {
                    Theme theme = Theme.load(in);
                    theme.apply(code.getCodeArea());
                } else {
                    System.err.println("Theme file not found!");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}