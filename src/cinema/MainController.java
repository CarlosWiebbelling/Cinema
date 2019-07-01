package cinema;

import static alert.AlertMSG.sendAlert;
import facade.Facade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import view.PDFGenerator;

public class MainController implements Initializable {

        Facade facade = Facade.getInstancia();
        FXMLLoader fxmlloader;
        
        @FXML
        private MenuItem Room;

        @FXML
        private MenuItem generateLog;

        @FXML
        private MenuItem newClient;

        @FXML
        private MenuItem deleteClient;

        @FXML
        private MenuItem updateClient;

        @FXML
        private MenuItem findClient;

        @FXML
        private MenuItem findAllClientInRoom;

        @FXML
        private MenuItem findAllClient;

        @FXML
        private MenuItem deletePlace;

        @FXML
        private MenuItem findAllPlace;

        @FXML
        public Pane centerPane;

        @FXML
        public Pane paneMedium;

        @FXML
        public Pane paneLow;
        
        @FXML
        public Pane blockMenu;
        
        @FXML
        void menu(ActionEvent event) {
                if (event.getSource() == newClient) 
                        load("FormAddClient.fxml");
                
                else if (event.getSource() == deleteClient) 
                        load("DeleteClient.fxml");
                
                else if (event.getSource() == updateClient) 
                        load("UpdateClient.fxml");
                
                else if (event.getSource() == findClient) 
                        load("FindClient.fxml");
                
                else if (event.getSource() == Room) 
                        load("Room.fxml");
                
                else if (event.getSource() == findAllClient) 
                        load("FindAllClient.fxml");
                
                else if (event.getSource() == findAllClientInRoom) 
                        load("FindClientInRoom.fxml");
                
                else if (event.getSource() == deletePlace) 
                        load("DeletePlace.fxml");
                
                else if (event.getSource() == findAllPlace) 
                        load("FindClientInRoom.fxml");
                
                else if (event.getSource() == generateLog) {
                        PDFGenerator.PDFgenerator();
                        sendAlert("Registro atual gerado com sucesso!", "success");
                }
        }

        public void close(ActionEvent event) {
                Platform.exit();
        }

        public void load(String screen) {

                try {
                        fxmlloader = new FXMLLoader(getClass().getResource(screen));
                        fxmlloader.setBuilderFactory(new JavaFXBuilderFactory());
                        
                        if (screen == "Login.fxml") {
                                paneMedium.setDisable(true);
                                centerPane.setDisable(false);
                                paneLow.setDisable(true);

                                centerPane.getChildren().clear();
                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();
                                
                                centerPane.getChildren().add(fxmlloader.load());
                                
                                ((LoginController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "FormAddClient.fxml") {
                                centerPane.setDisable(true);
                                paneMedium.setDisable(false);
                                paneLow.setDisable(true);

                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();

                                paneMedium.getChildren().add(fxmlloader.load());
                                
                                ((FormAddClientController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "UpdateClient.fxml") {
                                centerPane.setDisable(true);
                                paneMedium.setDisable(false);
                                paneLow.setDisable(true);

                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();
                                
                                paneMedium.getChildren().add(fxmlloader.load());
                                
                                ((UpdateClientController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "Room.fxml") {
                                paneMedium.setDisable(true);
                                centerPane.setDisable(false);
                                paneLow.setDisable(true);

                                centerPane.getChildren().clear();
                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();

                                centerPane.getChildren().add(fxmlloader.load());

                                ((RoomController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "DeleteClient.fxml") {
                                centerPane.setDisable(true);
                                paneMedium.setDisable(true);
                                paneLow.setDisable(false);

                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();

                                paneLow.getChildren().add(fxmlloader.load());

                                ((DeleteClientController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "FindClient.fxml") {
                                centerPane.setDisable(true);
                                paneMedium.setDisable(true);
                                paneLow.setDisable(false);

                                paneMedium.getChildren().clear();
                                paneLow.getChildren().clear();

                                paneLow.getChildren().add(fxmlloader.load());

                                ((FindClientController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "FindAllClient.fxml") {
                                centerPane.setDisable(true);
                                paneLow.setDisable(true);
                                paneMedium.setDisable(false);

                                paneMedium.getChildren().clear();

                                paneMedium.getChildren().add(fxmlloader.load());

                                ((FindAllClientController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "FindClientInRoom.fxml") {
                                centerPane.setDisable(true);
                                paneLow.setDisable(true);
                                paneMedium.setDisable(false);

                                paneMedium.getChildren().clear();

                                paneMedium.getChildren().add(fxmlloader.load());

                                ((FindClientInRoomController) fxmlloader.getController()).setMainController(this);

                        } else if (screen == "DeletePlace.fxml") {
                                centerPane.setDisable(true);
                                paneMedium.setDisable(true);
                                paneLow.setDisable(false);

                                paneLow.getChildren().clear();
                                
                                paneLow.getChildren().add(fxmlloader.load());

                                ((DeletePlaceController) fxmlloader.getController()).setMainController(this);
                        }
                        
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                centerPane.setDisable(true);
                paneMedium.setDisable(true);
                paneLow.setDisable(true);

                load("Login.fxml");
        }
}
