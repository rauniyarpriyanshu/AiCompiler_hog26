package com.hog26.aicompiler;

import atlantafx.base.theme.PrimerDark;
import atlantafx.base.theme.PrimerLight;
import fr.brouillard.oss.cssfx.CSSFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Instruction from The library of MaterialFX to implement material design
    /*    CSSFX.start();
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.MODENA)
                .themes(MaterialFXStylesheets.forAssemble(true))
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();
*/
        Application.setUserAgentStylesheet( new PrimerLight().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("appview.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 600);
        stage.setTitle("AI Compiler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}