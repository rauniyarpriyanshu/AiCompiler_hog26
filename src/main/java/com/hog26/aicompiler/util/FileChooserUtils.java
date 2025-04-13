package com.hog26.aicompiler.util;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class FileChooserUtils {
    public static File pickFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Java Files", "*.java")
        );
        return fileChooser.showOpenDialog(stage);
    }

    public static File saveFile(Stage stage, String fileName) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.setInitialFileName(fileName);
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Java Files", "*.java")
        );
        return fileChooser.showSaveDialog(stage);
    }

    public static File pickFolder(Stage stage) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a Folder");
        return directoryChooser.showDialog(stage);
    }
}
