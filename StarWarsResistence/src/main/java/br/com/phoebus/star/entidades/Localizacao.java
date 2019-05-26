package br.com.phoebus.star.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_LOCALIZACAO")
public class Localizacao extends EntidadeBase<Long> {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "NM_DA_GALAXIA", nullable= false)
	private String galaxia;
	
	@Column(name= "DS_LATITUDE", nullable= false)
	private String latitude;
	
	@Column(name= "DS_LOGITUDE", nullable= false)
	private String longitude;
		
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getGalaxia() {
		return galaxia;
	}

	public void setGalaxia(String galaxia) {
		this.galaxia = galaxia;
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
