package hva.fys.mercury.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hva.fys.mercury.models.Bagage;
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
    private Label bagageLabel;
    @FXML
    private Label bagageTypeLabel;
    @FXML
    private Label datumLabel;
    @FXML
    private Label tijdLabel;
    @FXML
    private Label vluchtLabel;
    @FXML
    private Label locatieLabel;
    @FXML
    private Label primaireLabel;
    @FXML
    private Label secundaireLabel;
    @FXML
    private Label formaatLabel;
    @FXML
    private Label gewichtLabel;
    @FXML
    private Label iataLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private Label overigeLabel;
    
    
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

