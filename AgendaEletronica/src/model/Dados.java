package model;

public class Dados {
	
	private String numeroTelefone;

	public Dados(){
	}
	
	public Dados(String numeroTelefone){
		this.numeroTelefone = numeroTelefone;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	@Override
	public String toString() {
		return numeroTelefone;
	}
	
	
}
