package hva.fys.mercury.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hva.fys.mercury.DAO.GebruikerDAO; 
import hva.fys.mercury.models.Gebruiker;
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
 * @author Eigenaar
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

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

    @FXML
    private Button opslaanBTNM;
    @FXML
    private Label opgeslagenLabelM;
    @FXML
    private Label denyLabelM;

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

    private Parent loadFXMLFile(String fxmlFileName) {
        try {
            return FXMLLoader.load(getClass().getResource(fxmlFileName));
        } catch (IOException ex) {
            System.out.printf("\n%s: %s\n", ex.getClass().getName(), ex.getMessage());
            return null;
        }
    }
}
