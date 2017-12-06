/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

import hva.fys.mercury.DAO.BagageDAO;
import hva.fys.mercury.DAO.JDBCMethods;
import hva.fys.mercury.models.Bagage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Daniel
 */
public class veranderLocatieController  implements Initializable {
    @FXML
    private ComboBox IATABag;
    
    @FXML
    private Label huidigeLocatieLabel2;
    
    private final int BAGAGEID = 201622309;
    Bagage bagage = new Bagage();
    
    @Override
            public void initialize(URL url, ResourceBundle rb) {  
    IATABag.getItems().addAll (
            "AMS","AYT","IST","BJV","DLM","ADB","GZP","ECN","RAK","HER","KGS","RHO","ZTH","CFU","MJT","OHD","SMI","LPA","TFO","PMI","AGP","FUE","FAO","ACE","HRG","NBE","DXB","BOJ","BJL","CTA"
    );
    
    JDBCMethods methodsdb = new JDBCMethods();
    Bagage bag = BagageDAO.getBagage(BAGAGEID);
    
    huidigeLocatieLabel2.setText(bag.getIATA_Code());
            }
    
    @FXML
    private void veranderLocatieBevestig(ActionEvent event) {
        bagage.setRegistratieID(BAGAGEID);
        bagage.setIATA_Code(IATABag.getValue().toString());
    BagageDAO.bewerkLocatie(bagage);
    }
    
    @FXML
    static Stage popupStage;
    
    @FXML
     public static void veranderLocatiePopup() {
        try {
            FXMLLoader fxmlLoader;
            fxmlLoader = new FXMLLoader(RegistreerVermistController.class.getResource("/fxml/veranderLocatie.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            popupStage = new Stage();
            popupStage.initStyle(StageStyle.UNDECORATED);
            popupStage.setScene(new Scene(root1));  
            popupStage.show();
        }
        catch (Exception e) {
            System.out.println("Can't load pop-up");
        }
    }
     
    @FXML
    private void sluitLocatiePopup(ActionEvent event) {
        sluitLocatiePopup2();
    }
     @FXML
     public static void sluitLocatiePopup2() {
         popupStage.close();
     }
}
