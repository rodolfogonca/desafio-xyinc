package br.com.teste.rest.bizz;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import br.com.teste.rest.bizz.CordenadasBizz;
import br.com.teste.rest.models.Cordenadas;

/**
 * 
 * @author Rodolfo Gonçalves
 *
 */
public class CordenadasBizzTest {

	@Inject
	CordenadasBizz bizz;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void saveCordenadasObjectNull() {
		Cordenadas cordenadas = null;

		try {
			cordenadas = bizz.save(null);
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().equals("Nenhum parâmetro foi informado"));
		}

		Assert.assertNull(cordenadas);
	}
}
