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
 *
 * @author Yassine Idrissi
 */
public class ContentController implements Initializable {

    private ParentControllerContext parentController;

    @FXML
    private StackPane workspace;

    @FXML
    private BorderPane content;

    /**
     * geeft de parentController een waarde zodat de child taken binnen de
     * parent uit kan voeren
     *
     * @param pC
     */
    public void setParentContext(ParentControllerContext pC) {
        System.out.println("this.parentcontroller: " + pC.toString());
        this.parentController = pC;
        pC.displayStatusMessage("Logged into Content");
    }

    /**
     * Opent het gevonden registratie formulier
     *
     * @param event
     */
    @FXML
    private void openRegistreerGevondenbagage(ActionEvent event) {
        System.out.println("registreer bagage geopend ");
        Parent pane = loadFXMLFile("/fxml/GevondenBagageFormulier.fxml");

        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    }

    /**
     * Opent het verloren registratie formulier
     *
     * @param event
     */
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

    /**
     * Opent het dashboard Scherm
     *
     * @param event
     */
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

    /**
     * Opent het scherm voor bagage zoeken
     *
     * @param event
     */
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

    /**
     * Brengt gebruiker terug naar het login scherm
     *
     * @param event
     */
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

    /**
     * Laadt een fxml bestand in een Parent object en geeft dat terug
     *
     * @param fxmlFileName naam van het fxml bestand die op het scherm ingeladen
     * moet worden
     * @return een Parent object met daarin de informatie van het fxml bestand
     * indien er geen bestand is geselecteerd geeft het null terug
     */
    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
