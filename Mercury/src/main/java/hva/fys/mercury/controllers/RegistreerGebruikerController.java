package hva.fys.mercury.controllers;

import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class die de gebruikers registreert
 *
 * @author Yassine Idrissi
 */
public class RegistreerGebruikerController implements Initializable {

    @FXML
    public TextField initialenM;
    public TextField voornaamM;
    public TextField tussenvoegselM;
    public TextField achternaamM;
    public DatePicker geboorteDatumM;
    public DatePicker beginContractM;
    public DatePicker eindeContractM;
    public TextField zakelijkEmailM;
    public TextField locatieM;
    public TextField statusM;
    public TextField priveEmailM;
    public TextField telefoonM;
    public TextField postcodeM;
    public TextField adresM;
    public TextField departementM;
    @FXML
    private Button opslaanBTNM;
    @FXML
    private Label opgeslagenLabelM;
    @FXML
    private Label denyLabelM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
            initialenM,
            voornaamM,
            tussenvoegselM,
            achternaamM,
            zakelijkEmailM,
            locatieM,
            statusM,
            priveEmailM,
            telefoonM,
            postcodeM,
            adresM,
            departementM
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
            initialenM,
            voornaamM,
            tussenvoegselM,
            achternaamM,
            zakelijkEmailM,
            locatieM,
            statusM,
            priveEmailM,
            telefoonM,
            postcodeM,
            adresM,
            departementM
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
            initialenM,
            voornaamM,
            tussenvoegselM,
            achternaamM,
            zakelijkEmailM,
            locatieM,
            statusM,
            priveEmailM,
            telefoonM,
            postcodeM,
            adresM,
            departementM
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
    private void opslaanMedewerkerM(ActionEvent event) {
        if (checkText() == false) {
            denyLabelM.setText("You did not fill in all textfields!");
        } else {
            disableFields();
            geboorteDatumM.getEditor().setDisable(true);
            beginContractM.getEditor().setDisable(true);
            eindeContractM.getEditor().setDisable(true);
            Gebruiker gebruiker = new Gebruiker();
            gebruiker.setInitials(initialenM.getText());
            gebruiker.setFirstName(voornaamM.getText());
            gebruiker.setMiddleName(tussenvoegselM.getText());
            gebruiker.setSurName(achternaamM.getText());
            gebruiker.setBirthDate(geboorteDatumM.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            gebruiker.setStartEmploymentDate(beginContractM.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            gebruiker.setEndDateEmployment(eindeContractM.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            gebruiker.setWorkEmail(zakelijkEmailM.getText());
            gebruiker.setWorkingLocation(locatieM.getText());
            gebruiker.setStatusEmployment(statusM.getText());
            gebruiker.setPersonalEmail(priveEmailM.getText());
            gebruiker.setMobilePhoneNumber(telefoonM.getText());
            gebruiker.setPostalCode(postcodeM.getText());
            gebruiker.setHomeAdress(adresM.getText());
            gebruiker.setDepartmentEmployment(departementM.getText());

            denyLabelM.setText("");
            opgeslagenLabelM.setText("Gegevens succesvol opgeslagen!");
            System.out.println("Gegevens zijn opgeslagen!");

//            GebruikerDAO.registreerGebruiker(gebruiker);
        }
    }

    /**
     * maak alle TextFields leeg
     */
    public void annuleerText() {
        TextField[] annuleer = {
            initialenM,
            voornaamM,
            tussenvoegselM,
            achternaamM,
            zakelijkEmailM,
            locatieM,
            statusM,
            priveEmailM,
            telefoonM,
            postcodeM,
            adresM,
            departementM
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
    private void annuleerMedewerkerM(ActionEvent event) {
        denyLabelM.setText("");
        opgeslagenLabelM.setText("");
        geboorteDatumM.getEditor().setDisable(false);
        geboorteDatumM.getEditor().setText("");
        beginContractM.getEditor().setDisable(false);
        beginContractM.getEditor().setText("");
        eindeContractM.getEditor().setDisable(false);
        eindeContractM.getEditor().setText("");
        annuleerText();

    }

    /**
     * zorgt ervoor dat alle velden en labels gereset worden.
     *
     * @param event
     */
    @FXML
    private void nieuwFormulierM(ActionEvent event) {
        denyLabelM.setText("");
        opgeslagenLabelM.setText("");
        geboorteDatumM.getEditor().setDisable(false);
        geboorteDatumM.getEditor().setText("");
        beginContractM.getEditor().setDisable(false);
        beginContractM.getEditor().setText("");
        eindeContractM.getEditor().setDisable(false);
        eindeContractM.getEditor().setText("");
        annuleerText();
        enableFields();
    }

}
