package controller;

import java.util.List;
import model.Place;
import persistence.PlacePersistence;

public class ControllerPlace {

        private PlacePersistence psPlace;

        public ControllerPlace(PlacePersistence psPlace) {
                this.psPlace = psPlace;
        }

        public void save(Place c) {                                             //C
                psPlace.save(c);
        }

        public Place read(int id) {                                               //R
                return psPlace.findById(id);
        }

        public void update(Place c) {                                         //U
                psPlace.update(c);
        }

        public void delete(Place c) {                                           //D
                psPlace.delete(c);
        }

        public List<Place> readAll() {
                return psPlace.listAllEntity(Place.class);
        }
}
