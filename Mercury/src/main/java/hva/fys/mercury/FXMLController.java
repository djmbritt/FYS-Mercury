package hva.fys.mercury;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.control.Label; 
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.BorderPane; 

public class FXMLController implements Initializable {

    @FXML
    private StackPane workspace;

    @FXML
    private BorderPane rootNode;

    @FXML
    private StackPane rootWorkSpace;

    @FXML
    private TextField userTextField;

    @FXML
    private PasswordField passTextField;

    @FXML
    private void openRegistreerGevondenbagage(ActionEvent event) {
        System.out.println("registreer bagage geopend ");
        Parent pane = loadFXMLFile("/fxml/bagageFormulier.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    @FXML
    private void openRegistreerVerlorenbagage(ActionEvent event) {
        System.out.println("verloren bagage geopend ");
        Parent pane = loadFXMLFile("/fxml/registreerVermist.fxml");

        System.out.println(pane);
        System.out.println(workspace);

        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    @FXML
    private void openDashboard(ActionEvent event) {
        System.out.println("dashboard geopend ");
        Parent pane;
        pane = loadFXMLFile("/fxml/Dashboard.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);

    }

    @FXML
    private void openBagageZoeken(ActionEvent event) {
        System.out.println("bagage zoeken geopend ");
        Parent pane = loadFXMLFile("/fxml/bagageFormulier.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    @FXML
    private void openManagerOverzicht(ActionEvent event) {
        System.out.println("manager  geopend ");
        Parent pane = loadFXMLFile("/fxml/managerOverzicht.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    @FXML
    private void logOut(ActionEvent event) {
        System.out.println("Logging Out");
        Parent pane = loadFXMLFile("/fxml/Login.fxml");

        System.out.println("pane: " + pane);
        System.out.println("rootWorkspace: " + rootWorkSpace);

        rootWorkSpace.getChildren().clear();
        rootWorkSpace.getChildren().setAll(pane);
    }

    @FXML
    private void loginAction(ActionEvent event) {
        System.out.println("Logging In");
        Parent pane = loadFXMLFile("/fxml/MenuBar.fxml");

        System.out.println(pane);
        System.out.println(rootWorkSpace);

        String userNameString, passwordString, userPass = "admin";

        userNameString = userTextField.getText();
        passwordString = passTextField.getText();

        System.out.printf("\nuser: %s\tpass:%s.\n", userNameString, passwordString);
        
        /*
        TODO
        Function for checking database for all users and check credentials
        */

        //Checks credentials, which is admin!
        if (userNameString.equalsIgnoreCase(userPass) && passwordString.equalsIgnoreCase(userPass)) {
            rootWorkSpace.getChildren().clear();
            rootWorkSpace.getChildren().add(pane);
        } else {
            String content = "Wrong credentials";
            System.out.println(content);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(content);
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
