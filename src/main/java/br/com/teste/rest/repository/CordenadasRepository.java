package br.com.teste.rest.repository;

import javax.enterprise.context.RequestScoped;

import br.com.teste.rest.base.Repository;
import br.com.teste.rest.models.Coordenadas;

/**
 * 
 * @author Rodolfo Goncalves
 *
 */
@RequestScoped
public class CordenadasRepository extends Repository<Coordenadas, Integer> {

	public CordenadasRepository() {
	}
}
