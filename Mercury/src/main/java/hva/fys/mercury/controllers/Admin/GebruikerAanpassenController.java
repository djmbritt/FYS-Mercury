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
    private TextField registrationNummerField;

    @FXML
    private TextField dateFoundField;

    @FXML
    private TextField timeFoundField;

    @FXML
    private TextField luggageTypeField;

    @FXML
    private TextField brandField;

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

//        this.gebruiker.setEmployeeID(registrationNummerField.getText()); Parse to int
        this.gebruiker.setFirstName(registrationNummerField.getText());

        this.parentController.displayStatusMessage("Saving new information");
        this.parentController.notifyChildHasUpdated();
        this.parentController.notifyCloseChild();

    }

    @FXML
    public void handleResetAction(ActionEvent event) {
        registrationNummerField.setText(this.gebruiker.getFirstName());
        dateFoundField.setText(this.gebruiker.getHomeAdress());
        timeFoundField.setText(this.gebruiker.getMiddleName());
        luggageTypeField.setText(this.gebruiker.getSurName());
        brandField.setText(this.gebruiker.getWorkEmail());

        this.parentController.displayStatusMessage("resseting information");
    }

    @FXML
    public void handleClearAction(ActionEvent event) {
        registrationNummerField.setText(null);
        dateFoundField.setText(null);
        timeFoundField.setText(null);
        luggageTypeField.setText(null);
        brandField.setText(null);

        this.parentController.displayStatusMessage("Clearing everything");
    }
}
