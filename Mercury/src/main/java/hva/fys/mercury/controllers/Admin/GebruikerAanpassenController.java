/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers.Admin;

import hva.fys.mercury.models.Gebruiker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class GebruikerAanpassenController implements Initializable {

    /*
    Zet je textfield voor je gebruikeraanpassen.fxml text fields hier beneden
     */
    @FXML
    private TextField EmployeeID;
    private TextField Initials;
    private TextField FirstName;
    private TextField MiddleName;
    private TextField SurName;
    private TextField BirthDate;
    private TextField StartEmploymentDate;
    private TextField WorkEmail;
    private TextField WorkingLocation;
    private TextField StatusEmployment;
    private TextField EndDateEmployment;
    private TextField PersonalEmail;
    private TextField MobilePhoneNumber;
    private TextField HomePhoneNumber;
    private TextField DepartmentEmployment;
    private TextField HomeAdress;
    private TextField PostalCode;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private ParentControllerContext parentController;
    private Gebruiker gebruiker;

    public void setParentContext(ParentControllerContext pC, Gebruiker fl) {
        this.parentController = pC;
        this.gebruiker = fl;
        this.initFields(fl);
        pC.displayStatusMessage("Editing found luggage");
    }

    private void initFields(Gebruiker fl) {
        this.gebruiker = fl;
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

        this.parentController.displayStatusMessage("Saving new information");
        this.parentController.notifyChildHasUpdated();
        this.parentController.notifyCloseChild();

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
