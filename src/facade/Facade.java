package facade;

import controller.ControllerPlace;
import controller.ControllerClient;
import java.util.List;
import model.Place;
import model.Client;
import persistence.PlacePersistence;
import persistence.ClientPersistence;

public class Facade {

        private static Facade facade;

        private ControllerPlace ctrlPlace;
        private ControllerClient ctrlClient;

        private Facade() {
                ctrlClient = new ControllerClient(new ClientPersistence());
                ctrlPlace = new ControllerPlace(new PlacePersistence());
        }

        public static Facade getInstancia() {
                if (facade == null) 
                        facade = new Facade();
                return facade;
        }

        //Cliente
        public void saveClient(Client c) { // public void save(Client c) throws PassageiroJaExistente {
                ctrlClient.save(c);
        }

        public void updateClient(Client c) {
                ctrlClient.update(c);
        }

        public Client findClientById(int id) {
                return ctrlClient.read(id);
        }

        public List<Client> listAllClient() {
                return ctrlClient.readAll();
        }

        public void removeClient(Client c) {
                ctrlClient.delete(c);
        }

        public Client findClientByCPF(String cpf) {
                return ctrlClient.findClienteByCPF(cpf);
        }

        public Client findClientByName(String name) {
            return ctrlClient.findClientByName(name);
        }
        
        //Place
        public void savePlace(Place a) {
                ctrlPlace.save(a);
        }

        public void updatePlace(Place a) {
                ctrlPlace.update(a);
        }

        public void deletePlace(Place a) {
                ctrlPlace.delete(a);
        }

        public Place findPlaceById(int id) {
                return ctrlPlace.read(id);
        }

        public List<Place> listAllPlaces() {
                return ctrlPlace.readAll();
        }

}
