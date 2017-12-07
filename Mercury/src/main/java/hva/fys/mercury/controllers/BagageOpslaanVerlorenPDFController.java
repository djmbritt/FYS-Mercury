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
    public Label voornaamLabel;
    @FXML
    public Label achternaamLabel;
    @FXML
    public Label adresLabel;
    @FXML
    public Label woonplaatsLabel;
    @FXML
    public Label postcodeLabel;
    @FXML
    public Label landLabel;
    @FXML
    public Label telefoonLabel;
    @FXML
    public Label emailLabel;
    @FXML
    public Label bagageLabel;
    @FXML
    public Label bagageTypeLabel;
    @FXML
    public Label datumLabel;
    @FXML
    public Label tijdLabel;
    @FXML
    public Label vluchtLabel;
    @FXML
    public Label locatieLabel;
    @FXML
    public Label primaireLabel;
    @FXML
    public Label secundaireLabel;
    @FXML
    public Label formaatLabel;
    @FXML
    public Label gewichtLabel;
    @FXML
    public Label iataLabel;
    @FXML
    public Label statusLabel;
    @FXML
    public Label overigeLabel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    
    
    public void fillLabelsV() {
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
