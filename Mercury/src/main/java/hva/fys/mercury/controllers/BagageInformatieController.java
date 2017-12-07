package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.DAO.ReizigerDAO;
import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private ComboBox primaireKleur;
    @FXML
    private ComboBox secundaireKleur;
    @FXML
    private TextField formaat;
    @FXML
    private TextField gewicht;
    @FXML
    private TextField iATA;
    @FXML
    private TextField overigeEigenschappen;
    private ParentControllerContext parentController;
    
    public void initialize(URL url, ResourceBundle rb) {
        setStatusBox();
        setKleurBox();
        setBagageTypeBox();
    }
    
    public void setFields(Bagage bagage) {
        ReizigerDAO daoReiziger = new ReizigerDAO();
        Reiziger reiziger = daoReiziger.getReiziger(bagage.getReizigerID());
        System.out.println("Reiiger info= " + reiziger.toString());
        BagageInfoFields(bagage);
        reizigerInfoFields(reiziger);
        
    }
    
    public void BagageInfoFields(Bagage bagage) {
        
        bagageLabel.setText(bagage.getBagagelabel());
        vluchtNummer.setText(bagage.getVluchtNummer());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.ENGLISH);
        String dateString = bagage.getDatumGevonden();
        datumGevonden.setValue(LocalDate.parse(dateString, formatter));
        tijdGevonden.setText(bagage.getTijdGevonden());
        locatieGevonden.setText(bagage.getGevondenLocatie());
        merk.setText(bagage.getBagagemerk());
        formaat.setText(bagage.getFormaat());
        gewicht.setText(bagage.getGewichtInKG());
        iATA.setText(bagage.getIATA_Code());
        
        overigeEigenschappen.setText(bagage.getOverigeEigenschappen());
        
    }
    
    private void setStatusBox() {
        status.getItems().addAll(
                "Vermist",
                "Gevonden",
                "Afgehandeld"
        );
    }
    
    private void setKleurBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> kleuren = new ArrayList();
        kleuren.add("");
        String query = "Select * From kleuren";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                kleuren.add(rs.getString("Engels"));
            }
            
            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        primaireKleur.getItems().addAll(kleuren);
        primaireKleur.getSelectionModel().selectFirst();
        secundaireKleur.getItems().addAll(kleuren);
        secundaireKleur.getSelectionModel().selectFirst();
    }
    
    private void setBagageTypeBox() {
        DatabaseManager dbman = new DatabaseManager(MainApp.DATABASE_NAME);
        List<String> types = new ArrayList();
        types.add("");
        String query = "Select * From bagagetypes";
        try {
            ResultSet rs = dbman.executeResultSetQuery(query);
            while (rs.next()) {
                types.add(rs.getString("Engels"));
            }
            
            dbman.close();
        } catch (SQLException ex) {
            Logger.getLogger(BagageZoekenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bagageType.getItems().addAll(types);
        bagageType.getSelectionModel().selectFirst();
    }
    
    public void reizigerInfoFields(Reiziger reiziger) {
        voornaam.setText(reiziger.getVoornaam());
        achternaam.setText(reiziger.getAchternaam());
        adres.setText(reiziger.getAdres());
        woonplaats.setText(reiziger.getWoonplaats());
        postcode.setText(reiziger.getPostcode());
        land.setText(reiziger.getLand());
        telefoonnummer.setText(reiziger.getTelefoonnummer());
        email.setText(reiziger.getEmail());
    }
}
