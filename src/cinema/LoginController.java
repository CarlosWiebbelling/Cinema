package cinema;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable {

        @FXML
        private Pane centerPaneLogin;

        private FXMLLoader fxmlloader;

        public static MainController mainController;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        public void login(ActionEvent event) {
                mainController.blockMenu.setDisable(true);
                load("Room.fxml");
        }

        public void load(String screen) {

                try {
                        centerPaneLogin.setDisable(false);
                        fxmlloader = new FXMLLoader(getClass().getResource(screen));
                        centerPaneLogin.getChildren().clear();
                        fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
                        centerPaneLogin.getChildren().add(fxmlloader.load());

                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                centerPaneLogin.setDisable(true);
        }
}
