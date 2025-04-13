package com.hog26.aicompiler.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FxUtils {
    public static Stage getStageWhenClicked(ActionEvent event) {
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }
    public static Stage getStageFromEvent(ActionEvent event) {
        for (Window window : Window.getWindows()) {
            if (window.isFocused()) {
                return (Stage) window;
            }
        }
        return null;
    }
}
