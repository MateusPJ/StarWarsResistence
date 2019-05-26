package br.com.phoebus.star.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_INVENTARIO")
public class InventarioRebelde extends EntidadeBase<Long> {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ID_REBELDE")
	private Rebelde rebelde;
	
	@OneToOne
	@JoinColumn(name="ID_RECURSO")
	private Recurso recurso;
	
	@Column(name= "NR_QUANTIDADE_DE_RECURSOS", nullable= false)
	private int quantidade;
	
	public Rebelde getRebelde() {
		return rebelde;
	}

	public void setRebelde(Rebelde rebelde) {
		this.rebelde = rebelde;
	}

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	Long getId() {
		return id;
	}

	@Override
	void setId(Long id) {
		this.id = id;
	}
	
}
