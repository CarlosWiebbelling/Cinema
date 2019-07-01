package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Place;
import model.Client;

public class RoomController implements Initializable {

        private Facade facade = Facade.getInstancia();

        private int numPlace;

        public static MainController mainController;

        @FXML
        private Pane centerPaneSala;

        @FXML
        private VBox f1;

        @FXML
        private VBox f2;

        @FXML
        private VBox f3;

        @FXML
        private VBox f4;

        @FXML
        private VBox f5;

        @FXML
        private VBox f6;

        @FXML
        private VBox f7;

        @FXML
        private VBox f8;

        @FXML
        private VBox f9;

        @FXML
        private VBox f10;

        @FXML
        private VBox f11;

        @FXML
        private VBox f12;

        @FXML
        private VBox f13;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        public void selectPlace(ActionEvent event) {

                numPlace = new Integer(((Button) event.getSource()).getText());

                Place verifyPlace = facade.findPlaceById(numPlace);

                if (verifyPlace == null) {
                        Alert sendAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        sendAlert.setTitle("Confirmar acento");
                        sendAlert.setContentText("Confirmar acento número " + numPlace);

                        Optional<ButtonType> result = sendAlert.showAndWait();

                        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {

                                TextInputDialog dialog = new TextInputDialog("");
                                dialog.setTitle("Identificação");
                                dialog.setHeaderText("Registrar assento " + numPlace);
                                dialog.setContentText("Insira seu CPF:");

                                Optional<String> result2 = dialog.showAndWait();

                                if ((result2.isPresent()) && (!result2.get().isEmpty())) {

                                        Client verifyClient = facade.findClientByCPF(dialog.getResult());

                                        if (verifyClient != null) {
                                                if (verifyClient.getPlace() != null)
                                                        sendAlert("O cliente já está ocupando um acento!", "error");
                                                
                                                else {
                                                        Place newPlace = new Place(numPlace, verifyClient);
                                                        facade.savePlace(newPlace);
                                                        verifyClient.setPlace(newPlace);
                                                        facade.updateClient(verifyClient);

                                                        sendAlert("Acento alocado com sucesso! Bom filme", "success");

                                                        ((Button) event.getSource()).setStyle("-fx-background-color:  #fe3636");
                                                }
                                        } else {
                                                sendAlert("Cliente não encontrado!", "error");
                                        }
                                }
                        }
                } else
                        sendAlert("Acento ocupado!", "error");
        }

        public List getPlaces() {

                List<Place> list = new ArrayList<Place>();
                list = facade.listAllPlaces();
                return list;
        }

        public List<VBox> boxinVBox() {
                List<VBox> vb = new ArrayList<VBox>();
                vb.add(f1);
                vb.add(f2);
                vb.add(f3);
                vb.add(f4);
                vb.add(f5);
                vb.add(f6);
                vb.add(f7);
                vb.add(f8);
                vb.add(f9);
                vb.add(f10);
                vb.add(f11);
                vb.add(f12);
                vb.add(f13);

                return vb;
        }

        public void prepareRoom() {
                List<Place> occuped = getPlaces();
                List<VBox> vb = boxinVBox();
                Insets pdd = new Insets(-1, 0, 0, 0);

                int num;

                for (int y = 0; y < 13; y++) {
                        num = y;
                        for (int i = 0; i < 12; i++) {
                                Button b = new Button();
                                b.setPrefHeight(40.0);
                                b.setPrefWidth(40.0);
                                b.setOnAction(actionEvent -> selectPlace(actionEvent));
                                b.setStyle("-fx-background-color:  #a1ef8b;");
                                b.setText(String.valueOf(num));
                                b.setPadding(pdd);

                                for (Place place : occuped)
                                        if (place.getIdPlace() == num)
                                                b.setStyle("-fx-background-color:  #fe3636;");

                                if ((y == 0) || (y == 1))
                                        b.setRotate(25.0);
                                
                                else if ((y == 11) || (y == 12))
                                        b.setRotate(-25.0);
                                
                                (vb.get(y)).getChildren().add(b);
                                num += 13;
                        }
                        vb.get(y).setSpacing(4.0);
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                centerPaneSala.setDisable(true);
                prepareRoom();
        }
}
