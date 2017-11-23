package hva.fys.mercury.services;

import hva.fys.mercury.models.Bagage;
import hva.fys.mercury.models.Reiziger;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class FormHandler {

    public Bagage bindToBagageObject(Parent parent, Bagage bagage) {
        List<TextField> textFieldList = new ArrayList();
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                System.out.println(node.getId());
                textFieldList.add((TextField) node);
            }
        }
        bagage.setAllProperties(textFieldList);

        return bagage;
    }

    public Reiziger bindToBagageObject(Parent parent, Reiziger reiziger) {
        List<TextField> textFieldList = new ArrayList();
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof TextField) {
                System.out.println(node.getId());
                textFieldList.add((TextField) node);
            }
        }
        reiziger.setAllProperties(textFieldList);

        return reiziger;
    }
}
