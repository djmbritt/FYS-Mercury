/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers.Admin;

import hva.fys.mercury.DAO.GebruikerDAO;
import hva.fys.mercury.controllers.ParentControllerContext;
import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class GebruikerAanpassenPaneController implements Initializable {

    /*
    Zet je textfield voor je gebruikeraanpassen.fxml text fields hier beneden
     */
    @FXML
    private TextField EmployeeID;
    @FXML
    private TextField Initials;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField MiddleName;
    @FXML
    private TextField SurName;
    @FXML
    private TextField BirthDate;
    @FXML
    private TextField StartEmploymentDate;
    @FXML
    private TextField WorkEmail;
    @FXML
    private TextField WorkingLocation;
    @FXML
    private TextField StatusEmployment;
    @FXML
    private TextField EndDateEmployment;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private ParentControllerContext parentController;
    private Gebruiker gebruiker;

    public void setParentContext(ParentControllerContext pC, Gebruiker gbrkr) {
        System.out.println("this.parentcontroller: " + pC.toString());
        System.out.println("this.founLuggage: " + gbrkr.toString());
        this.parentController = pC;
        this.gebruiker = gbrkr;
        this.initFields(gbrkr);
        pC.displayStatusMessage("Editing found luggage");
    }

    private void initFields(Gebruiker gbrkr) {
        EmployeeID.setText(Integer.toString(gbrkr.getEmployeeID()));
        Initials.setText(gbrkr.getInitials());
        FirstName.setText(gbrkr.getFirstName());
        MiddleName.setText(gbrkr.getMiddleName());
        SurName.setText(gbrkr.getSurName());
        BirthDate.setText(gbrkr.getBirthDate());
        StartEmploymentDate.setText(gbrkr.getStartEmploymentDate());
        WorkEmail.setText(gbrkr.getWorkEmail());
        WorkingLocation.setText(gbrkr.getWorkingLocation());
        StatusEmployment.setText(gbrkr.getStatusEmployment());
        EndDateEmployment.setText(gbrkr.getEndDateEmployment());
        PersonalEmail.setText(gbrkr.getPersonalEmail());
        MobilePhoneNumber.setText(gbrkr.getMobilePhoneNumber());
//        HomePhoneNumber.setText(gbrkr.getHomePhoneNumber());
        DepartmentEmployment.setText(gbrkr.getDepartmentEmployment());
        HomeAdress.setText(gbrkr.getHomeAdress());
        PostalCode.setText(gbrkr.getPostalCode());
    }

    @FXML
    public void handleCancelAction(ActionEvent event) {
        System.out.println("Canceling");

        this.parentController.displayStatusMessage("Cancelled editing found luggage...");
        this.parentController.notifyCloseChild();
        this.gebruiker = null;

    }

    @FXML
    public void handleSaveAction(ActionEvent event) {
        System.out.println("Saving....");

        this.gebruiker.setEmployeeID(Integer.parseInt(EmployeeID.getText()));
        this.gebruiker.setInitials(Initials.getText());
        this.gebruiker.setFirstName(FirstName.getText());
        this.gebruiker.setMiddleName(MiddleName.getText());
        this.gebruiker.setSurName(SurName.getText());
        this.gebruiker.setBirthDate(BirthDate.getText());
        this.gebruiker.setStartEmploymentDate(StartEmploymentDate.getText());
        this.gebruiker.setWorkEmail(WorkEmail.getText());
        this.gebruiker.setWorkingLocation(WorkingLocation.getText());
        this.gebruiker.setStatusEmployment(StatusEmployment.getText());
        this.gebruiker.setEndDateEmployment(EndDateEmployment.getText());
        this.gebruiker.setPersonalEmail(PersonalEmail.getText());
        this.gebruiker.setMobilePhoneNumber(MobilePhoneNumber.getText());
//        this.gebruiker.setHomePhoneNumber(HomePhoneNumber.getText());
        this.gebruiker.setDepartmentEmployment(DepartmentEmployment.getText());
        this.gebruiker.setHomeAdress(HomeAdress.getText());
        this.gebruiker.setPostalCode(PostalCode.getText());

        try {
//            GebruikerDAO.updateGebruiker(this.gebruiker);
            GebruikerDAO.registreerGebruiker(this.gebruiker);
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setContentText("Saved to Database 😁");
            confirmation.showAndWait();
            this.parentController.displayStatusMessage("Saving new information");
            this.parentController.notifyChildHasUpdated();
            this.parentController.notifyCloseChild();

        } catch (Exception e) {
            System.err.print("Error saving to database: " + e);
        }

    }

    @FXML
    public void handleResetAction(ActionEvent event) {

        //zonder this???
        EmployeeID.setText(Integer.toString(this.gebruiker.getEmployeeID()));
        Initials.setText(this.gebruiker.getInitials());
        FirstName.setText(this.gebruiker.getFirstName());
        MiddleName.setText(this.gebruiker.getMiddleName());
        SurName.setText(this.gebruiker.getSurName());
        BirthDate.setText(this.gebruiker.getBirthDate());
        StartEmploymentDate.setText(this.gebruiker.getStartEmploymentDate());
        WorkEmail.setText(this.gebruiker.getWorkEmail());
        WorkingLocation.setText(this.gebruiker.getWorkingLocation());
        StatusEmployment.setText(this.gebruiker.getStatusEmployment());
        EndDateEmployment.setText(this.gebruiker.getEndDateEmployment());
        PersonalEmail.setText(this.gebruiker.getPersonalEmail());
        MobilePhoneNumber.setText(this.gebruiker.getMobilePhoneNumber());
//        HomePhoneNumber.setText(this.gebruiker.getHomePhoneNumber());
        DepartmentEmployment.setText(this.gebruiker.getDepartmentEmployment());
        HomeAdress.setText(this.gebruiker.getHomeAdress());
        PostalCode.setText(this.gebruiker.getPostalCode());

        this.parentController.displayStatusMessage("resseting information");
    }

    @FXML
    public void handleClearAction(ActionEvent event) {

        EmployeeID.setText(null);
        Initials.setText(null);
        FirstName.setText(null);
        MiddleName.setText(null);
        SurName.setText(null);
        BirthDate.setText(null);
        StartEmploymentDate.setText(null);
        WorkEmail.setText(null);
        WorkingLocation.setText(null);
        StatusEmployment.setText(null);
        EndDateEmployment.setText(null);
        PersonalEmail.setText(null);
        MobilePhoneNumber.setText(null);
        HomePhoneNumber.setText(null);
        DepartmentEmployment.setText(null);
        HomeAdress.setText(null);
        PostalCode.setText(null);

        this.parentController.displayStatusMessage("Clearing everything");
    }
}
