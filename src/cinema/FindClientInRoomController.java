package cinema;

import facade.Facade;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Place;
import model.Client;
import model.Occupant;

public class FindClientInRoomController implements Initializable {

        Facade facade = Facade.getInstancia();

        public static MainController mainController;

        @FXML
        private TableView<Occupant> tableViewAllOccupant;

        @FXML
        private TableColumn<Occupant, Integer> columnPlace;

        @FXML
        private TableColumn<Occupant, String> columnFirstName;

        @FXML
        private TableColumn<Occupant, String> columnLastName;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        public void clear() {
                mainController.paneMedium.getChildren().clear();
                mainController.paneMedium.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                try {
                        columnPlace.setCellValueFactory(new PropertyValueFactory<Occupant, Integer>("idPlace"));
                        columnFirstName.setCellValueFactory(new PropertyValueFactory<Occupant, String>("firstName"));
                        columnLastName.setCellValueFactory(new PropertyValueFactory<Occupant, String>("lastName"));
                        loadTable();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void loadTable() {
                List<Place> list = facade.listAllPlaces();

                ObservableList<Occupant> obsListA = FXCollections.observableArrayList();
                
                Occupant occp;
                
                for (int i = 0; i < list.size(); i++) {
                        occp = new Occupant(list.get(i).getIdPlace(), list.get(i).getClient().getFirstName(), list.get(i).getClient().getLastName());
                        obsListA.add(occp);
                };

                tableViewAllOccupant.setItems(obsListA);
        }
}
