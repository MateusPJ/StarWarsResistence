package br.com.phoebus.star.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.phoebus.star.enums.Sexo;

@Entity
@Table(name="TB_REBELDE")
public class Rebelde extends EntidadeBase<Long> {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "NM_REBELDE", nullable= false)
	private String nome;
	
	@Column(name= "NR_IDADE", nullable = false)
	private int idade;

	@Enumerated(EnumType.STRING)
	@Column(name = "NM_SEXO", nullable = false)
	private Sexo sexo;
	
	@OneToOne
	@JoinColumn(name="ID_LOCALIZACAO")	
	private Localizacao localizacao;
	
	@OneToMany(mappedBy = "rebelde")
	private List<InventarioRebelde> inventario;
	
	public List<InventarioRebelde> getInventario() {
		return inventario;
	}

	public void setInventario(List<InventarioRebelde> inventario) {
		this.inventario = inventario;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void setId(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
