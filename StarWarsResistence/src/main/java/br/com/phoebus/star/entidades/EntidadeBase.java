package br.com.phoebus.star.entidades;

import java.io.Serializable;

/**
 * 
 * Classe abstrata que vai servir que serve de base para as outras classes.
 * 
 * @author Mateus P Jorge
 *
 * @param <ID> - 
 */
public abstract class EntidadeBase <ID extends Serializable> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	abstract ID getId();
	
	abstract void setId(ID id);
}