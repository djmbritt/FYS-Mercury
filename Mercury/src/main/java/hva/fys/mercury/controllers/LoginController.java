package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.GebruikerDAO;
import java.io.IOException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
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

/**
 * FXML Controller class die de login pagina beheert
 *
 * @author José Niemel
 * @author David Britt
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

    /**
     * geeft het scherm voor de Administrator weer
     */
    public void showAdminPane() {
        System.out.println("loading Admin Pane");
        System.out.println("loginAnchor: " + this.loginAnchor);
        System.out.println("adminPanel: " + this.adminPanel);
        
        this.parentNode.setVisible(false);
        this.adminPanel.setVisible(true);
    }

    /**
     * geeft het Loginscherm weer
     */
    public void showLoginPane() {
        if (this.adminPanel.visibleProperty().getValue()) {
            this.adminPanel.setVisible(false);
        }
        if (this.content.visibleProperty().getValue()) {
            this.content.setVisible(false);
        }
        this.parentNode.setVisible(true);
    }

    /**
     * geeft het Hoofdscherm voor de reguliere gebruikers weer
     */
    private void showContent() {
        this.parentNode.setVisible(false);
        this.content.setVisible(true);
    }

    /**
     * Gaat na of de ingevoerde informatie overeenkomt met de informatie in de database.
     * @param event
     * @throws InvalidKeyException
     * @throws NoSuchAlgorithmException
     */
    @FXML
    private void loginAction(ActionEvent event) throws InvalidKeyException, NoSuchAlgorithmException {
        System.out.println("Logging IN");

        if (loginTextField.getText().isEmpty() && passwordField.getText().isEmpty()) {
            Alert emptyAlert = new Alert(Alert.AlertType.WARNING);
            emptyAlert.setContentText("Voer in je jouwGebruikersNaam@corendon.com en wachtwoord AUB.");
            emptyAlert.showAndWait();
            return;
        }

        String emailLogin = loginTextField.getText();
        String userRoll = gebruikerDAO.getUserRoll(emailLogin);
        String passwordLogin = passwordField.getText();
        String passwordDB = gebruikerDAO.getPassword(emailLogin);

        System.out.printf("UserRoll: %s\nPasswordDB: %s\nLoginPassword: %s\n", emailLogin, passwordDB, passwordLogin);

        if (userRoll == null) {
            Alert noUserAlert = new Alert(Alert.AlertType.ERROR);
            noUserAlert.setContentText("Deze gebruiker bestaat niet.");
            noUserAlert.showAndWait();
            return;
        }

        if (passwordLogin.equals(passwordDB)) {
            if (userRoll.equalsIgnoreCase("admin")) {
                showAdminPane();
                adminPanelController.setParentContext(this);
            } else {
                showContent();
                contentController.setParentContext(this);
            }
        } else {
            Alert wrongPassAlert = new Alert(Alert.AlertType.WARNING);
            wrongPassAlert.setContentText("Wrong password");
            wrongPassAlert.showAndWait();
            System.out.println("Something went wrong");
        }

    }
    
    @FXML
    private void naarNl(ActionEvent event) {
        ContentController.locale = new Locale("nl", "NL");
    }
    
    @FXML
    private void naarEn(ActionEvent event) {
        ContentController.locale = new Locale("en", "US");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ContentController.locale = new Locale("en", "US");
    }

    /**
     * geeft de loginPagina weer
     */
    @Override
    public void notifyCloseChild() {
        System.out.println("Closing child pane: childpane");
        showLoginPane();
    }

    @Override
    public void displayStatusMessage(String message) {
//        statusMessage.setText(message);
    }

    /**
     * Laadt een fxml bestand in een Parent object en geeft dat terug
     * @param fxmlFileName naam van het fxml bestand die op het scherm ingeladen moet worden
     * @return  een Parent object met daarin de informatie van het fxml bestand indien er geen bestand is geselecteerd geeft het null terug
     */
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

    @Override
    public void deleteLastElement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
