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
 * @author Eigenaar
 */
public class BagageOpslaanGevondenPDFController implements Initializable {

    Bagage bag = new Bagage();
    
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
        public void fillLabelsG() {
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

