package br.com.phoebus.star.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_REPORT")
public class Report extends EntidadeBase<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="ID_TRAIDOR")
	private Rebelde traidor;
	
	@OneToOne
	@JoinColumn(name="ID_ACUSADOR")
	private Rebelde acusador;
	
	public Report(Rebelde acusador, Rebelde traidor) {
		this.acusador = acusador;
		this.traidor = traidor;
		
	}
	
	public Rebelde getTraidor() {
		return traidor;
	}

	public void setTraidor(Rebelde traidor) {
		this.traidor = traidor;
	}

	public Rebelde getAcusador() {
		return acusador;
	}

	public void setAcusador(Rebelde acusador) {
		this.acusador = acusador;
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
