package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.ReizigerDAO;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BagageInformatieController implements Initializable {

    @FXML
    private TextField voornaam;
    @FXML
    private TextField achternaam;
    @FXML
    private TextField adres;
    @FXML
    private TextField woonplaats;
    @FXML
    private TextField postcode;
    @FXML
    private TextField land;
    @FXML
    private TextField telefoonnummer;
    @FXML
    private TextField email;
    //bagage
    @FXML
    private TextField bagageLabel;
    @FXML
    private TextField vluchtNummer;
    @FXML
    private DatePicker datumGevonden;
    @FXML
    private TextField tijdGevonden;
    @FXML
    private TextField locatieGevonden;
    @FXML
    private ComboBox bagageType;
    @FXML
    private ComboBox status;
    @FXML
    private TextField merk;
    @FXML
    private TextField primaireKleur;
    @FXML
    private TextField secundaireKleur;
    @FXML
    private TextField formaat;
    @FXML
    private TextField gewicht;
    @FXML
    private TextField IATA;
    @FXML
    private TextField overigeEigenschappen;
    private ParentControllerContext parentController;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setFields(Bagage bagage) { 
        ReizigerDAO daoReiziger = new ReizigerDAO();
        Reiziger reiziger = daoReiziger.getReiziger(bagage.getReizigerID());
        System.out.println("Reiiger info= " + reiziger.toString());

    }

    public void BagageInfoFields(Bagage bagage) {

        bagageLabel.setText(bagage.getBagagelabel());
        vluchtNummer.setText(bagage.getVluchtNummer());
    }

    public void reizigerInfoFields(Reiziger reiziger) {

    }
}
