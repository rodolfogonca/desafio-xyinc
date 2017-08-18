package br.com.teste.rest.bizz;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.teste.rest.models.Cordenadas;
import br.com.teste.rest.repository.CordenadasRepository;

@RequestScoped
public class CordenadasBizz {

	@Inject
	private CordenadasRepository repository;

	/**
	 * 
	 * @return
	 */
	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<Cordenadas> getAll() {
		return repository.findAll(Cordenadas.class, null, null);
	}

	@Transactional(Transactional.TxType.NOT_SUPPORTED)
	public List<Cordenadas> getPoisProximidade(Integer cordenadaX, Integer cordenadaY, Integer raio) {
		validaCordenadas(cordenadaX, cordenadaY);
		List<Cordenadas> cordendasList = this.getAll();

		if (!cordendasList.isEmpty()) {
			return cordendasList.stream()
					.filter(cordenadas -> pertenceReferencia(cordenadaX, cordenadaY, raio, cordenadas))
					.collect(Collectors.toList());
		}

		return Collections.emptyList();
	}

	/**
	 * 
	 * @param cordenadaX
	 * @param cordenadaY
	 */
	private void validaCordenadas(Integer cordenadaX, Integer cordenadaY) {
		if (cordenadaX == null && cordenadaY == null) {
			throw new IllegalArgumentException("Valores de cordendas devem ser informados.");
		} else if (cordenadaX < 0 || cordenadaY < 0) {
			throw new IllegalArgumentException("Valores de cordendas n�o podem ser menores que 0.");
		}
	}

	/**
	 * Calcula a distancia entre os pontos verificando se está no raio de
	 * distancia informado
	 * 
	 * @param cordenadaX
	 * @param cordenadaY
	 * @param raio
	 * @param cordenadas
	 * @return
	 */
	public boolean pertenceReferencia(Integer cordenadaX, Integer cordenadaY, Integer raio, Cordenadas cordenadas) {
		return Math.sqrt(Math.pow((cordenadaX - cordenadas.getCordenadaX()), 2)
				+ Math.pow((cordenadaY - cordenadas.getCordenadaY()), 2)) <= raio;
	}

	/**
	 * 
	 * @param cordenadas
	 * @return
	 */
	@Transactional
	public Cordenadas save(Cordenadas cordenadas) {
		if (cordenadas == null) {
			throw new IllegalArgumentException("Nenhum parâmetro foi informado");
		}

		return repository.save(cordenadas);
	}

	/**
	 * Carga inicial
	 * 
	 * @return
	 */
	@Transactional
	public List<Cordenadas> cargaDadosIniciais() {
		repository.save(new Cordenadas(1, "Lanchonete", 27, 12));
		repository.save(new Cordenadas(null, "Posto", 31, 18));
		repository.save(new Cordenadas(null, "Joalheria", 15, 12));
		repository.save(new Cordenadas(null, "Floricultura", 19, 21));
		repository.save(new Cordenadas(null, "Pub", 12, 8));
		repository.save(new Cordenadas(null, "Supermercado", 23, 6));
		repository.save(new Cordenadas(null, "Churrascaria", 28, 2));

		return repository.findAll(Cordenadas.class, null, null);
	}
}
