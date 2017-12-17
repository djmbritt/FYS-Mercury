package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author Mitchell Wan
 */
public class GevondenBagageFormulierController implements Initializable {

    @FXML
    public TextField bagageLabelG;
    public TextField vluchtNummerG;
    public DatePicker datumGevondenG;
    public TextField tijdGevondenG;
    public TextField locatieGevondenG;
    public TextField merkG;
    public TextField primaireKleurG;
    public TextField secundaireKleurG;
    public TextField formaatG;
    public TextField gewichtG;
    public ComboBox statusG;
    public TextField overigeEigenschappenG;
    public ComboBox bagageTypeG;
    public TextField IATAG;

    @FXML
    private Button opslaanBTNG;
    @FXML
    private Label opgeslagenLabelG;
    @FXML
    private Label denyLabelG;

    private BagageDAO dbBagage;

    @FXML
    private AnchorPane BagagePDFG;

    @FXML
    private GridPane BagageOpslaanG;

    ResourceBundle RsBundle = ResourceBundle.getBundle("UIResources", LoginController.locale);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbBagage = new BagageDAO();
        statusG.getItems().addAll(
                RsBundle.getString("gevonden.5"),
                RsBundle.getString("gevonden.6"),
                RsBundle.getString("gevonden.7")
        );
        bagageTypeG.getItems().addAll(
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
            bagageLabelG,
            vluchtNummerG,
            tijdGevondenG,
            locatieGevondenG,
            merkG,
            primaireKleurG,
            secundaireKleurG,
            formaatG,
            gewichtG,
            overigeEigenschappenG,
            IATAG
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
            bagageLabelG,
            vluchtNummerG,
            tijdGevondenG,
            locatieGevondenG,
            merkG,
            primaireKleurG,
            secundaireKleurG,
            formaatG,
            gewichtG,
            overigeEigenschappenG,
            IATAG
        };
        for (int i = 0; i < text.length; i++) {
            text[i].setDisable(true);

        }
    }

    /**
     * maakt alle TextFields bruikbaar
     */
    public void enableFields() {
        TextField[] text = {
            bagageLabelG,
            vluchtNummerG,
            tijdGevondenG,
            locatieGevondenG,
            merkG,
            primaireKleurG,
            secundaireKleurG,
            formaatG,
            gewichtG,
            overigeEigenschappenG,
            IATAG
        };
        for (int i = 0; i < text.length; i++) {
            text[i].setDisable(false);
        }
    }

    /**
     * Slaat alle informatie die in de textfields is opgeslagen op en verstuurt
     * de informatie naar de database
     *
     * @param event
     */
    @FXML
    private void opslaanBagageG(ActionEvent event) {
        if (checkText() == false) {
            denyLabelG.setText("You did not fill in all textfields!");
        } else {
            disableFields();
            datumGevondenG.getEditor().setDisable(true);
            Bagage bagage = new Bagage();
            bagage.setBagagelabel(bagageLabelG.getText());
            bagage.setVluchtNummer(vluchtNummerG.getText());
            bagage.setDatumGevonden(datumGevondenG.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            bagage.setTijdGevonden(tijdGevondenG.getText());
            bagage.setGevondenLocatie(locatieGevondenG.getText());
            bagage.setBagageType(bagageTypeG.getValue().toString());
            bagage.setBagagemerk(merkG.getText());
            bagage.setPrimaireKleur(primaireKleurG.getText());
            bagage.setSecundaireKleur(secundaireKleurG.getText());
            bagage.setFormaat(formaatG.getText());
            bagage.setGewichtInKG(gewichtG.getText());
            bagage.setOverigeEigenschappen(overigeEigenschappenG.getText());
            bagage.setStatus(statusG.getValue().toString());
            bagage.setIATA_Code(IATAG.getText());
            denyLabelG.setText("");
            opgeslagenLabelG.setText("Gegevens succesvol opgeslagen!");
            System.out.println("Gegevens zijn opgeslagen!");
            showPDF();
            dbBagage.registreerBagage(bagage);
        }
    }

    /**
     * maak alle TextFields leeg
     */
    public void annuleerText() {
        TextField[] annuleer = {
            bagageLabelG,
            vluchtNummerG,
            tijdGevondenG,
            locatieGevondenG,
            merkG,
            primaireKleurG,
            secundaireKleurG,
            formaatG,
            gewichtG,
            overigeEigenschappenG,
            IATAG
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
    private void annuleerBagageG(ActionEvent event) {
        denyLabelG.setText("");
        opgeslagenLabelG.setText("");
        datumGevondenG.getEditor().setDisable(false);
        datumGevondenG.getEditor().setText("");
        annuleerText();
        showFormulier();
    }

    /**
     * zorgt ervoor dat alle velden en labels gereset worden.
     *
     * @param event
     */
    @FXML
    private void nieuwFormulierG(ActionEvent event) {
        denyLabelG.setText("");
        opgeslagenLabelG.setText("");
        datumGevondenG.getEditor().setDisable(false);
        datumGevondenG.getEditor().setText("");
        annuleerText();
        enableFields();
        showFormulier();
    }

    /**
     * geeft het pdf formulier weer
     */
    private void showPDF() {
        BagagePDFG.setVisible(true);
        BagageOpslaanG.setVisible(false);
    }

    /**
     * geeft het registratie formulier weer
     */
    private void showFormulier() {
        BagagePDFG.setVisible(false);
        BagageOpslaanG.setVisible(true);
    }
}
