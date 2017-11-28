package hva.fys.mercury.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import hva.fys.mercury.models.Bagage;
import javafx.scene.control.Label;

public class FormulierController implements Initializable {

    private Bagage bagage;
    
    @FXML
    private AnchorPane form;
 
    @FXML
    Label label;
    
    public void opslaan(ActionEvent event){
        label.setText(bagage.getRegistratieID() + "\n" + bagage.getDatumGevonden()); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
    }
}
