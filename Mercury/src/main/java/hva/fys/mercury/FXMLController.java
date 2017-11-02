package hva.fys.mercury;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable; 

public class FXMLController implements Initializable {
    
    @FXML
    private void RegistreerGevondenbagage(ActionEvent event) {
        System.out.println("registreer bagage geopend "); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
