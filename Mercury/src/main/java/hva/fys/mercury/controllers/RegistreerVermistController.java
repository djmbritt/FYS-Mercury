package hva.fys.mercury.controllers;

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.DAO.JDBCMethods;
import hva.fys.mercury.models.Reiziger;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mitchell Wan
 */
public class RegistreerVermistController implements Initializable {

    Bagage bagage = new Bagage();
    Reiziger reiziger = new Reiziger();

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
    public TextField gewicht;

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
            formaat,
            gewicht
        };

        for (int i = 0; i < text.length; i++) {
            if (text[i].getText().trim().length() == 0) {
                return false;
            }

        }
        return true;
    }

    public void disableFields() {
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
            formaat,
            gewicht
        };
        for (int i = 0; i < text.length; i++) {
            text[i].setDisable(true);
        }
        datumGevonden.getEditor().setDisable(true);
    }

    public void enableFields() {
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
            formaat,
            gewicht
        };
        for (int i = 0; i < text.length; i++) {
            text[i].setDisable(false);
        }
        datumGevonden.getEditor().setDisable(false);
        datumGevonden.getEditor().setText("");
    }
    @FXML
    private Button opslaanBTN;

    @FXML
    private Label opgeslagenLabel;

    @FXML
    private Label denyLabel;

    JDBCMethods methodsdb = new JDBCMethods();

    @FXML 
    /*
    private void opslaanBagage(ActionEvent event) { 
       if (checkText() == false) {
           denyLabel.setText("You did not fill in all textfields!");
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
        bagage.setBagagemerk(merk.getText());
        bagage.setPrimaireKleur(primaireKleur.getText());
        bagage.setSecundaireKleur(secundaireKleur.getText());
        bagage.setFormaat(formaat.getText());
//           System.out.println(reiziger.getVoornaam());
        bagage.setGewichtInKG(gewicht.getText());
        denyLabel.setText("");
        opgeslagenLabel.setText("Information succesfully saved!");
        System.out.println("Gegevens zijn opgeslagen!");
        JDBCMethods.setBagageDatabase(bagage);
        disableFields();
       } 
       */
    private void opslaanBagage(ActionEvent event) {
        if (checkText() == false) {
            denyLabel.setText("You did not fill in all textfields!");
        } else {
            disableFields();
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
            bagage.setBagagemerk(merk.getText());
            bagage.setPrimaireKleur(primaireKleur.getText());
            bagage.setSecundaireKleur(secundaireKleur.getText());
            bagage.setFormaat(formaat.getText());
//           System.out.println(reiziger.getVoornaam());
            bagage.setGewichtInKG(gewicht.getText());
            denyLabel.setText("");
            opgeslagenLabel.setText("Information succesfully saved!");
            System.out.println("Gegevens zijn opgeslagen!");
            JDBCMethods.createtBagageDatabase(bagage);
        } 
    }

    public void annuleerText() {
        TextField[] annuleer = {
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
            formaat,
            gewicht
        };

        for (int i = 0; i < annuleer.length; i++) {
            annuleer[i].setText("");
        }
    }

    @FXML
    private void annuleerBagage(ActionEvent event) {
        denyLabel.setText("");
        opgeslagenLabel.setText("");
        datumGevonden.getEditor().setDisable(false);
        datumGevonden.getEditor().setText("");
        annuleerText();
    }

    @FXML
    private void nieuwFormulier(ActionEvent event) {
        opgeslagenLabel.setText("");
        annuleerText();
        enableFields();
        denyLabel.setText("");
        opgeslagenLabel.setText("");
    }

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
