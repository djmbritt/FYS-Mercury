package hva.fys.mercury.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class LoginController implements Initializable {

    @FXML
    BorderPane parentNode;
    @FXML
    GridPane workspace;

    @FXML
    private TextField loginTextField;

    @FXML
    private void loginAction(ActionEvent event) {
        System.out.println("Logging IN");
        AnchorPane pane;

        if (loginTextField.getText().equalsIgnoreCase("admin")) {
//            Not working, convert from stackpane to anchorpane?
            pane = (AnchorPane) loadFXMLFile("/fxml/AdminPanel.fxml");
        } else {
            pane = (AnchorPane) loadFXMLFile("/fxml/Content.fxml");
        }

        pane.setPrefHeight(workspace.getHeight());
        pane.setPrefWidth(workspace.getWidth());
        System.out.println(pane);
        parentNode.setCenter(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
