package hva.fys.mercury.services;

import hva.fys.mercury.models.Bagage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class FormHandler {

   public Bagage bindToObject(Parent parent , Bagage bagage) {
        List<TextField> gild = new ArrayList();
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                System.out.println(node.getId());
                gild.add((TextField) node);
            }
        } 
        bagage.setAllProperties(gild);
        
        return bagage;
    }
}
