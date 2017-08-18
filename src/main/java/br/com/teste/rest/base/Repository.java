package br.com.teste.rest.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.com.teste.rest.interfaces.IRepository;

/**
 * 
 * @author Rodofo Gonçalves
 *
 * @param <T>
 * @param <ID>
 */
public abstract class Repository<T extends Serializable, ID extends Serializable> implements IRepository<T, ID> {

	@PersistenceContext(unitName = "DB_INC")
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz, Integer page, Integer pageSize) {
		Session session = (Session) manager.getDelegate();
		Criteria criteria = session.createCriteria(clazz);

		if (pageSize != null && page != null) {
			criteria.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		}

		return criteria.list();
	}

	public T findById(Class<T> clazz, ID id) {
		return manager.find(clazz, id);
	}

	public void delete(T entity) {
		manager.remove(entity);

	}

	public void update(T entity) {
		Session session = (Session) manager.getDelegate();
		session.update(entity);
	}

	public T save(T entity) {
		manager.persist(entity);
		return entity;
	}

	public void saveOrUpdate(T entity) {
		manager.merge(entity);

	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T clazz, Integer page, Integer pageSize) {
		Session session = (Session) manager.getDelegate();
		Example exemple = Example.create(clazz).excludeNone();
		Criteria criteria = session.createCriteria(clazz.getClass()).add(exemple);

		if (pageSize != null && page != null) {
			criteria.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize);
		}

		return criteria.list();
	}

}
