module com.hog26.aicompiler {
    requires javafx.controls;
    requires javafx.fxml;
    requires bsh;
    requires MaterialFX;
    requires org.fife.RSyntaxTextArea;
    requires fr.brouillard.oss.cssfx;
    requires javafx.swing;
    requires atlantafx.base;


    opens com.hog26.aicompiler to javafx.fxml;
    exports com.hog26.aicompiler;
    exports com.hog26.aicompiler.controller;
    opens com.hog26.aicompiler.controller to javafx.fxml;

}