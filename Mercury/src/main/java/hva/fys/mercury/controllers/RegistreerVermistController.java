package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Mitchell Wan
 */
public class RegistreerVermistController implements Initializable, ParentControllerContext {

    Bagage bagage = new Bagage();
    Reiziger reiziger = new Reiziger();
    @FXML
    public TextField voornaam;
    @FXML
    public TextField achternaam;
    @FXML
    public TextField adres;
    @FXML
    public TextField woonplaats;
    @FXML
    public TextField postcode;
    @FXML
    public TextField land;
    @FXML
    public TextField telefoonnummer;
    @FXML
    public TextField email;
    @FXML
    public TextField bagageLabel;
    @FXML
    public TextField vluchtNummer;
    @FXML
    public DatePicker datumGevonden;
    @FXML
    public TextField tijdGevonden;
    @FXML
    public TextField locatieGevonden;
    @FXML
    public ComboBox bagageType;
    @FXML
    public ComboBox status;
    @FXML
    public TextField merk;
    @FXML
    public TextField primaireKleur;
    @FXML
    public TextField secundaireKleur;
    @FXML
    public TextField formaat;
    @FXML
    public TextField gewicht;
    @FXML
    public TextField IATA;
    @FXML
    public TextField overigeEigenschappen;

    @FXML
    private GridPane BagageOpslaan;

    @FXML
    private GridPane bagageOpslaanVerlorenPDF;

    @FXML
    private BagageOpslaanVerlorenPDFController bagageOpslaanVerlorenPDFController;

    private ParentControllerContext parentController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        System.out.println("Starting registreer Verloren Bagage");
//        status.getItems().addAll(
//                "Vermist",
//                "Gevonden",
//                "Afgehandeld"
//        );
//        bagageType.getItems().addAll(
//                "Koffer",
//                "Tas",
//                "Rugzak",
//                "Doos",
//                "Sporttas",
//                "Zakenkoffer",
//                "Kist",
//                "Anders"
//        );
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
            IATA,
            merk,
            primaireKleur,
            secundaireKleur,
            formaat,
            gewicht,
            overigeEigenschappen
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
            IATA,
            merk,
            primaireKleur,
            secundaireKleur,
            formaat,
            gewicht,
            overigeEigenschappen
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
            IATA,
            merk,
            primaireKleur,
            secundaireKleur,
            formaat,
            gewicht,
            overigeEigenschappen
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

    public void opslaanBagage(ActionEvent event) {
        BagageDAO dbBagage = new BagageDAO();
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
            bagage.setBagageType(bagageType.getValue().toString());
            bagage.setBagagemerk(merk.getText());
            bagage.setPrimaireKleur(primaireKleur.getText());
            bagage.setSecundaireKleur(secundaireKleur.getText());
            bagage.setFormaat(formaat.getText());
            bagage.setGewichtInKG(gewicht.getText());
            bagage.setIATA_Code(IATA.getText());
            bagage.setStatus(status.getValue().toString());
            bagage.setOverigeEigenschappen(overigeEigenschappen.getText());
            denyLabel.setText("");
            dbBagage.registreerBagage(bagage);
            opgeslagenLabel.setText("Information succesfully saved!");
            System.out.println("Gegevens zijn opgeslagen!");
//            bagageOpslaanVerlorenPDFController.fillLabels
//            bagageOpslaanVerlorenPDFController.setParentContext(this, bagage, reiziger);
//            showPDF();
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
            IATA,
            merk,
            primaireKleur,
            secundaireKleur,
            formaat,
            gewicht,
            overigeEigenschappen
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
        showFormulier();
    }

    @FXML
    private void nieuwFormulier(ActionEvent event) {
        opgeslagenLabel.setText("");
        annuleerText();
        enableFields();
        denyLabel.setText("");
        opgeslagenLabel.setText("");
        showFormulier();

    }

    private void showPDF() {
        this.bagageOpslaanVerlorenPDF.setVisible(true);
        this.BagageOpslaan.setVisible(false);
    }

    private void showFormulier() {
        this.bagageOpslaanVerlorenPDF.setVisible(false);
        this.BagageOpslaan.setVisible(true);
    }

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }

    @Override
    public void notifyCloseChild() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notifyChildHasUpdated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayStatusMessage(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferObject(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
