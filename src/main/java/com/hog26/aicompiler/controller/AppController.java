package com.hog26.aicompiler.controller;

import com.hog26.aicompiler.component.CodeEditorJava;
import com.hog26.aicompiler.controller.menu.AIMenuItemController;
import com.hog26.aicompiler.controller.menu.EditMenuItemController;
import com.hog26.aicompiler.controller.menu.FileMenuItemController;
import com.hog26.aicompiler.controller.menu.RunCodeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CodeArea;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    private final String FONT_PATH = "/fonts/";
    private final String BOLD_POPPIN = FONT_PATH + "Poppins-Bold.ttf";
    private final String MEDIUM_POPPIN = FONT_PATH + "Poppins-Medium.ttf";
    private FileMenuItemController fileMenuListener;
    private EditMenuItemController editItemListener;
    @FXML
    private Label titleText;
    @FXML
    private AnchorPane codeArea;
    @FXML
    private VBox containerMain;
    @FXML
    private AnchorPane codeEditorContainer;
    private RunCodeListener runCodeListener;

    @FXML
    private TextArea consoleTextArea;
    private AIMenuItemController aiItemListener;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CodeEditorJava codeEditorJava = new CodeEditorJava();
        VirtualizedScrollPane<CodeArea> box = codeEditorJava.getCode();

        codeEditorContainer.getChildren().add(box);
        AnchorPane.setTopAnchor(box, 0.0);
        AnchorPane.setBottomAnchor(box, 0.0);
        AnchorPane.setLeftAnchor(box, 0.0);
        AnchorPane.setRightAnchor(box, 0.0);

        fileMenuListener = new FileMenuItemController();
        editItemListener = new EditMenuItemController(codeEditorJava.getCodeArea());
        runCodeListener = new RunCodeListener(codeEditorJava);
        aiItemListener=new AIMenuItemController();
    }

    @FXML
    public void onMenuItemClicked(ActionEvent actionEvent) {
        fileMenuListener.onClick(actionEvent);
    }

    @FXML
    public void onEditMenuClicked(ActionEvent event) {
        editItemListener.onClick(event);
    }

    @FXML
    public void onRunCode(ActionEvent event) {

        runCodeListener.runCode(consoleTextArea);
    }

    @FXML
    public void onAiMenuItemClicked(ActionEvent actionEvent){
        aiItemListener.onClick(actionEvent);
    }
}