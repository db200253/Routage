package Ressources;

import java.util.ArrayList;
import java.util.List;

public class Interface {
	
	private List<Commutateur> listC;
	private List<Artere> listA;
	
	public Interface() {
		
		listC = new ArrayList<>();
		listA = new ArrayList<>();
	}
	
	public Interface(List<Commutateur> listC, List<Artere> listA) {
		
		this.listC = listC;
		this.listA = listA;
	}

	public List<Commutateur> getListC() {
		
		return listC;
	}

	public void setListC(List<Commutateur> listC) {
		
		this.listC = listC;
	}

	public List<Artere> getListA() {
		
		return listA;
	}

	public void setListA(List<Artere> listA) {
		
		this.listA = listA;
	}
}