package hva.fys.mercury;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class FXMLController implements Initializable {

    @FXML
    private void openRegistreerGevondenbagage(ActionEvent event) {
        System.out.println("registreer bagage geopend ");
    }

    @FXML
    private void openRegistreerVerlorenbagage(ActionEvent event) {
        System.out.println("verloren bagage geopend ");
    }

    @FXML
    private void openDashboard(ActionEvent event) {
        System.out.println("dashboard geopend ");
    }

    @FXML
    private void openBagageZoeken(ActionEvent event) {
        System.out.println("bagage zoeken geopend ");
    }
    
   @FXML
    private void openManagerOverzicht(ActionEvent event) {
        System.out.println("manager  geopend ");
    }
     @FXML
    private void logout(ActionEvent event) {
        System.out.println("iutloggen ");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
