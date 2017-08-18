package br.com.teste.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.teste.rest.bizz.CordenadasBizz;
import br.com.teste.rest.models.Cordenadas;

@Path("/service")
public class Servicos {

	@Inject
	private CordenadasBizz bizz;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cargaBaseDados/")
	public List<Cordenadas> teste() {
		try {
			return bizz.cargaDadosIniciais();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao persistir dados da carga inicial.", e);
		}
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cordenadas> getAll() {
		try {
			return bizz.getAll();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao recuperar dados cordendas.", e);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Cordenadas saveCordendas(Cordenadas cordenadas) {
		try {
			return bizz.save(cordenadas);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao recuperar dados cordendas.", e);
		}
	}

	@GET
	@Path("/pois")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cordenadas> getPois(@QueryParam("cordenadaX") Integer cordenadasX,
			@QueryParam("cordenadaY") Integer cordenadaY, @QueryParam("raio") Integer raio) {
		return bizz.getPoisProximidade(cordenadasX, cordenadaY, raio);
	}
}
