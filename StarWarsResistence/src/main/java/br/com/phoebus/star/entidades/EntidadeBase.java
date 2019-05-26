package br.com.phoebus.star.entidades;

import java.io.Serializable;

public abstract class EntidadeBase <ID extends Serializable> implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	abstract ID getId();
	
	abstract void setId(ID id);
}