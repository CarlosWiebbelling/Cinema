package cinema;

import cinema.MainController;
import facade.Facade;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Client;

public class FindAllClientController implements Initializable {

        @FXML
        private TableView<Client> tableViewAllClient;

        @FXML
        private TableColumn<Client, String> columnFirstName;

        @FXML
        private TableColumn<Client, String> columnLastName;

        @FXML
        private TableColumn<Client, String> columnPhone;

        @FXML
        private TableColumn<Client, String> columnCPF;

        Facade facade = Facade.getInstancia();

        private Client clientEdit = null;

        public static MainController mainController;

        public void setMainController(MainController idk) {
                mainController = idk;
        }

        @FXML
        void cancel(ActionEvent event) {
                clear();
        }

        public void clear() {
                mainController.paneMedium.getChildren().clear();
                mainController.paneMedium.setDisable(true);
                mainController.centerPane.setDisable(false);
        }

        @Override
        public void initialize(URL url, ResourceBundle rb) {
                try {
                        columnFirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("firstName"));
                        columnLastName.setCellValueFactory(new PropertyValueFactory<Client, String>("lastName"));
                        columnPhone.setCellValueFactory(new PropertyValueFactory<Client, String>("phone"));
                        columnCPF.setCellValueFactory(new PropertyValueFactory<Client, String>("cpf"));
                        loadTable();

                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void loadTable() {
                List<Client> list = facade.listAllClient();
                ObservableList<Client> obsList = FXCollections.observableArrayList();

                for (Client client : list) {
                        obsList.add(client);
                }

                tableViewAllClient.setItems(obsList);
        }

}
