package br.com.teste.rest.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IRepository<T extends Serializable, ID extends Serializable> {

	/**
	 * @param clazz
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public List<T> findAll(Class<T> clazz, Integer pageSize, Integer page);

	/**
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	public T findById(Class<T> clazz, ID id);

	/**
	 * 
	 * @param entity
	 */
	public void delete(T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public void update(T entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T save(T entity);

	/**
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 
	 * @param clazz
	 * @param pageSize
	 * @param page
	 * @return
	 */
	public List<T> findByExample(T clazz, Integer pageSize, Integer page);
}
