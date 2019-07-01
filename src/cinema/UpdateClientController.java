package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Client;

public class UpdateClientController implements Initializable {

        Facade facade = Facade.getInstancia();
        public static MainController mainController;

        //Form
        @FXML
        private TextField firstNameForm;

        @FXML
        private TextField lastNameForm;

        @FXML
        private TextField phoneForm;

        @FXML
        private TextField cpfForm;

        @FXML
        private ToggleGroup methodGroup;

        @FXML
        private TextField methodUpdate;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        void clearForm(ActionEvent event) {
                firstNameForm.setText("");
                lastNameForm.setText("");
                phoneForm.setText("");
                cpfForm.setText("");
                methodUpdate.setText("");
        }

        public void clear() {
                mainController.paneMedium.getChildren().clear();
                mainController.paneMedium.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        @FXML
        void changeMethod(ActionEvent event) {
                
                String method = new String(((RadioButton) event.getSource()).getText());
                
                if (method.equals("CPF")) 
                        methodUpdate.setPromptText("CPF");
                
                else if (method.equals("Nome"))                                                                 //"Nome" em português pois é um elemento da interface e esta está neste idioma;
                        methodUpdate.setPromptText("Nome");
        }

        @FXML
        void sendForm(ActionEvent event) {

                String radio = (methodGroup.getSelectedToggle()).toString();

                if (verifyData()) {
                        
                        Client client = null;

                        if (radio.contains("CPF"))
                                client = facade.findClientByCPF(methodUpdate.getText());
                        
                        else if (radio.contains("Nome"))
                                client = facade.findClientByName(methodUpdate.getText());            //****
                        
                        if (client != null) {
                                
                                System.out.println(methodUpdate.getText());
                            
                                client.setFirstName(firstNameForm.getText());
                                client.setLastName(lastNameForm.getText());
                                client.setPhone(phoneForm.getText());
                                client.setCpf(cpfForm.getText());

                                try {
                                        facade.updateClient(client);
                                        sendAlert("Cliente atualizado com sucesso!", "success");
                                        clear();
                                        
                                } catch (Error e) {
                                        System.out.println(e);
                                }
                        } else {
                                sendAlert("Cliente não encontrado!", "error");
                        }
                }
        }

        public boolean verifyData() {
                
                if ((firstNameForm.getText().length() == 0) || (lastNameForm.getText().length() == 0) || (phoneForm.getText().length() == 0) || (cpfForm.getText().length() == 0) || (methodUpdate.getText().length() == 0)) {
                        sendAlert("Preencha todos os campos", "error");
                        return false;
                } 
                return true;  
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {

        }

}
