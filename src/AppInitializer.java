import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.prefs.Preferences;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        // Reading preferences for the user
        boolean isMaximized = Preferences.userRoot().node("lk.ijse.simple-text-editor").getBoolean("is-maximized", false);
        double xPos = Preferences.userRoot().node("lk.ijse.simple-text-editor").getDouble("xPos", -1);
        double yPos = Preferences.userRoot().node("lk.ijse.simple-text-editor").getDouble("yPos", -1);
        double width = Preferences.userRoot().node("lk.ijse.simple-text-editor").getDouble("width", -1);
        double height = Preferences.userRoot().node("lk.ijse.simple-text-editor").getDouble("width", -1);


        AnchorPane root = FXMLLoader.load(getClass().getResource("./view/EditorForm.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Text Editor");
        primaryStage.getIcons().add(new Image("asset/img/SimpleTextEditorIcon.png"));
        primaryStage.show();

        // Set Editor window size
        if (isMaximized) {
            primaryStage.setMaximized(true);
        } else {
            primaryStage.setWidth(width == -1 ? root.getPrefWidth() : width);
            primaryStage.setHeight(height == -1 ? root.getPrefHeight() : height);
        }

        
    }
}
