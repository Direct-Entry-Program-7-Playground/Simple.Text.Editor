package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.StatusBar;

import java.util.prefs.Preferences;

public class EditorFormController {

    @FXML
    private VBox baseVBox;
    @FXML
    private MenuBar mnuBar;
    @FXML
    private MenuItem mnuItemNew;
    @FXML
    private MenuItem mnuItemOpen;
    @FXML
    private MenuItem mnuItemSave;
    @FXML
    private MenuItem mnuItemSaveAs;
    @FXML
    private MenuItem mnuItemPrint;
    @FXML
    private MenuItem mnuItemPageSetup;
    @FXML
    private MenuItem mnuItemExit;
    @FXML
    private MenuItem mnuItemUndo;
    @FXML
    private MenuItem mnuItemRedo;
    @FXML
    private MenuItem mnuItemCut;
    @FXML
    private MenuItem mnuItemCopy;
    @FXML
    private MenuItem mnuItemPaste;
    @FXML
    private MenuItem mnuItemFind;
    @FXML
    private MenuItem mnuItemReplace;
    @FXML
    private MenuItem mnuItemSelectAll;
    @FXML
    private MenuItem mnuItemWrap;
    @FXML
    private MenuItem mnuItemZoomIn;
    @FXML
    private MenuItem mnuItemZoomOut;
    @FXML
    private MenuItem mnuItemDefaultZoom;
    @FXML
    private MenuItem mnuItemStatusBar;
    @FXML
    private MenuItem mnuItemAbout;
    @FXML
    private AnchorPane pneFind;
    @FXML
    private TextField txtFind;
    @FXML
    private RadioButton rdbUp;
    @FXML
    private ToggleGroup FindDirGrp;
    @FXML
    private RadioButton rdbDown;
    @FXML
    private CheckBox cbCaseMatchInFind;
    @FXML
    private Button btnFindNext;
    @FXML
    private Button btnFindClose;
    @FXML
    private AnchorPane pneReplace;
    @FXML
    private TextField txtFindInReplace;
    @FXML
    private TextField txtReplace;
    @FXML
    private CheckBox cbCaseMatchInReplace;
    @FXML
    private Button btnFindNextInReplace;
    @FXML
    private Button btnReplace;
    @FXML
    private Button btnReplaceAll;
    @FXML
    private Button btnReplaceClose;
    @FXML
    private TextArea txtEditor;
    @FXML
    private StatusBar stsbrBottom;

    public void initialize() {

        Platform.runLater(() -> {

            init();
        });
    }

    private void setListeners(){

    }
    
    private void init() {

        // Set initial visibility of Find and Replace panes
        pneFind.setVisible(false);
        pneFind.setManaged(false);

        pneReplace.setVisible(false);
        pneReplace.setManaged(false);

        // Set text editor wrapping status to according to user preference
        txtEditor.setWrapText(Preferences.userRoot().node("lk").node("ijse").node("simple-text-editor").getBoolean("wrap-text", true));

        // Add dummy text
        {
            txtEditor.setText("What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "Why do we use it?\n" +
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                    "\n" +
                    "\n" +
                    "Where does it come from?\n" +
                    "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.What is Lorem Ipsum?\n" +
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                    "\n" +
                    "Why do we use it?\n" +
                    "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).\n" +
                    "\n" +
                    "\n" +
                    "Where does it come from?\n" +
                    "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.\n" +
                    "\n" +
                    "The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from \"de Finibus Bonorum et Malorum\" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.");
        }
    }

    @FXML
    private void mnuItemNew_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemOpen_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemSave_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemSaveAs_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemPrint_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemPageSetup_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemExit_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemUndo_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemRedo_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemCut_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemCopy_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemPaste_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemFind_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemReplace_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemSelectAll_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemWrap_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemZoomIn_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemZoomOut_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemDefaultZoom_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemStatusBar_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void mnuItemAbout_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnFindNext_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnFindClose_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnFindNextInReplace_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnReplace_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnReplaceAll_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void btnReplaceClose_onAction(ActionEvent actionEvent) {
    }

    @FXML
    private void txtEditor_onClicked(MouseEvent mouseEvent) {
    }
}
