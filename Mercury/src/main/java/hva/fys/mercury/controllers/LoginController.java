package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.controllers.ParentControllerContext;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/*
@author: Jose, David
*/

public class LoginController implements Initializable, ParentControllerContext {

    @FXML
    BorderPane parentNode;

    @FXML
    GridPane workspace;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    //parentNode
    @FXML
    private AnchorPane loginAnchor;

    //childNodeAdminPanel
    @FXML
    private AnchorPane adminPanel;

    //childNodeAdminController
    @FXML
    private AdminPanelController adminPanelController;

    //childNodeContentPane
    @FXML
    private AnchorPane content;

    //childnodeContentController
    @FXML
    private ContentController contentController;
    
    GebruikerDAO gebruikerDAO = new GebruikerDAO();

    public void showAdminPane() {
        System.out.println("loading Admin Pane");
        System.out.println("loginAnchor: " + this.loginAnchor);
        System.out.println("adminPanel: " + this.adminPanel);
        this.parentNode.setVisible(false);
        this.adminPanel.setVisible(true);
    }

    public void showLoginPane() {
        if (this.adminPanel.visibleProperty().getValue()) {
            this.adminPanel.setVisible(false);
        }
        if (this.content.visibleProperty().getValue()) {
            this.content.setVisible(false);
        }
        this.parentNode.setVisible(true);
    }

    //Parent controller methods
    private void showContent() {
        this.parentNode.setVisible(false);
        this.content.setVisible(true);
    }

    @FXML
    private void loginAction(ActionEvent event) {
        System.out.println("Logging IN");

//            pane = (AnchorPane) loadFXMLFile("/fxml/Content.fxml");
        if (loginTextField.getText().isEmpty() && passwordField.getText().isEmpty()) {
            Alert emptyAlert = new Alert(Alert.AlertType.WARNING);
            emptyAlert.setContentText("Voer in je jouwGebruikersNaam@corendon.com en wachtwoord AUB.");
            emptyAlert.showAndWait();
            return;
        }

        String emailLogin = loginTextField.getText();
        String userRoll = gebruikerDAO.getUserRoll(emailLogin);
        String passwordLogin = gebruikerDAO.getPassword(emailLogin);
        String passwordDB = gebruikerDAO.getPassword(emailLogin);

        System.out.println("userRoll: " + userRoll);
        System.out.println("Password: " + passwordDB);

        if (passwordLogin.equals(passwordDB)) {
            if (userRoll.equalsIgnoreCase("admin")) {
                showAdminPane();
                adminPanelController.setParentContext(this);
            } else if (!userRoll.equalsIgnoreCase("admin")) {
                showContent();
                contentController.setParentContext(this);
            } else {
                Alert wrongPassAlert = new Alert(Alert.AlertType.WARNING);
                wrongPassAlert.setContentText("Wrong password");
            }
        } else {
            System.out.println("Something went wrong");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @Override
    public void notifyCloseChild() {
        System.out.println("Closing child pane: childpane");
        showLoginPane();
    }

    @Override
    public void displayStatusMessage(String message) {
//        statusMessage.setText(message);
    }

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }

    @Override
    public void notifyChildHasUpdated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
