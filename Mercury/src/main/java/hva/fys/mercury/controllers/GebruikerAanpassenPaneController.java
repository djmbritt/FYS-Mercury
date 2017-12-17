/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.DatabaseManager;
import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.MainApp;
import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class beheert het scherm voor het aanpasssen van de gebruiker
 *
 * @author David Britt
 */
public class GebruikerAanpassenPaneController implements Initializable {

    ResourceBundle RsBundle = ResourceBundle.getBundle("UIResources", LoginController.locale);
    /*
    Zet je textfield voor je gebruikeraanpassen.fxml text fields hier beneden
     */
    @FXML
    private Label EmployeeID;
    @FXML
    private TextField Initials;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField MiddleName;
    @FXML
    private TextField SurName;
    @FXML
    private DatePicker BirthDate;
    @FXML
    private DatePicker StartEmploymentDate;
    @FXML
    private TextField WorkEmail;
    @FXML
    private ChoiceBox<String> WorkLocation;
    @FXML
    private ChoiceBox<String> StatusEmployment;
    @FXML
    private DatePicker EndDateEmployment;
    @FXML
    private TextField PersonalEmail;
    @FXML
    private TextField MobilePhoneNumber;
    @FXML
    private TextField HomePhoneNumber;
    @FXML
    private TextField DepartmentEmployment;
    @FXML
    private TextField HomeAdress;
    @FXML
    private TextField PostalCode;
    @FXML
    private PasswordField WachtWoord;
    @FXML
    private PasswordField WachtWoordVerificatie;

    private ParentControllerContext parentController;
    private Gebruiker gebruiker;

    GebruikerDAO gebruikerDAO = new GebruikerDAO();
    ObservableList<String> statusList = FXCollections.<String>observableArrayList(RsBundle.getString("admin.22"), RsBundle.getString("admin.23"), RsBundle.getString("admin.24"), RsBundle.getString("admin.25"), RsBundle.getString("admin.26"), RsBundle.getString("admin.27"));
    ObservableList<String> werkLocatieList = FXCollections.<String>observableArrayList(gebruikerDAO.getLuchtHavenList());
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH);

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        WorkLocation.getItems().addAll(werkLocatieList);
        StatusEmployment.getItems().addAll(statusList);
    }
 
    public void setParentContext(ParentControllerContext pC, Gebruiker gbrkr) {
        System.out.println("this.parentcontroller: " + pC.toString());
        System.out.println("this.founLuggage: " + gbrkr.toString());
        this.parentController = pC;
        this.gebruiker = gbrkr;
        this.initFields(gbrkr);
        pC.displayStatusMessage("Editing found luggage");
    }

    /**
     * vul alle velden in met de informatie van de geselecteerde gebruiker
     * @param gbrkr Gebruiker model met daarin informatie over de gebruiker     
     */
    private void initFields(Gebruiker gbrkr) {

        EmployeeID.setText(Integer.toString(gbrkr.getEmployeeID()));
        Initials.setText(gbrkr.getInitials());
        FirstName.setText(gbrkr.getFirstName());
        MiddleName.setText(gbrkr.getMiddleName());
        SurName.setText(gbrkr.getSurName());
        WorkEmail.setText(gbrkr.getWorkEmail());

        //Je moet deze veranderen naar een andere waarde.
        if (gebruiker.getBirthDate() != null && !gebruiker.getBirthDate().isEmpty()) {
            BirthDate.setValue(LocalDate.parse(gebruiker.getBirthDate(), dateFormatter));
        }

        if (gebruiker.getStartEmploymentDate() != null && !gebruiker.getStartEmploymentDate().isEmpty()) {
            StartEmploymentDate.setValue(LocalDate.parse(gebruiker.getStartEmploymentDate(), dateFormatter));
        }

        if (gebruiker.getEndDateEmployment() != null && !gebruiker.getEndDateEmployment().isEmpty()) {
            StartEmploymentDate.setValue(LocalDate.parse(gebruiker.getEndDateEmployment(), dateFormatter));
        }

        WorkLocation.setValue(gbrkr.getWorkingLocation());
        StatusEmployment.setValue(gbrkr.getStatusEmployment());

        PersonalEmail.setText(gbrkr.getPersonalEmail());
        MobilePhoneNumber.setText(gbrkr.getMobilePhoneNumber());
        DepartmentEmployment.setText(gbrkr.getDepartmentEmployment());
        HomeAdress.setText(gbrkr.getHomeAdress());
        PostalCode.setText(gbrkr.getPostalCode());

        WachtWoord.setText(gebruikerDAO.getPassword(gebruiker.getWorkEmail()));
        WachtWoordVerificatie.setText(gebruikerDAO.getPassword(gebruiker.getWorkEmail()));
    }

    /**
     * annuleert het bewerken van de Gebruiker
     * @param event 
     */
    @FXML
    public void handleCancelAction(ActionEvent event) {
        System.out.println("Canceling");
        this.gebruiker = null;
        this.parentController.deleteLastElement();
        this.parentController.displayStatusMessage("Cancelled editing found luggage...");
        this.parentController.notifyCloseChild();
    }

    /**
     * slaat informatie van de gebruiker op en verstuurt dat naar de database
     * @param event 
     */
    @FXML
    public void handleSaveAction(ActionEvent event) {
        System.out.println("Saving....");

        this.gebruiker.setEmployeeID(Integer.parseInt(EmployeeID.getText()));
        this.gebruiker.setInitials(Initials.getText());
        this.gebruiker.setFirstName(FirstName.getText());
        this.gebruiker.setMiddleName(MiddleName.getText());
        this.gebruiker.setSurName(SurName.getText());

        if (BirthDate.getValue() != null) {
            this.gebruiker.setBirthDate(BirthDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        if (StartEmploymentDate.getValue() != null) {
            this.gebruiker.setStartEmploymentDate(StartEmploymentDate.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        if (EndDateEmployment.getValue() != null) {
            this.gebruiker.setEndDateEmployment(EndDateEmployment.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        this.gebruiker.setWorkEmail(WorkEmail.getText());
        this.gebruiker.setWorkingLocation(WorkLocation.getValue());
        this.gebruiker.setStatusEmployment(StatusEmployment.getValue());
        this.gebruiker.setPersonalEmail(PersonalEmail.getText());
        this.gebruiker.setMobilePhoneNumber(MobilePhoneNumber.getText());
        this.gebruiker.setDepartmentEmployment(DepartmentEmployment.getText());
        this.gebruiker.setHomeAdress(HomeAdress.getText());
        this.gebruiker.setPostalCode(PostalCode.getText());

        if (WachtWoord.getText().equals(WachtWoordVerificatie.getText())) {
            this.gebruiker.setWachtWoord(WachtWoord.getText());
            DatabaseManager db = new DatabaseManager(MainApp.DATABASE_NAME);
            String reUpGebruikerQuery = String.format("SELECT EmployeeID FROM Gebruikers WHERE EmployeeID='%d'", this.gebruiker.getEmployeeID());
            String registreerOfUpdateGebruiker = db.executeStringQuery(reUpGebruikerQuery);

            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            if (registreerOfUpdateGebruiker != null) {
                gebruikerDAO.updateGebruiker(this.gebruiker);
                confirmation.setContentText("Updated Gebruiker: " + this.gebruiker.getFirstName() + " to Database 😁");
                confirmation.showAndWait();
                this.parentController.displayStatusMessage("Saving new information");
                this.parentController.notifyChildHasUpdated();
                this.parentController.notifyCloseChild();

            } else {
                String stringWorkMail = db.executeStringQuery(String.format("SELECT WorkEmail FROM Gebruikers WHERE WorkEmail='%s';", this.gebruiker.getWorkEmail()));

                if (this.gebruiker.getWorkEmail().equalsIgnoreCase(stringWorkMail)) {
                    Alert workMailAlertExist = new Alert(Alert.AlertType.ERROR);
                    workMailAlertExist.setContentText("This workmail is allready being used.");
                    workMailAlertExist.showAndWait();
                    return;
                } else {
                    gebruikerDAO.registreerGebruiker(this.gebruiker);
                    confirmation.setContentText("Saved new Gebruiker: " + this.gebruiker.getFirstName() + " to Database 😁");
                    confirmation.showAndWait();
                    this.parentController.displayStatusMessage("Saving new information");
                    this.parentController.notifyChildHasUpdated();
                    this.parentController.notifyCloseChild();

                }
            }

        } else {
            Alert wachtWoordIncorrect = new Alert(Alert.AlertType.ERROR);
            wachtWoordIncorrect.setContentText("Je wachtwoord komt niet overeen met elkaar.");
            wachtWoordIncorrect.showAndWait();
        }

    }

    /**
     * maakt alle aanpassingen ongedaan
     * @param event 
     */
    @FXML
    public void handleResetAction(ActionEvent event) {

        EmployeeID.setText(Integer.toString(this.gebruiker.getEmployeeID()));
        Initials.setText(this.gebruiker.getInitials());
        FirstName.setText(this.gebruiker.getFirstName());
        MiddleName.setText(this.gebruiker.getMiddleName());
        SurName.setText(this.gebruiker.getSurName());

        if (gebruiker.getBirthDate() != null) {
            BirthDate.setValue(LocalDate.parse(gebruiker.getBirthDate(), dateFormatter));
        }

        if (gebruiker.getStartEmploymentDate() != null) {
            StartEmploymentDate.setValue(LocalDate.parse(gebruiker.getStartEmploymentDate(), dateFormatter));
        }

        if (gebruiker.getEndDateEmployment() != null) {
            StartEmploymentDate.setValue(LocalDate.parse(gebruiker.getEndDateEmployment(), dateFormatter));
        }

        WorkEmail.setText(this.gebruiker.getWorkEmail());
        WorkLocation.setValue(this.gebruiker.getWorkingLocation());
        StatusEmployment.setValue(this.gebruiker.getStatusEmployment());
        PersonalEmail.setText(this.gebruiker.getPersonalEmail());
        MobilePhoneNumber.setText(this.gebruiker.getMobilePhoneNumber());
        DepartmentEmployment.setText(this.gebruiker.getDepartmentEmployment());
        HomeAdress.setText(this.gebruiker.getHomeAdress());
        PostalCode.setText(this.gebruiker.getPostalCode());

        this.parentController.displayStatusMessage("resseting information");
    }

    /**
     * maakt velden leeg
     * @param event 
     */
    @FXML
    public void handleClearAction(ActionEvent event) {

        EmployeeID.setText(null);
        Initials.setText(null);
        FirstName.setText(null);
        MiddleName.setText(null);
        SurName.setText(null);
        BirthDate.setValue(null);
        StartEmploymentDate.setValue(null);
        WorkEmail.setText(null);
        WorkLocation.setValue(null);
        StatusEmployment.setValue(null);
        EndDateEmployment.setValue(null);
        PersonalEmail.setText(null);
        MobilePhoneNumber.setText(null);
        HomePhoneNumber.setText(null);
        DepartmentEmployment.setText(null);
        HomeAdress.setText(null);
        PostalCode.setText(null);
        WachtWoord.setText(null);
        WachtWoordVerificatie.setText(null);

        this.parentController.displayStatusMessage("Clearing everything");
    }
}
