/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hva.fys.mercury.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Daniel
 */
public class veranderLocatieController {
    
    
    @FXML
    private void veranderLocatieBevestig(ActionEvent event) {
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
