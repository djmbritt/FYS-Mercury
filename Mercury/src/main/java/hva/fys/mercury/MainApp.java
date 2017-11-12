package hva.fys.mercury;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
<<<<<<< HEAD
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
=======
import javafx.scene.Scene; 
>>>>>>> davidBranch
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Root.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
>>>>>>> davidBranch

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Mercury");
<<<<<<< HEAD
        stage.getIcons().add(new Image("/images/corendon_icon.png"));
        // stage.setFullScreen(Boolean.TRUE);
        stage.setResizable(false);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
=======
        stage.setMaximized(true);
        stage.setResizable(false);
>>>>>>> davidBranch
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
