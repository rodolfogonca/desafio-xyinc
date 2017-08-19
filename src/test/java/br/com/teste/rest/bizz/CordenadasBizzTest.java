package br.com.teste.rest.bizz;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import br.com.teste.rest.constantes.Constantes;
import br.com.teste.rest.models.Coordenadas;

/**
 * 
 * @author Rodolfo Gonçalves
 *
 */
public class CordenadasBizzTest {

	private CordenadasBizz bizz;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void instanciaClasses() {
		bizz = new CordenadasBizz();
	}

	@Test
	public void saveCordenadasObjectNull() {
		Coordenadas cordenadas = null;

		try {
			cordenadas = bizz.save(null);
		} catch (Exception e) {
			assertTrue(e.getMessage().equals(Constantes.NENHUM_PARAMETRO_FOI_INFORMADO));
		}

		assertNull(cordenadas);
	}

	@Test
	public void saveCordenadasCordenadasComValoresNulos() {
		try{
			bizz.getPoisProximidade(null, null, 0);
		}catch(Exception e){
			assertTrue(e.getMessage().equals(Constantes.VALORES_CORDENADAS_NULOS));
		}
	}
	
	@Test
	public void saveCordenadasCordenadasMenoresQueZero() {
		try{
			bizz.getPoisProximidade(-1, -1, 0);
		}catch(Exception e){
			assertTrue(e.getMessage().equals(Constantes.VALORES_CORDENADAS_MENORES_QUE_ZERO));
		}
	}

	@Test
	public void getPoisProximidadeParametrosNulos() {

	}
}
