package com.hog26.aicompiler.controller.menu;

import com.hog26.aicompiler.api.GeminiAPI;
import com.hog26.aicompiler.util.DialogBoxFx;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import org.kordamp.ikonli.javafx.FontIcon;

public class AIMenuItemController {
    private GeminiAPI geminiAPI;
    private String requestedId="";

    public AIMenuItemController() {
        geminiAPI = new GeminiAPI();
        geminiAPI.addResponseListener(new GeminiAPI.GeminiResponse() {
            @Override
            public void onError(String errorMessage) {
                if (requestedId.equals("aiCodeGenerator")){
                    DialogBoxFx.showAlert("Code Generation Failed!",errorMessage, Alert.AlertType.ERROR);
                }
            }

            @Override
            public void onSuccess(String response) {
                if (requestedId.equals("aiCodeGenerator")){
                    DialogBoxFx.showAlert("Code Generation Generated!",response, Alert.AlertType.NONE);
                }
            }

            @Override
            public void onResponseCode(int responseCode) {

            }
        });
    }

    public void request(String string, String internalPrompt) {
        geminiAPI.askGemini(string + " " + internalPrompt);
    }

    public void onClick(ActionEvent event) {
        String id = ((MenuItem) event.getSource()).getId();
        switch (id) {
            case "aiCodeGenerator" -> {
                //  DialogBoxFx.dialog("Hello","Message");
                DialogBoxFx.dialog("Code Generation", generateAiLayout(), 600, 300);
            }
        }
    }

    public VBox generateAiLayout() {
        TextArea area = new TextArea();
        area.setPromptText("Enter your prompt to generate code");
        Button button = new Button("Generate");
        FontIcon icon = new FontIcon("mdi2s-send");
        button.setGraphic(icon);
        button.setOnAction((event)->{
            requestedId="aiCodeGenerator";
            request(area.getText(),"[Don't response related to this, This is api request so please only response with given prompt, and write java code with documentation only. Additionally, Don't include main method and class templace if it is not included in the prompt part, but include if it says.]");
        });
        VBox box = new VBox(10, area, button);
        box.setPadding(new Insets(10));
        box.setAlignment(Pos.CENTER_RIGHT);
        return box;
    }


}
