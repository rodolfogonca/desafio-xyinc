package br.com.teste.rest.bizz;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.teste.rest.constantes.Constantes;
import br.com.teste.rest.models.Coordenadas;
import br.com.teste.rest.repository.CordenadasRepository;

/**
 * 
 * @author Rodolfo Goncalves
 *
 */
@RequestScoped
public class CordenadasBizz {

	@Inject
	private CordenadasRepository repository;

	/**
	 * Metodo responsavel por retornar todas as cordenadas cadastradas na base
	 * de dados
	 * 
	 * @return
	 */
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<Coordenadas> getAll() {
		return repository.findAll(Coordenadas.class, null, null);
	}

	/**
	 * Metodo responsavel por retornar todas as cordenadas cadastradas de acordo
	 * com os filtros passados
	 * 
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param raio
	 * @return
	 */
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<Coordenadas> getPoisProximidade(Integer coordenadaX, Integer coordenadaY, Integer raio) {
		validaCordenadas(coordenadaX, coordenadaY);
		List<Coordenadas> cordendasList = this.getAll();

		if (!cordendasList.isEmpty()) {
			return cordendasList.stream()
					.filter(cordenadas -> pertenceReferencia(coordenadaX, coordenadaY, raio, cordenadas))
					.collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	/**
	 * Metodo responsavel por validar se as coordenadas informadas sao validas
	 * 
	 * @param coordenadaX
	 * @param coordenadaY
	 */
	private void validaCordenadas(Integer coordenadaX, Integer coordenadaY) {
		if (coordenadaX == null && coordenadaY == null) {
			throw new IllegalArgumentException(Constantes.VALORES_CORDENADAS_NULOS);
		} else if (coordenadaX < 0 || coordenadaY < 0) {
			throw new IllegalArgumentException(Constantes.VALORES_CORDENADAS_MENORES_QUE_ZERO);
		}
	}

	/**
	 * Calcula a distancia entre os pontos verificando se está no raio de
	 * distancia informado
	 * 
	 * @param coordenadaX
	 * @param coordenadaY
	 * @param raio
	 * @param coordenadas
	 * @return
	 */
	public boolean pertenceReferencia(Integer coordenadaX, Integer coordenadaY, Integer raio, Coordenadas coordenadas) {
		return Math.sqrt(Math.pow((coordenadaX - coordenadas.getCordenadaX()), 2)
				+ Math.pow((coordenadaY - coordenadas.getCordenadaY()), 2)) <= raio;
	}

	/**
	 * Metodo responsavel por persistir a entidade cordenadas
	 * 
	 * @param coordenadas
	 * @return
	 */
	@Transactional
	public Coordenadas save(Coordenadas coordenadas) {
		if (coordenadas == null) {
			throw new IllegalArgumentException(Constantes.NENHUM_PARAMETRO_FOI_INFORMADO);
		}

		return repository.save(coordenadas);
	}

	/**
	 * Metodo responsavel por realizar a carga inicial de todas as cordenadas
	 * mencionadas no desafio
	 * 
	 * @return
	 */
	@Transactional
	public List<Coordenadas> cargaDadosIniciais() {
		repository.save(new Coordenadas(null, "Lanchonete", 27, 12));
		repository.save(new Coordenadas(null, "Posto", 31, 18));
		repository.save(new Coordenadas(null, "Joalheria", 15, 12));
		repository.save(new Coordenadas(null, "Floricultura", 19, 21));
		repository.save(new Coordenadas(null, "Pub", 12, 8));
		repository.save(new Coordenadas(null, "Supermercado", 23, 6));
		repository.save(new Coordenadas(null, "Churrascaria", 28, 2));

		return repository.findAll(Coordenadas.class, null, null);
	}
}
