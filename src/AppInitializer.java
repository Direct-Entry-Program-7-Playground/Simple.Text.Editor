import controller.EditorFormController;
import javafx.application.Application;
import javafx.event.ActionEvent;
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

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("./view/EditorForm.fxml"));
        AnchorPane root = fxmlLoader.load();
        EditorFormController editorFormController = fxmlLoader.getController();
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

            editorFormController.exit(event);
        });
    }
}
