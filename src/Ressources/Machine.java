package Ressources;

public class Machine {
	
	private String nomMachine;
	private Commutateur comm;
	
	public Machine(String nomMachine, Commutateur comm) {
		
		this.nomMachine = nomMachine;
		this.comm = comm;
	}

	public Commutateur getComm() {
		return comm;
	}

	public void setComm(Commutateur comm) {
		this.comm = comm;
	}

	public String getNomMachine() {
		
		return nomMachine;
	}

	public void setNomMachine(String nomMachine) {
		
		this.nomMachine = nomMachine;
	}
}