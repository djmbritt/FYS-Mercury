package hva.fys.mercury.controllers;

import hva.fys.mercury.services.FormHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class FormulierController implements Initializable {
 
    private FormHandler handler = new FormHandler();
    
    @FXML
    private AnchorPane form;
    
    public void nieuwformulier(ActionEvent event) {
        
    }

    public void opslaan(ActionEvent event) {
        
       if(handler.verlorenBagageOpslaan(form)){
           
       }
    }

    public void annuleer(ActionEvent event) {

    }

    public void bewerken(ActionEvent event) {

    }
    
    public void verwijder(ActionEvent event){
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
