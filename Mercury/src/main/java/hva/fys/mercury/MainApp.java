package hva.fys.mercury;

import hva.fys.mercury.DAO.DataBaseCreator;
import hva.fys.mercury.DAO.PopulateDB;
import hva.fys.mercury.controllers.ContentController;
import hva.fys.mercury.controllers.LoginController;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.application.Application; 
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

 
public class MainApp extends Application {

    public final static String DATABASE_NAME = "MercuryTest";
    
    public static Stage stage1;


    @Override
    public void start(Stage stage) throws Exception { 
        stage1 = stage;
        LoginController.locale = new Locale("en", "US");
        ResourceBundle bundle = ResourceBundle.getBundle("UIResources", LoginController.locale);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"), bundle);
        Parent root = loader.load();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
//        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        stage1.setTitle("Mercury");
        stage1.getIcons().add(new Image("/images/corendon_icon.png"));
        stage1.setMaximized(false);
        //  stage.setResizable(false);
        stage1.setScene(scene);
        stage1.show();
    }

    public static void main(String[] args) {
        DataBaseCreator.createDatabase(DATABASE_NAME);
        PopulateDB.insertExamplesIntoDB();

        launch(args);
    }
    
    

}
