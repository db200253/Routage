package Ressources;

public class Machine {
	
	private String nomMachine;
	
	public Machine(String nomMachine) {
		
		this.nomMachine = nomMachine;
	}

	public String getNomMachine() {
		
		return nomMachine;
	}

	public void setNomMachine(String nomMachine) {
		
		this.nomMachine = nomMachine;
	}
	
	public String toString() {
		
		return nomMachine;
	}
}