package controller;

import java.util.List;
import model.Client;
import persistence.ClientPersistence;

public class ControllerClient {

        private ClientPersistence psClient;

        public ControllerClient(ClientPersistence psClient) {
                this.psClient = psClient;
        }

        public void save(Client c) {                                             //C
                psClient.save(c);
        }

        public Client read(int id) {                                               //R
                return psClient.findById(id);
        }

        public void update(Client c) {                                         //U
                psClient.update(c);
        }

        public void delete(Client c) {                                           //D
                psClient.delete(c);
        }

        public List<Client> readAll() {
                return psClient.listAllEntity(Client.class);
        }

        public Client findClienteByCPF(String cpf) {
                return psClient.findClientByCPF(cpf);
        }

        public Client findClientByName(String name) {
            return psClient.findClientByName(name);
        }
}
