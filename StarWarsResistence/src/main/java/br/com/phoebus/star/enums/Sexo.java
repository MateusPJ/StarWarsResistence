package br.com.phoebus.star.enums;

public enum Sexo {

	M("M", "Masculino"), F("F", "Feminino");

	private Sexo(String cod, String sexo) {
		this.cod = cod;
		this.sexo = sexo;
	}

	private String cod;
	private String sexo;

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public Sexo getSexoPorCodigo(int cod){
		Sexo retorno = null;
		for (Sexo valor : Sexo.values()) {
			if(valor.getCod().equals(cod)) {
				return valor;
			}
		}
		return null;
	}
}
