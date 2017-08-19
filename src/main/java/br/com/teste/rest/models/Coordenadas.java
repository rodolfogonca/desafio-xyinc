package br.com.teste.rest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author Rodolfo Rosendo
 *
 */
@Entity
@Table
@JsonInclude(Include.ALWAYS)
public class Coordenadas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3146759954387570326L;
	/**
	 * 
	 */
	private Integer id;
	private String nome;
	private Integer cordenadaX;
	private Integer cordenadaY;

	public Coordenadas() {
		//
	}

	public Coordenadas(Integer id, String nome, Integer cordenadaX, Integer cordenadaY) {
		this.id = id;
		this.nome = nome;
		this.cordenadaX = cordenadaX;
		this.cordenadaY = cordenadaY;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull(message="Campo nome da cordenada deve ser informado.")
	@Column(name = "NOME")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotNull(message="Valor para cordenada X deve ser informado.")
	@Column(name = "CORDENADA_X")
	public Integer getCordenadaX() {
		return cordenadaX;
	}

	public void setCordenadaX(Integer cordenadaX) {
		this.cordenadaX = cordenadaX;
	}
	
	@NotNull(message="Valor para cordenada Y deve ser informado.")
	@Column(name = "CORDENADA_Y")
	public Integer getCordenadaY() {
		return cordenadaY;
	}

	public void setCordenadaY(Integer cordenadaY) {
		this.cordenadaY = cordenadaY;
	}

}
