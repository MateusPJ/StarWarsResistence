package br.com.phoebus.star.entidades;

import java.io.Serializable;

/**
 * 
 * Classe abstrata que serve de base para as outras classes.
 * 
 * @author Mateus P Jorge
 *
 * @param <ID> - Entidade generica que servirá de base para as outras através do
 *               serializable.
 */
public abstract class EntidadeBase<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 1L;

	abstract ID getId();

	abstract void setId(ID id);
}