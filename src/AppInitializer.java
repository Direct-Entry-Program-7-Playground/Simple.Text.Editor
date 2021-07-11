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
        boolean isMaximized = Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getBoolean("is-maximized", false);
        double width = Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getDouble("width", -1);
        double height = Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getDouble("height", -1);
        double xPos = Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getDouble("xPos", -1);
        double yPos = Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getDouble("yPos", -1);

        AnchorPane root = FXMLLoader.load(getClass().getResource("./view/EditorForm.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Text Editor");
        primaryStage.getIcons().add(new Image("asset/img/SimpleTextEditorIcon.png"));

        // Set Editor window size
        if (isMaximized) {
            primaryStage.setMaximized(true);
        } else {
            primaryStage.setWidth(width == -1 ? root.getPrefWidth() : width);
            primaryStage.setHeight(height == -1 ? root.getPrefHeight() : height);
        }

        // Set Editor window position
        if (xPos == -1 & yPos == -1) {
            primaryStage.centerOnScreen();
        } else {
            primaryStage.setX(xPos == -1 ? primaryStage.getX() : xPos);
            primaryStage.setY(yPos == -1 ? primaryStage.getY() : yPos);
        }

        primaryStage.show();

        // Set user preferences on close of primaryStage
        primaryStage.setOnCloseRequest(event -> {

            Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").putBoolean("is-maximized", primaryStage.isMaximized());
            Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").putDouble("width", root.getWidth());
            Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").putDouble("height", root.getHeight());
            Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").putDouble("xPos", primaryStage.getX());
            Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").putDouble("yPos", primaryStage.getY());
        });
    }
}
