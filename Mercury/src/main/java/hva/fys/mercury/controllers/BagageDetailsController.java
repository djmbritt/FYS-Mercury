/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;
 
import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.DAO.JDBCMethods;
import hva.fys.mercury.DAO.ReizigerDAO;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Eigenaar
 */
public class BagageDetailsController implements Initializable {
    
    
    Bagage bagage = new Bagage();
    Reiziger reiziger = new Reiziger();
    
    JDBCMethods methodsdb = new JDBCMethods();
    
    private final int REIZIGERID = 52345;
    private final int BAGAGEID = 201622309;
    
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
    @FXML
    private TextField bagageLabel;
    @FXML
    private ComboBox vluchtNummer;
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
    private TextField overigeEigenschappen;
    @FXML
    private ComboBox IATARgr;
    @FXML
    private Label bagageID;
    @FXML
    private Label reizigerID;
       
    static int i;

    LocalDate localDate;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        
        disableFields();
        
        status.getItems().addAll(
    "Vermist",
    "Gevonden",
    "Afgehandeld"
);
    bagageType.getItems().addAll(
    "Koffer",
    "Tas",
    "Rugzak",
    "Doos",
    "Sporttas",
    "Zakenkoffer",
    "Kist",
    "Anders"
    );
    IATARgr.getItems().addAll (
            "AMS","AYT","IST","BJV","DLM","ADB","GZP","ECN","RAK","HER","KGS","RHO","ZTH","CFU","MJT","OHD","SMI","LPA","TFO","PMI","AGP","FUE","FAO","ACE","HRG","NBE","DXB","BOJ","BJL","CTA"
    );
    vluchtNummer.getItems().addAll (
            "HV649","HV799","HV740","HV650","PC5665","CAI524","CAI1827","CAI1828","CAI421","CAI724","CAI723","CAI040","CAI041","HV6115","HV6224","TO3160","TO3163","TO3002","TO3005","HV355","HV356","CND513","CND593","CND117","CAI020","CAI806","CND513","CND712","CND118","CND594","CAI023","CAI805","CAI021","VY2151","VY2150","KL1039","KL1040","KL1041","KL1042","CAI202","CAI201","TK1942","TK1943","TK1938","TK1939","TK1952","TK1951","TK1958","TK1955","TK1830","TK1823","TK1824","TK1827","TK2430","TK2414","TK2425","TK2409","TK2510","TK2505"
    );
    primaireKleur.getItems().addAll (
            "Geel","Olijf","Oranje","Rood","Donkerrood","Roze","Paars","Violet","Blauw","Lichtblauw","Donkerblauw","Blauwgroen","Groen","Donkergroen","Lichtgroen","Grijs","Donkergrijs","Lichtgrijs","Bruin","Donkerbruin","Lichtbruin","Wit","Zwart","Crème"
    );
    secundaireKleur.getItems().addAll (
            "Geel","Olijf","Oranje","Rood","Donkerrood","Roze","Paars","Violet","Blauw","Lichtblauw","Donkerblauw","Blauwgroen","Groen","Donkergroen","Lichtgroen","Grijs","Donkergrijs","Lichtgrijs","Bruin","Donkerbruin","Lichtbruin","Wit","Zwart","Crème"
    );
    

        StringBuilder sb = new StringBuilder();
        sb.append(BAGAGEID);
        String strI = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(REIZIGERID);
        String strII = sb2.toString();
        bagageID.setText(strI);
        reizigerID.setText(strII);
        Reiziger rgr =  ReizigerDAO.getReiziger(REIZIGERID);
        Bagage bag = BagageDAO.getBagage(BAGAGEID);
        
        voornaam.setText(rgr.getVoornaam());
        achternaam.setText(rgr.getAchternaam());
        adres.setText(rgr.getAdres());
        woonplaats.setText(rgr.getWoonplaats());
        postcode.setText(rgr.getPostcode());
        land.setText(rgr.getLand());
        telefoonnummer.setText(rgr.getTelefoonnummer());
        email.setText(rgr.getEmail());
        IATARgr.setValue(rgr.getIATA_Code());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy", Locale.ENGLISH);
	String date = bag.getDatumGevonden();
        localDate = LocalDate.parse(date, formatter);
//        System.out.println(localDate);  //default, print ISO_LOCAL_DATE
//        System.out.println(formatter.format(localDate));
        datumGevonden.setValue(localDate);
        
        bagageLabel.setText(bag.getBagagelabel());
        vluchtNummer.setValue(bag.getVluchtNummer());
        tijdGevonden.setText(bag.getTijdGevonden());
        locatieGevonden.setText(bag.getGevondenLocatie());
        bagageType.setValue(bag.getBagageType());
        merk.setText(bag.getBagagemerk());
        primaireKleur.setValue(bag.getPrimaireKleur());
        secundaireKleur.setValue(bag.getSecundaireKleur());
        formaat.setText(bag.getFormaat());
        gewicht.setText(bag.getGewichtInKG());
        status.setValue(bag.getStatus());
        overigeEigenschappen.setText(bag.getOverigeEigenschappen());

        
    }
    
    public void disableFields() {
        voornaam.setDisable(true);
        achternaam.setDisable(true);
        adres.setDisable(true);
        woonplaats.setDisable(true);
        postcode.setDisable(true);
        land.setDisable(true);
        telefoonnummer.setDisable(true);
        email.setDisable(true);
        IATARgr.setDisable(true);
        bagageLabel.setDisable(true);
        vluchtNummer.setDisable(true);
        datumGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        bagageType.setDisable(true);
        merk.setDisable(true);
        primaireKleur.setDisable(true);
        secundaireKleur.setDisable(true);
        formaat.setDisable(true);
        gewicht.setDisable(true);
        overigeEigenschappen.setDisable(true);
        status.setDisable(true);
    }
    
    public void enableFields() {
        voornaam.setDisable(false);
        achternaam.setDisable(false);
        adres.setDisable(false);
        woonplaats.setDisable(false);
        postcode.setDisable(false);
        land.setDisable(false);
        telefoonnummer.setDisable(false);
        email.setDisable(false);
        IATARgr.setDisable(false);
        bagageLabel.setDisable(false);
        vluchtNummer.setDisable(false);
        datumGevonden.setDisable(false);
        tijdGevonden.setDisable(false);
        locatieGevonden.setDisable(false);
        tijdGevonden.setDisable(false);
        locatieGevonden.setDisable(false);
        bagageType.setDisable(false);
        merk.setDisable(false);
        primaireKleur.setDisable(false);
        secundaireKleur.setDisable(false);
        formaat.setDisable(false);
        gewicht.setDisable(false);
        overigeEigenschappen.setDisable(false);
        status.setDisable(false);
    }
    
    @FXML
    private static Button bewerkBTN;
    @FXML
    private static Button veranderLocatieBTN;
    @FXML
    private static Button opslaanBTN;
    @FXML
    private static Button terugBTN;
    
    @FXML
    public void bewerkDetails(ActionEvent event){
        enableFields();
    }

//    public ComboBox status;
//    public TextField gewicht;
//    public TextField overigeEigenschappen;
    @FXML
     public void bagageDetailsOpslaan(ActionEvent event) {
        disableFields();
        
        reiziger.setReizigerID(REIZIGERID);
        bagage.setRegistratieID(BAGAGEID);
        
            reiziger.setVoornaam(voornaam.getText());
            reiziger.setAchternaam(achternaam.getText());
            reiziger.setAdres(adres.getText());
            reiziger.setWoonplaats(woonplaats.getText());
            reiziger.setPostcode(postcode.getText());
            reiziger.setLand(land.getText());
            reiziger.setTelefoonnummer( telefoonnummer.getText());
            reiziger.setEmail(email.getText());
            reiziger.setIATA_Code(IATARgr.getValue().toString());
            bagage.setBagagelabel(bagageLabel.getText());
            bagage.setVluchtNummer((String) vluchtNummer.getValue());
            bagage.setDatumGevonden(datumGevonden.getValue().format(DateTimeFormatter.ofPattern("d-MMM-yyyy")));
            bagage.setTijdGevonden(tijdGevonden.getText());
            bagage.setGevondenLocatie(locatieGevonden.getText());
            bagage.setBagageType(bagageType.getValue().toString());
            bagage.setBagagemerk(merk.getText());
            bagage.setPrimaireKleur(primaireKleur.getValue().toString());
            bagage.setSecundaireKleur(secundaireKleur.getValue().toString());
            bagage.setFormaat(formaat.getText());
            bagage.setGewichtInKG(gewicht.getText());
            bagage.setStatus(status.getValue().toString());
            bagage.setOverigeEigenschappen(overigeEigenschappen.getText());
            System.out.println("Gegevens zijn opgeslagen!");
            ReizigerDAO.bewerkReiziger(reiziger);
            BagageDAO.bewerkBagage(bagage);
        }
    
    
    @FXML
    void veranderLocatie(ActionEvent event) {
        veranderLocatieController.veranderLocatiePopup();
}
    
    @FXML
    void bagageDetailsTerug(ActionEvent event) {
        
    }
    
    }
    
//    @FXML
//    private void laadDetails(ActionEvent event) {
//        voornaam.setText(reiziger.getVoornaam());
//        achternaam.setText(reiziger.getAchternaam());
//        adres.setText(reiziger.getAdres());
//        woonplaats.setText(reiziger.getWoonplaats());
//        postcode.setText(reiziger.getPostcode());
//        land.setText(reiziger.getLand());
//        telefoonnummer.setText(reiziger.getTelefoonnummer());
//        email.setText(reiziger.getEmail());
//        bagageLabel.setText(bagage.getBagagelabel());
//        vluchtNummer.setText(bagage.getVluchtNummer());
////        datumGevonden.setText(bagage.getDatumGevonden());
//        tijdGevonden.setText(bagage.getTijdGevonden());
//        locatieGevonden.setText(bagage.getGevondenLocatie());
//        bagageType.setText(bagage.getBagageType());
//        merk.setText(bagage.getMerk());
//        primaireKleur.setText(bagage.getPrimaireKleur());
//        secundaireKleur.setText(bagage.getSecundaireKleur());
//        formaat.setText(bagage.getFormaat());
//        System.out.println("Gegevens zijn geladen");
//    }
//}
