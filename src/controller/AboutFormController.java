/*
 * Copyright (c) 2021 Manoj Randeni. All rights reserved.
 * Licensed under the Apache license. See License.txt in the project root for license information
 */

package controller;

import com.sun.deploy.uitoolkit.impl.fx.HostServicesFactory;
import com.sun.javafx.application.HostServicesDelegate;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AboutFormController extends Application {
    @FXML
    private Label lblVersion;
    @FXML
    private FontAwesomeIconView faGithub;
    @FXML
    private Hyperlink hyrGitHub;
    @FXML
    private FontAwesomeIconView faLinkedIn;
    @FXML
    private Hyperlink hyrLinkedIn;
    @FXML
    private FontAwesomeIconView faWhatsapp;
    @FXML
    private Hyperlink hyrWhatsapp;
    @FXML
    private Button btnClose;

    public void initialize() {

        Platform.runLater(() -> {
            String version = "1.2";
            lblVersion.setText("Version " + version);
        });


    }

    private void openWebLinks(String url) {
        HostServicesDelegate hostServices = HostServicesFactory.getInstance(this);
        hostServices.showDocument(url);
    }

    @FXML
    private void hyrGitHub_onAction(ActionEvent actionEvent) throws Exception {
        openWebLinks(hyrGitHub.getText());
    }

    @FXML
    private void hyrLinkedIn_onAction(ActionEvent actionEvent) {
        openWebLinks(hyrLinkedIn.getText());

    }

    @FXML
    private void hyrWhatsapp_onAction(ActionEvent actionEvent) {
        openWebLinks(hyrWhatsapp.getText());

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    @FXML
    private void btnClose_onAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();

    }


}
