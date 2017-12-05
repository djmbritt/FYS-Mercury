package hva.fys.mercury.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Mitchell Wan
 */
public class BagageOpslaanVerlorenPDFController implements Initializable {

    Reiziger reiziger = new Reiziger();
    Bagage bag = new Bagage();
    
    @FXML
    private Label voornaamLabel;
    private Label achternaamLabel;
    private Label adresLabel;
    private Label woonplaatsLabel;
    private Label postcodeLabel;
    private Label landLabel;
    private Label telefoonLabel;
    private Label emailLabel;
    private Label bagageLabel;
    private Label bagageTypeLabel;
    private Label datumLabel;
    private Label tijdLabel;
    private Label vluchtLabel;
    private Label locatieLabel;
    private Label primaireLabel;
    private Label secundaireLabel;
    private Label formaatLabel;
    private Label gewichtLabel;
    private Label iataLabel;
    private Label statusLabel;
    private Label overigeLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        voornaamLabel.setText(reiziger.getVoornaam());
        achternaamLabel.setText(reiziger.getAchternaam());
        adresLabel.setText(reiziger.getAdres());
        woonplaatsLabel.setText(reiziger.getWoonplaats());
        postcodeLabel.setText(reiziger.getPostcode());
        landLabel.setText(reiziger.getLand());
        telefoonLabel.setText(reiziger.getTelefoonnummer());
        emailLabel.setText(reiziger.getEmail());
        bagageLabel.setText(bag.getBagagelabel());
        bagageTypeLabel.setText(bag.getBagageType());
        datumLabel.setText(bag.getDatumGevonden());
        tijdLabel.setText(bag.getTijdGevonden());
        vluchtLabel.setText(bag.getVluchtNummer());
        locatieLabel.setText(bag.getGevondenLocatie());
        primaireLabel.setText(bag.getPrimaireKleur());
        secundaireLabel.setText(bag.getSecundaireKleur());
        formaatLabel.setText(bag.getFormaat());
        gewichtLabel.setText(bag.getGewichtInKG());
        iataLabel.setText(bag.getIATA_Code());
        statusLabel.setText(bag.getStatus());
        overigeLabel.setText(bag.getOverigeEigenschappen());
    }    
    
}
