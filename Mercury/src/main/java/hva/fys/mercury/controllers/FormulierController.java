package hva.fys.mercury.controllers;

import hva.fys.mercury.services.FormHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import hva.fys.mercury.models.Bagage;
import javafx.scene.control.Label;

public class FormulierController implements Initializable {

    private FormHandler handler;
    private Bagage bagage;
    
    @FXML
    private AnchorPane form;
 
    @FXML
    Label label;
    
    public void opslaan(ActionEvent event){
        label.setText(bagage.getRegistratieID() + "\n" + bagage.getRegistratieID()); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        handler = new FormHandler();
        bagage = new Bagage();
        bagage = handler.bindToObject(form, bagage);
    }
}
