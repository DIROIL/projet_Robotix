import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.scene.layout.VBox;

public class Contro_Interface_Acceuil {
    @FXML
    private VBox menuVBox;

    @FXML
    private VBox loginVBox;

    @FXML
    private Button gotoLogin;

    @FXML
    private void handleListUsers() {
        showAlert("Liste des utilisateurs");
    }

    @FXML
    private void handleSearchUser() {
        showAlert("Rechercher un utilisateur");
    }

    @FXML
    private void handleViewProfile() {
        showAlert("Voir le profil d'un utilisateur");
    }

    @FXML
    private void handleListActivities() {
        showAlert("Liste des activités");
    }

    @FXML
    private void handleListSuppliers() {
        showAlert("Liste des fournisseurs");
    }

    @FXML
    private void handleSearchSupplier() {
        showAlert("Rechercher un fournisseur");
    }

    @FXML
    private void handleSearchComponent() {
        showAlert("Rechercher une composante");
    }

//    @FXML
//    private void handleLogin() {
//        menuVBox.setVisible(false);
//        loginVBox.setVisible(true);
//    }

//    @FXML
//    private void handleCancelLogin() {
//        loginVBox.setVisible(false);
//        menuVBox.setVisible(true);
//    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    public void execute() throws IOException {

        // Charger le fichier form.fxml.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/form.fxml"));
        Parent root = loader.load();

        // Récupérer la fenêtre actuelle
        Stage currentStage = (Stage)gotoLogin.getScene().getWindow();
        // Changer la scène de la fenêtre actuelle
        currentStage.setScene(new Scene(root));
        currentStage.show();

    }

}
