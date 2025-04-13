package com.hog26.aicompiler.util;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogBoxFx {
    public static void dialog(String title, Parent layout, int width, int height) {
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setTitle(title);

        /*Label msgLabel = new Label(message);
        msgLabel.setStyle("-fx-font-size: 14px; -fx-padding: 10;");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> dialog.close());
        okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");

        HBox buttonBox = new HBox(okButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setStyle("-fx-padding: 10;");

        VBox layout = new VBox(10, msgLabel, buttonBox);
        layout.setStyle("-fx-background-color: #f4f4f4; -fx-border-color: #cccccc; -fx-border-width: 2px;");
        layout.setAlignment(Pos.CENTER);*/

        dialog.setScene(new Scene(layout, width, height));
        dialog.showAndWait();
    }

    public static void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.getButtonTypes().add(new ButtonType("Okay"));
        alert.showAndWait();
    }
}
