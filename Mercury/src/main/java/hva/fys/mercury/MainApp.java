package hva.fys.mercury;

import hva.fys.mercury.DAO.DataBaseCreator;
import hva.fys.mercury.DAO.PopulateDB;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApp extends Application {

    public final static String DATABASE_NAME = "MercuryTest";

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
        DataBaseCreator.createDatabase(DATABASE_NAME);
        PopulateDB.insertExamplesIntoDB();

        launch(args);
    }

}
