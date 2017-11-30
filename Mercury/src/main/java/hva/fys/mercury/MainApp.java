package hva.fys.mercury;

import hva.fys.mercury.models.MyJDBC;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css"); 
        stage.setTitle("Mercury");
          stage.getIcons().add(new Image("/images/corendon_icon.png"));
        stage.setMaximized(false);
      //  stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        MyJDBC.createDatabase("Corendon");
        launch(args);
    }

}
