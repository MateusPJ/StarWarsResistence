package br.com.phoebus.star.entidades.util;

import br.com.phoebus.star.entidades.Recurso;

public class DtoTroca {
	private Long idRebelde;
	private Recurso recurso;
	private int qtde;
	
	public Long getIdRebelde() {
		return idRebelde;
	}
	public void setIdRebelde(Long idRebelde) {
		this.idRebelde = idRebelde;
	}
	public Recurso getRecurso() {
		return recurso;
	}
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
}
