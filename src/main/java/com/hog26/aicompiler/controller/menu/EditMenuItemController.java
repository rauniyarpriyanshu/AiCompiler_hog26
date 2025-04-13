package com.hog26.aicompiler.controller.menu;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import org.fxmisc.richtext.CodeArea;

public class EditMenuItemController {

    public CodeArea area;

    public EditMenuItemController(CodeArea area) {
        this.area = area;
    }

    public void onClick(ActionEvent event) {
        String id = ((MenuItem) event.getSource()).getId();
        if (id.equals("clearItem")){
            area.replaceText(0,area.getLength(),"");
        }
    }

}
