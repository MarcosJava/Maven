package crudPerson.model;

public class Telefone {

	private String noTelefone;
	
	
	public Telefone() {
		// TODO Auto-generated constructor stub
	}


	public String getNoTelefone() {
		return noTelefone;
	}


	public void setNoTelefone(String noTelefone) {
		this.noTelefone = noTelefone;
	}


	@Override
	public String toString() {
		return "Telefone [noTelefone=" + noTelefone + "]";
	}
	
	public static void main(String[] args) {
		
		Telefone tel = new Telefone();
		
		tel.setNoTelefone("2485");
		
		System.out.println(tel);
		
	}
	
}
