package persistence;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Client;

public class ClientPersistence extends AbstractPersistence<Client, Integer> {

        EntityManager entityManager = null;

        public ClientPersistence() {
                super(Client.class);
                entityManager = super.getEm();
        }

        public Client findClientByCPF(String cpf) {

                try {
                        Query query = entityManager.createQuery("from Client where cpf='" + cpf + "'");

                        Client client = (Client) query.getSingleResult();
                        if (client != null) 
                                return client;

                } catch (Exception e) {
                        System.out.println(e);
                        return null;
                }
                return null;
        }

        public Client findClientByName(String name) {

                try {
                            Query query = entityManager.createQuery("from Client where firstName='" + name + "'");

                        Client client = (Client) query.getSingleResult();
                        if (client != null) 
                                return client;

                } catch (Exception e) {
                        System.out.println(e);
                        return null;
                }
                return null;
        }
}
