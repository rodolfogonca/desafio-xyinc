package br.com.teste.rest.repository;

import javax.enterprise.context.RequestScoped;

import br.com.teste.rest.base.Repository;
import br.com.teste.rest.models.Cordenadas;

/**
 * 
 * @author Rodolfo Goncalves
 *
 */
@RequestScoped
public class CordenadasRepository extends Repository<Cordenadas, Integer> {

	public CordenadasRepository() {
	}
}
