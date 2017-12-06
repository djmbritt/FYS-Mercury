package hva.fys.mercury.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

class BagageDetailsController implements Initializable {

    private ParentControllerContext parentController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setParentContext(ParentControllerContext pC) {
        System.out.println("this.parentcontroller: " + pC.toString());
        this.parentController = pC;
    }
}
