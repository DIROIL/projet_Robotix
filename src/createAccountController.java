import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Account;
import repository.AccountRepository;
import validations.Validations;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static service.Navigation.showMainMenu;

public class createAccountController {
    @FXML
    public Label lblLogin;
    @FXML
    private TextField emailField ;
    private Label label ;
    @FXML
    private TabPane tabPaneLogin ;
    @FXML
    private Tab tabProvider ;
    @FXML
    private Tab tabUser ;
    @FXML
    private Label lblCreateAccount ;
    @FXML
    private Pane slidingPane ;
    @FXML
    private Label lblProvider ;
    @FXML
    private Label lblUser ;
    @FXML
    private Label lblStatus ;
    @FXML
    private  TextField passwordField ;
    @FXML
    private Button gotoHome;
    @FXML
    private Label error;
    @FXML
    private TextField profilField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField1;
    @FXML
    private TextField pseudoField;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private TextField phoneField;
    @FXML
    private Button createAccountButton;

    private static Account ACCOUNT_CONNECTED = new Account();

    private void handleButtonAction(ActionEvent event) {
        System.out.println("you clicked me");
        label.setText("Hello World!");
    }
    public void initialize(URL url, ResourceBundle rb){

    }
    @FXML
    private void handleLogin() {
        error.setVisible(true);
    }

    @FXML
    private void createAccount() {
        String profil = profilField.getText();
        String name = nameField.getText();
        String surname = surnameField.getText();
        String pseudo = pseudoField.getText();
        String email = emailField1.getText();
        String password = passwordField1.getText();
        String phone = phoneField.getText();

        String errorv = Validations.validatecreateAccount(profil, name, pseudo, surname, email, password, phone);
        if (errorv != null) {
            // Afficher l'erreur à l'utilisateur
            error.setText(errorv);
            System.out.println("Erreur : " + error);
        } else {

            String[] columns = {"profil", "name", "pseudo" ,"surname", "email", "password", "phone"};
            Object[] values = {profil, name, pseudo, surname, email, password, phone};

            repository.AccountRepository.insert("Accounts", columns, values);

        }

    }


    @FXML
    public void goHome() throws IOException {

        // Charger le fichier form.fxml.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/Interface_Accueil.fxml"));
        Parent root = loader.load();

        // Récupérer la fenêtre actuelle
        Stage currentStage = (Stage)gotoHome.getScene().getWindow();
        // Changer la scène de la fenêtre actuelle
        currentStage.setScene(new Scene(root));
        currentStage.show();
    }


    public void openUserTab(javafx.scene.input.MouseEvent mouseEvent) {
        TranslateTransition toLeftTransition = new TranslateTransition(new Duration(500),lblStatus );
        toLeftTransition.setToX(slidingPane.getTranslateX());
        toLeftTransition.play();
        toLeftTransition.setOnFinished(event2 -> {
            lblStatus.setText("User");
        });
        tabPaneLogin.getSelectionModel().select(tabUser);
    }

    public void openProviderTab(javafx.scene.input.MouseEvent mouseEvent) {
        TranslateTransition toRightAnimation = new TranslateTransition(new Duration(500),lblStatus );
        toRightAnimation.setToX(slidingPane.getTranslateX()+(slidingPane.getPrefWidth()-lblStatus.getPrefWidth()));
        toRightAnimation.play();
        toRightAnimation.setOnFinished(event1 -> {
            lblStatus.setText("Provider");
        });
        tabPaneLogin.getSelectionModel().select(tabProvider);
    }

    public void gotoLogin(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaces/form.fxml"));
        Parent root = loader.load();

        // Récupérer la fenêtre actuelle
        Stage currentStage = (Stage)lblLogin.getScene().getWindow();
        // Changer la scène de la fenêtre actuelle
        currentStage.setScene(new Scene(root));
        currentStage.show();
    }
}
