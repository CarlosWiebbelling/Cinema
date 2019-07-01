package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Client;

public class FindClientController implements Initializable {

        Facade facade = Facade.getInstancia();

        @FXML
        private TextField cpfForm;

        public static MainController mainController;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        public void sendForm(ActionEvent event) {
                if (cpfForm.getText().length() > 0) {
                        Client client = verifyCPF(cpfForm.getText());

                        if (client == null) {
                                sendAlert("Cliente não encontrado!", "error");
                        } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Cliente encontrado!");
                                alert.setHeaderText("Cliente encontrado!");
                                alert.setContentText("Nome: " + client.getFirstName()+ " " + client.getLastName()
                                        + "\nTelefone: " + client.getPhone()
                                        + "\nCPF: " + client.getCpf());
                                alert.showAndWait();
                                clear();
                        }
                } else 
                        sendAlert("Insira um CPF válido!", "error");
        }

        public Client verifyCPF(String cpf) {
                Client client = facade.findClientByCPF(cpf);                    //Verificar se o CPF existente no banco
                return client;
        }

        @FXML
        public void clear() {
                mainController.paneLow.getChildren().clear();
                mainController.paneLow.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                // TODO
        }

}
