package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Client;

public class DeleteClientController implements Initializable {

        Facade facade = Facade.getInstancia();

        @FXML
        private TextField cpfDeleteForm;

        public static MainController mainController;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        public void deleteForm(ActionEvent event) {
                if (cpfDeleteForm.getText().length() > 0) {
                        Client client = verifyCPF(cpfDeleteForm.getText());

                        if (client == null) {
                                sendAlert("Cliente não encontrado!", "error");

                        } else {
                                if (client.getPlace()!= null) {
                                        sendAlert("O cliente está ocupando um acento!\nPor favor desocupe a poltrona antes", "error");

                                } else {
                                        Alert sendAlert = new Alert(Alert.AlertType.CONFIRMATION);
                                        sendAlert.setTitle("Confirmação");
                                        sendAlert.setContentText("Deseja excluir o cliente: "
                                                + "\nNome: " + client.getFirstName()+ " " + client.getLastName()
                                                + "\nCPF: " + client.getCpf());

                                        Optional<ButtonType> result = sendAlert.showAndWait();

                                        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                                                facade.removeClient(client);
                                                sendAlert("Cliente excluído com sucesso!", "success");
                                                clear();
                                        }
                                }
                        }
                } else 
                        sendAlert("Insira um CPF válido!", "error");
        }

        @FXML
        public void clear() {
                mainController.paneLow.getChildren().clear();
                mainController.paneLow.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        public Client verifyCPF(String cpf) {
                Client client = facade.findClientByCPF(cpf);                    //Verificar se o CPF existente no banco
                return client;
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                // TODO
        }

}
