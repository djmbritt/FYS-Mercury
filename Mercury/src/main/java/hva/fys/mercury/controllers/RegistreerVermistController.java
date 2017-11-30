/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

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
 * @author Mitchell Wan
 */
public class RegistreerVermistController implements Initializable {
    Bagage bagage = new Bagage();
    Reiziger reiziger = new Reiziger();
//    TextField voornaam = new TextField();
    @FXML
    TextField voornaam;
    public TextField achternaam;
    public TextField adres;
    public TextField woonplaats;
    public TextField postcode;
    public TextField land;
    public TextField telefoonnummer;
    public TextField email;
    public TextField bagageLabel;
    public TextField vluchtNummer;
    public DatePicker datumGevonden;
    public TextField tijdGevonden;
    public TextField locatieGevonden;
    public TextField bagageType;
    public TextField merk;
    public TextField primaireKleur;
    public TextField secundaireKleur;
    public TextField formaat;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    public boolean checkText() {
        TextField[] text = {
        voornaam,
        achternaam,
        adres,
        woonplaats,
        postcode,
        land,
        telefoonnummer,
        email,
        bagageLabel,
        vluchtNummer,
        tijdGevonden,
        locatieGevonden,
        bagageType,
        merk,
        primaireKleur,
        secundaireKleur,
        formaat
        };
        
        for (int i = 0; i < text.length; i++) {
            if (text[i].getText().trim().length() == 0) {
                return false;
            }
        }
        return true;
    }
    @FXML
    private Button opslaanBTN;
    
    @FXML
    private void opslaanBagage(ActionEvent event) { 
       if (checkText() == false) {
           System.out.println("You didn't fill in all textfields!");
       } else {
        reiziger.setVoornaam(voornaam.getText());
        reiziger.setAchternaam(achternaam.getText());
        reiziger.setAdres(adres.getText());
        reiziger.setWoonplaats(woonplaats.getText());
        reiziger.setPostcode(postcode.getText());
        reiziger.setLand(land.getText());
        reiziger.setTelefoonnummer(telefoonnummer.getText());
        reiziger.setEmail(email.getText());
        bagage.setBagagelabel(bagageLabel.getText());
        bagage.setVluchtNummer(vluchtNummer.getText());
        bagage.setDatumGevonden(datumGevonden.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        bagage.setTijdGevonden(tijdGevonden.getText());
        bagage.setGevondenLocatie(locatieGevonden.getText());
        bagage.setBagageType(bagageType.getText());
        bagage.setMerk(merk.getText());
        bagage.setPrimaireKleur(primaireKleur.getText());
        bagage.setSecundaireKleur(secundaireKleur.getText());
        bagage.setFormaat(formaat.getText());
//           System.out.println(reiziger.getVoornaam());
        System.out.println("Gegevens zijn opgeslagen!");
       }
    }
}

