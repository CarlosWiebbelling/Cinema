package cinema;

import static alert.AlertMSG.sendAlert;
import cinema.MainController;
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
import model.Place;
import model.Client;

public class DeletePlaceController implements Initializable {

        @FXML
        private TextField deletePlace;

        Facade facade = Facade.getInstancia();

        public static MainController mainController;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        void deleteForm(ActionEvent event) {

                if (deletePlace.getText().length() > 0) {
                        Place place = verify(deletePlace.getText());

                        if (place == null)
                                sendAlert("O assento não está em uso!", "error");
                        
                        else {
                                Alert sendAlert = new Alert(Alert.AlertType.CONFIRMATION);
                                sendAlert.setTitle("Confirmação");
                                sendAlert.setContentText("Deseja desalocar a poltrona: " + place.getIdPlace());

                                Optional<ButtonType> result = sendAlert.showAndWait();

                                if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
                                       
                                        Client client = place.getClient();
                                        client.setPlace(null);
                                        
                                        facade.updateClient(client);
                                        facade.deletePlace(place);
                                        
                                        sendAlert("Acento desalocado!", "success");
                                        clear();
                                }
                        }
                } else 
                        sendAlert("Insira uma poltrona válida!", "error");
        }

        @FXML
        public void clear() {
                mainController.paneLow.getChildren().clear();
                mainController.paneLow.setDisable(true);
                mainController.centerPane.setDisable(false);
                mainController.load("Room.fxml");
        }

        public Place verify(String number) {
                Place pl = facade.findPlaceById(Integer.parseInt(number));                    //Verificar se o CPF existente no banco
                return pl;
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                // TODO
        }

}
