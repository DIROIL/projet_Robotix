import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lib.Db;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("interfaces/Interface_Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 741, 544);
        stage.setTitle("Robotix");
        stage.setScene(scene);
        stage.show();

        Db db = new Db();
        db.connect();
    }

    public static void main(String[] args) {
        launch();
    }

}
