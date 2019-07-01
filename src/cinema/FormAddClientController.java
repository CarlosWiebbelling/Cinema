package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Client;

public class FormAddClientController implements Initializable {

        private Facade facade = Facade.getInstancia();

        public static MainController mainController;
        
        //Form new Client
        @FXML
        private TextField firstNameForm;

        @FXML
        private TextField lastNameForm;

        @FXML
        private TextField phoneForm;

        @FXML
        private TextField cpfForm;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        void sendForm(ActionEvent event) {
                
                if (verifyData()) {
                        if ((verifyCPF(cpfForm.getText())) == null) {
                                Client client = new Client(firstNameForm.getText(), lastNameForm.getText(), phoneForm.getText(), cpfForm.getText());

                                try {
                                        facade.saveClient(client);
                                        sendAlert("Cliente cadastrado com sucesso!", "success");
                                        clear();
                                } catch (Error e) {
                                        System.out.println(e);
                                }
                        } else
                                sendAlert("CPF já cadastrado!", "error");
                }
        }

        public void clear() {
                mainController.paneMedium.getChildren().clear();
                mainController.paneMedium.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        public Client verifyCPF(String cpf) {
                Client client = facade.findClientByCPF(cpf);
                return client;
        }

        public boolean verifyData() {
                if ((firstNameForm.getText().length() == 0) || (lastNameForm.getText().length() == 0) || (phoneForm.getText().length() == 0) || (cpfForm.getText().length() == 0)) {
                        sendAlert("Preencha todos os campos", "error");
                        return false;
                } else
                        return true;
        }

        @FXML
        public void clearForm() {
                firstNameForm.setText("");
                lastNameForm.setText("");
                phoneForm.setText("");
                cpfForm.setText("");
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }

}
