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

/**
 * FXMLController Class die de content van de applicatie beheert
 * @author Yassine Idrissi
 */
public class ContentController implements Initializable {

    private ParentControllerContext parentController;

    @FXML
    private StackPane workspace;

    @FXML
    private BorderPane content;

    public void setParentContext(ParentControllerContext pC) {
        System.out.println("this.parentcontroller: " + pC.toString());
        this.parentController = pC;
        pC.displayStatusMessage("Logged into Content");
    }

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
//        Parent pane = loadFXMLFile("/fxml/BagageOpslaanVerlorenPDF.fxml");

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

    }

    @FXML
    private void openBagageZoeken(ActionEvent event) {
        System.out.println("zoeken geopend ");
        AnchorPane pane = (AnchorPane) loadFXMLFile("/fxml/bagageZoeken.fxml");
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
        pane.setPrefHeight(workspace.getHeight());
        pane.setPrefWidth(workspace.getWidth());

        System.out.println("worksspace size");
        System.out.println("height=" + workspace.getHeight());
        System.out.println("width =" + workspace.getWidth());

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
        this.parentController.notifyCloseChild();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("dashboard geopend ");
        AnchorPane pane = (AnchorPane) loadFXMLFile("/fxml/Dashboard.fxml");
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
        pane.setPrefHeight(workspace.getHeight());
        pane.setPrefWidth(workspace.getWidth());
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
