package persistence;

import java.io.Serializable;
import java.util.List;

public interface IPersistenceHibernate<T, ID extends Serializable> {

        public void save(T entity);

        public void update(T entity);

        public void delete(T entity);

        public T findById(ID id);

        public List<T> listAllEntity(Class<T> entity);

        public List<T> listAllEntityOrderBy(final Class<T> entity, final String fieldName);

}
