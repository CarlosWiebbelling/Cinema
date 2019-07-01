package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Place {

        @Id
        private int idPlace;                                                                  //Número do assento

        @OneToOne(fetch = FetchType.LAZY)
        private Client client;                                                                //Ocupante do assento

        public Place(int idPlace, Client client) {
                this.idPlace = idPlace;
                this.client = client;
        }

        public int getIdPlace() {
                return idPlace;
        }

        public void setIdPlace(int idPlace) {
                this.idPlace = idPlace;
        }

        public Client getClient() {
                return client;
        }

        public void setClient(Client client) {
                this.client = client;
        }

}
