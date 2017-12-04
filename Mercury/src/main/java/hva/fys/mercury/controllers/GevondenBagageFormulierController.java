package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.DAO.JDBCMethods;
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

/**
 * FXML Controller class
 *
 * @author Eigenaar
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    statusG.getItems().addAll(
    "Vermist",
    "Gevonden",
    "Afgehandeld"
);
    bagageTypeG.getItems().addAll(
    "Koffer",
    "Tas",
    "Rugzak",
    "Doos",
    "Sporttas",
    "Zakenkoffer",
    "Kist",
    "Anders"
    );
    }

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

    @FXML
    private Button opslaanBTNG;
    @FXML
    private Label opgeslagenLabelG;
    @FXML
    private Label denyLabelG;

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

            BagageDAO.registreerBagage(bagage);
        }
    }

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

    @FXML
    private void annuleerBagageG(ActionEvent event) {
        denyLabelG.setText("");
        opgeslagenLabelG.setText("");
        datumGevondenG.getEditor().setDisable(false);
        datumGevondenG.getEditor().setText("");
        annuleerText();

    }

    @FXML
    private void nieuwFormulierG(ActionEvent event) {
        denyLabelG.setText("");
        opgeslagenLabelG.setText("");
        datumGevondenG.getEditor().setDisable(false);
        datumGevondenG.getEditor().setText("");
        annuleerText();
        enableFields();
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
