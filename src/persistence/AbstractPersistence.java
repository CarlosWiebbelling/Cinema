package persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import util.EntityManagerUtil;

public abstract class AbstractPersistence<T, ID extends Serializable> implements IPersistenceHibernate<T, ID> {
        
        private final EntityManager em;
        private Class<T> persistentClass;

        public AbstractPersistence(Class<T> pPersistentClass) {
                this.em = EntityManagerUtil.getEntityManager();
                this.persistentClass = pPersistentClass;
        }
        
        public EntityManager getEm() {
                return em;
        }
        
        @Override
        public void save(T entity) {
                try {
                        this.em.getTransaction().begin();
                        this.em.persist(entity);
                        this.em.getTransaction().commit();
                } catch (Exception e) {
                        e.printStackTrace();
                        this.em.getTransaction().rollback();
                } 
        }
        
        @Override
        public void update(T entity) {
                try{
                        this.em.getTransaction().begin();
                        this.em.merge(entity);
                        this.em.getTransaction().commit();
                }catch (Exception e) {
                        this.em.getTransaction().rollback();
                } 
        }
        
        @Override
        public void delete(T entity) {
                try {
                        this.em.getTransaction().begin();
                        this.em.remove(em.merge(entity));
                        this.em.getTransaction().commit();
                } catch (Exception e){
                        e.printStackTrace();
                        this.em.getTransaction().rollback();
                } 
        }
        
        @Override
        public T findById(ID id) {
                T fEntity = null;
                try {
                        fEntity = em.find(persistentClass, id);
                } catch (NoResultException e) {
                        return null;
                } 	
                return fEntity;
        }       
        
        @Override
        public List<T> listAllEntity(Class<T> entity) {
                List<T> objects = null;
                try {
                        Query query = em.createQuery("from " + entity.getName());
                        objects = query.getResultList();
                } catch (HibernateException e) {
                        e.printStackTrace();
                }
                return objects;
        }

        @Override
        public List<T> listAllEntityOrderBy(Class<T> entity, String fieldName) {
                List<T> objects = null;
                try {
                        Query query = em.createQuery("from " + entity.getName() + " order by " + fieldName);
                        objects = query.getResultList();
                } catch (HibernateException e) {
                        e.printStackTrace();
                } 
                return objects;
        }

}
