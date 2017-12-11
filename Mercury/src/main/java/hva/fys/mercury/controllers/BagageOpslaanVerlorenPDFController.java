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
import java.util.Locale;
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

    @FXML
    private Label voornaamLabel;
    @FXML
    private Label achternaamLabel;
    @FXML
    private Label adresLabel;
    @FXML
    private Label woonplaatsLabel;
    @FXML
    private Label postcodeLabel;
    @FXML
    private Label landLabel;
    @FXML
    private Label telefoonLabel;
    @FXML
    private Label emailLabel;
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

    private ParentControllerContext parentController;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

    private Bagage bagage;
    private Reiziger reiziger;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setParentContext(ParentControllerContext pC, Bagage bgg, Reiziger rzgr) {
        System.out.println("this.parentcontroller: " + pC.toString());
        System.out.println("this.bagage: " + bgg.toString());
        System.out.println("this.rzgr: " + rzgr.toString());
        this.parentController = pC;
        this.reiziger = rzgr;
        this.bagage = bgg;
        this.fillLabels(bgg, rzgr);
        pC.displayStatusMessage("Editing found luggage");
    }

    public void fillLabels(Bagage bag, Reiziger reiziger) {
//        if (bag.getBagagelabel() != null) {
//            bagageLabel.setText(bag.getBagagelabel());
//        }
//        
//        bagageTypeLabel.setText("haloooo");

//        datumLabel.setText(bag.getDatumGevonden());
//        tijdLabel.setText(bag.getTijdGevonden());
//        vluchtLabel.setText(bag.getVluchtNummer());
//        locatieLabel.setText(bag.getGevondenLocatie());
//        primaireLabel.setText(bag.getPrimaireKleur());
//        secundaireLabel.setText(bag.getSecundaireKleur());
//        formaatLabel.setText(bag.getFormaat());
//        gewichtLabel.setText(bag.getGewichtInKG());
//        iataLabel.setText(bag.getIATA_Code());
//        statusLabel.setText(bag.getStatus());
//        overigeLabel.setText(bag.getOverigeEigenschappen());
//        voornaamLabel.setText(reiziger.getVoornaam());
//        achternaamLabel.setText(reiziger.getAchternaam());
//        adresLabel.setText(reiziger.getAdres());
//        woonplaatsLabel.setText(reiziger.getWoonplaats());
//        postcodeLabel.setText(reiziger.getPostcode());
//        landLabel.setText(reiziger.getLand());
//        telefoonLabel.setText(reiziger.getTelefoonnummer());
//        emailLabel.setText(reiziger.getEmail());
    }

}
