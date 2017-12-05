/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;
 
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
    
    @FXML
    public TextField voornaam;
    public TextField achternaam;
    public TextField adres;
    public TextField woonplaats;
    public TextField postcode;
    public TextField land;
    public TextField telefoonnummer;
    public TextField email;
    public TextField bagageLabel;
    public TextField vluchtNummer;
    public TextField datumGevonden;
    public TextField tijdGevonden;
    public TextField locatieGevonden;
    public TextField bagageType;
    public TextField merk;
    public TextField primaireKleur;
    public TextField secundaireKleur;
    public TextField formaat;
       

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        voornaam.setDisable(true);
        achternaam.setDisable(true);
        adres.setDisable(true);
        woonplaats.setDisable(true);
        postcode.setDisable(true);
        land.setDisable(true);
        telefoonnummer.setDisable(true);
        email.setDisable(true);
        bagageLabel.setDisable(true);
        vluchtNummer.setDisable(true);
//        datumGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        bagageType.setDisable(true);
        merk.setDisable(true);
        primaireKleur.setDisable(true);
        secundaireKleur.setDisable(true);
        formaat.setDisable(true);
        
        voornaam.setText(reiziger.getVoornaam());
        achternaam.setText(reiziger.getAchternaam());
        adres.setText(reiziger.getAdres());
        woonplaats.setText(reiziger.getWoonplaats());
        postcode.setText(reiziger.getPostcode());
        land.setText(reiziger.getLand());
        datumGevonden.setText(bagage.getDatumGevonden());
        telefoonnummer.setText(reiziger.getTelefoonnummer());
        email.setText(reiziger.getEmail());
        bagageLabel.setText(bagage.getBagagelabel());
        vluchtNummer.setText(bagage.getVluchtNummer());
        datumGevonden.setText(bagage.getDatumGevonden());
        tijdGevonden.setText(bagage.getTijdGevonden());
        locatieGevonden.setText(bagage.getGevondenLocatie());
        bagageType.setText(bagage.getBagageType());
        merk.setText(bagage.getBagagemerk());
        primaireKleur.setText(bagage.getPrimaireKleur());
        secundaireKleur.setText(bagage.getSecundaireKleur());
        formaat.setText(bagage.getFormaat());
    }
    
    
    @FXML
    private static Button bewerkBTN;
    public static Button veranderLocatieBTN;
    public static Button annuleerBTN;
    
    @FXML
    public void bewerkDetails(ActionEvent event){
        voornaam.setDisable(false);
        achternaam.setDisable(false);
        adres.setDisable(false);
        woonplaats.setDisable(false);
        postcode.setDisable(false);
        land.setDisable(false);
        telefoonnummer.setDisable(false);
        email.setDisable(false);
        bagageLabel.setDisable(false);
        vluchtNummer.setDisable(false);
//        datumGevonden.setDisable(false);
        tijdGevonden.setDisable(false);
        locatieGevonden.setDisable(false);
        tijdGevonden.setDisable(false);
        locatieGevonden.setDisable(false);
        bagageType.setDisable(false);
        merk.setDisable(false);
        primaireKleur.setDisable(false);
        secundaireKleur.setDisable(false);
        formaat.setDisable(false);
    }
    
    @FXML
    public void bagageDetailsOpslaan(ActionEvent event) {
        voornaam.setDisable(true);
        achternaam.setDisable(true);
        adres.setDisable(true);
        woonplaats.setDisable(true);
        postcode.setDisable(true);
        land.setDisable(true);
        telefoonnummer.setDisable(true);
        email.setDisable(true);
        bagageLabel.setDisable(true);
        vluchtNummer.setDisable(true);
//        datumGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        tijdGevonden.setDisable(true);
        locatieGevonden.setDisable(true);
        bagageType.setDisable(true);
        merk.setDisable(true);
        primaireKleur.setDisable(true);
        secundaireKleur.setDisable(true);
        formaat.setDisable(true);
    }
    
    @FXML
    public void veranderLocatie(ActionEvent event) {
        veranderLocatieController.veranderLocatiePopup();
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
