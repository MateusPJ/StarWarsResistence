package br.com.phoebus.star.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * Classe que representa um Recurso no sistema.
 * 
 * @author Mateus P Jorge
 *
 */
@Entity
@Table(name="TB_RECURSO")
public class Recurso extends EntidadeBase<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	@JsonBackReference
	private Long id;
	
	@Column(name= "NM_NOME_DO_RECURSO", nullable= false)
	private String nome;
	
	@Column(name= "NR_PONTOS_DO_RECURSO", nullable= false)
	private int pontos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	
}
