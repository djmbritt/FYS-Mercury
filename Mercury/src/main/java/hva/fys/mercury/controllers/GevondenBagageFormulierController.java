package hva.fys.mercury.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Eigenaar
 */
public class GevondenBagageFormulierController implements Initializable {
    Bagage bagage = new Bagage();
    
    @FXML
    public TextField bagageLabelG;
    public TextField vluchtNummerG;
    public DatePicker datumGevondenG;
    public TextField tijdGevondenG;
    public TextField locatieGevondenG;
    public TextField bagageTypeG;
    public TextField merkG;
    public TextField primaireKleurG;
    public TextField secundaireKleurG;
    public TextField formaatG;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public boolean checkText() {
        TextField[] text = {
        bagageLabelG,
        vluchtNummerG,
        tijdGevondenG,
        locatieGevondenG,
        bagageTypeG,
        merkG,
        primaireKleurG,
        secundaireKleurG,
        formaatG
        };
        
        for (int i = 0; i < text.length; i++) {
            if (text[i].getText().trim().length() == 0) {
                return false;
            }
        }
        return true;
    }
    @FXML
    private Button opslaanBTNG;
    
    @FXML
    private void opslaanBagageG(ActionEvent event) { 
       if (checkText() == false) {
           System.out.println("You didn't fill in all textfields!");
       } else {
        bagage.setBagagelabel(bagageLabelG.getText());
        bagage.setVluchtNummer(vluchtNummerG.getText());
        bagage.setDatumGevonden(datumGevondenG.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        bagage.setTijdGevonden(tijdGevondenG.getText());
        bagage.setGevondenLocatie(locatieGevondenG.getText());
        bagage.setBagageType(bagageTypeG.getText());
        bagage.setMerk(merkG.getText());
        bagage.setPrimaireKleur(primaireKleurG.getText());
        bagage.setSecundaireKleur(secundaireKleurG.getText());
        bagage.setFormaat(formaatG.getText());
        System.out.println("Gegevens zijn opgeslagen!");
       }
    }
}

