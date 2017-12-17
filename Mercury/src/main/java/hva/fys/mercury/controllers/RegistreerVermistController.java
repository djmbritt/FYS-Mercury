package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger; 
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML; 
import javafx.fxml.Initializable; 
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class die de vermiste bagage registreert
 *
 * @author Mitchell Wan
 */
public class RegistreerVermistController implements Initializable  {

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

    @FXML
    private Button opslaanBTN;

    @FXML
    private Label opgeslagenLabel;

    @FXML
    private Label denyLabel;

    private ParentControllerContext parentController;

    ResourceBundle RsBundle = ResourceBundle.getBundle("UIResources", LoginController.locale);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        status.getItems().addAll(
                RsBundle.getString("gevonden.5"),
                RsBundle.getString("gevonden.6"),
                RsBundle.getString("gevonden.7")
        );
        bagageType.getItems().addAll(
                RsBundle.getString("gevonden.8"),
                RsBundle.getString("gevonden.9"),
                RsBundle.getString("gevonden.10"),
                RsBundle.getString("gevonden.11"),
                RsBundle.getString("gevonden.12"),
                RsBundle.getString("gevonden.13"),
                RsBundle.getString("gevonden.14"),
                RsBundle.getString("gevonden.15")
        );
    }

    /**
     * controleert of alle TextFields zijn ingevuld en geeft een boolean waarde
     * terug
     *
     * @return een boolean met waarde 'true' als ze zijn ingevuld en de waarde
     * 'false' als ze niet zijn ingevuld
     */
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

    /**
     * maakt alle TextFields onbruikbaar
     */
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

    /**
     * maakt alle TextFields bruikbaar
     */
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

    /**
     * Slaat alle informatie die in de textfields is opgeslagen op en verstuurt
     * de informatie naar de database
     *
     * @param event
     */
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

    /**
     * maak alle TextFields leeg
     */
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

    /**
     * maakt alle TextFields, DatePickers en Labels leeg en onbruikbaar
     *
     * @param event
     */
    @FXML
    private void annuleerBagage(ActionEvent event) {
        denyLabel.setText("");
        opgeslagenLabel.setText("");
        datumGevonden.getEditor().setDisable(false);
        datumGevonden.getEditor().setText("");
        annuleerText();
        showFormulier();
    }

    /**
     * zorgt ervoor dat alle velden en labels gereset worden.
     *
     * @param event
     */
    @FXML
    private void nieuwFormulier(ActionEvent event) {
        opgeslagenLabel.setText("");
        annuleerText();
        enableFields();
        denyLabel.setText("");
        opgeslagenLabel.setText("");
        showFormulier();

    }

    /**
     * geeft het pdf formulier weer
     */
    private void showPDF() {
        this.bagageOpslaanVerlorenPDF.setVisible(true);
        this.BagageOpslaan.setVisible(false);
    }

    /**
     * geeft het registratie formulier weer
     */
    private void showFormulier() {
        this.bagageOpslaanVerlorenPDF.setVisible(false);
        this.BagageOpslaan.setVisible(true);
    } 
}
