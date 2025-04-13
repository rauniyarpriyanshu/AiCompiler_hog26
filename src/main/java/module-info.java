module com.hog26.aicompiler {

    requires javafx.controls;
    requires javafx.fxml;
    requires bsh;
    requires org.fife.RSyntaxTextArea;
    requires fr.brouillard.oss.cssfx;
    requires javafx.swing;
    requires atlantafx.base;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires reactfx;
    requires org.fxmisc.richtext;
    requires org.fxmisc.flowless;
    requires org.json;


    opens com.hog26.aicompiler to javafx.fxml;
    exports com.hog26.aicompiler;
    exports com.hog26.aicompiler.controller;
    opens com.hog26.aicompiler.controller to javafx.fxml;
    exports com.hog26.aicompiler.controller.menu;
    opens com.hog26.aicompiler.controller.menu to javafx.fxml;
    exports com.hog26.aicompiler.api;
    opens com.hog26.aicompiler.api to javafx.fxml;

}