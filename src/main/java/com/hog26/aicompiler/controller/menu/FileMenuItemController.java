package com.hog26.aicompiler.controller.menu;

import com.hog26.aicompiler.util.FileChooserUtils;
import com.hog26.aicompiler.util.FxUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;

import java.io.File;

public class FileMenuItemController {

    public void onClick(ActionEvent actionEvent) {
        String id = ((MenuItem) actionEvent.getSource()).getId();
        if (id.equals("openFileItem")) {
            File file = FileChooserUtils.pickFile(FxUtils.getStageFromEvent(actionEvent));
            if (file != null) {
                System.out.println("File picked");
            } else {
                System.out.println("File failed");
            }
        } else if (id.equals("saveFileItem")) {
            System.out.println("saved");
        } else if (id.equals("saveAsItem")) {
            File file = FileChooserUtils.saveFile(FxUtils.getStageFromEvent(actionEvent), "abc.java");

            if (file != null) {
                System.out.println("File picked " + file.getAbsolutePath());
            } else {
                System.out.println("File failed");
            }
        }
    }
}
