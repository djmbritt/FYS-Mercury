package hva.fys.mercury;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javafx.scene.layout.BorderPane;

public class FXMLController implements Initializable {
    
    @FXML
    private StackPane workspace;

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
        ///Users/davidbritt/Desktop/FYS-Mercury/Mercury/src/main/resources/fxml/Dashboard.fxml
        
        System.out.println(pane);
        System.out.println(workspace);
        workspace.getChildren().clear();
        workspace.getChildren().setAll(pane);
    
    }
    

    @FXML
    private void openBagageZoeken(ActionEvent event) {
        System.out.println("bagage zoeken geopend ");
    }
    
   @FXML
    private void openManagerOverzicht(ActionEvent event) {
        System.out.println("manager  geopend ");
    }
    
    @FXML
    private void logout(ActionEvent event) {
        System.out.println("iutloggen ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
   
    private Parent loadFXMLFile(String fxmlFileName){
        try{
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        }catch(IOException ex){
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}


