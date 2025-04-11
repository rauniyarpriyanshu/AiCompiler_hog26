package com.hog26.aicompiler.util;


import javafx.scene.text.Font;

import java.io.InputStream;

public class ApplicationHelper {
    /*private ApplicationHelper helper = null;

    private InputStream resourceHelper;

    public ApplicationHelper(InputStream stream) {
        resourceHelper = stream;
    }*/

    public static Font getFont(InputStream stream, int size) {
        return Font.loadFont(stream, size);
    }


}
