package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Client {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idClient;

        @Column
        private String firstName;

        @Column
        private String lastName;

        @Column
        private String phone;

        @Column
        private String cpf;

        @OneToOne
        private Place place;

        public Client(String firstName, String lastName, String phone, String cpf) {
                this.firstName = firstName;
                this.lastName = lastName;
                this.phone = phone;
                this.cpf = cpf;
        }

        public int getIdClient() {
                return idClient;
        }

        public void setIdClient(int idClient) {
                this.idClient = idClient;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public Place getPlace() {
                return place;
        }

        public void setPlace(Place place) {
                this.place = place;
        }

}
