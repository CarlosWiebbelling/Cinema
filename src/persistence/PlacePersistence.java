package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import model.Place;

public class PlacePersistence extends AbstractPersistence<Place, Integer> {

        EntityManager entityManager = null;

        public PlacePersistence() {
                super(Place.class);
                entityManager = super.getEm();
        }
}
