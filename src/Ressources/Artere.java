package Ressources;

public class Artere {
	
	private Commutateur c1, c2;
	
	public Artere(Commutateur c1, Commutateur c2) {
		
		this.c1 = c1;
		this.c2 = c2;
	}

	public Commutateur getC1() {
		
		return c1;
	}

	public void setC1(Commutateur c1) {
		
		this.c1 = c1;
	}

	public Commutateur getC2() {
		
		return c2;
	}

	public void setC2(Commutateur c2) {
		
		this.c2 = c2;
	}
}