package hva.fys.mercury.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent; 
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class ContentController implements Initializable {

    @FXML
    private StackPane workspace;

    @FXML
    private BorderPane content;

    @FXML
    private void openRegistreerGevondenbagage(ActionEvent event) {
        System.out.println("registreer bagage geopend ");
        Parent pane = loadFXMLFile("/fxml/GevondenBagageFormulier.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    @FXML
    private void openRegistreerVerlorenbagage(ActionEvent event) {
        System.out.println("verloren bagage geopend ");
        Parent pane = loadFXMLFile("/fxml/VerlorenBagageFormulier.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);

    }

    @FXML
    private void openDashboard(ActionEvent event) {
        System.out.println("dashboard geopend ");
        AnchorPane pane = (AnchorPane) loadFXMLFile("/fxml/Dashboard.fxml");
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
        pane.setPrefHeight(workspace.getHeight());
        pane.setPrefWidth(workspace.getWidth());

        System.out.println("worksspace size");
        System.out.println("height=" + workspace.getHeight());
        System.out.println("width =" + workspace.getWidth());
        System.out.println("parent size");
        System.out.println("height=" + content.getPrefHeight());
        System.out.println("width =" + content.getPrefWidth());

    }

    @FXML
    private void openBagageZoeken(ActionEvent event) {
           System.out.println("bagage geopend ");
        AnchorPane pane = (AnchorPane) loadFXMLFile("/fxml/bagageZoeken.fxml");
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
        pane.setPrefHeight(workspace.getHeight());
        pane.setPrefWidth(workspace.getWidth());

        System.out.println("worksspace size");
        System.out.println("height=" + workspace.getHeight());
        System.out.println("width =" + workspace.getWidth());
        System.out.println("parent size");
        System.out.println("height=" + content.getPrefHeight());
        System.out.println("width =" + content.getPrefWidth());

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
    private void logoutAction(ActionEvent event) {
        System.out.println("Logging out");

        /*
        BorderPane pane = (BorderPane) loadFXMLFile("/fxml/Login.fxml");
        pane.setPrefHeight(content.getHeight());
        pane.setPrefWidth(content.getWidth());

        System.out.println(pane);
        System.out.println(content);

        content.getChildren().clear();
        content.getChildren().setAll(pane);
         */
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
