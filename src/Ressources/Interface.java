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
	
	public String toString() {
		
		String result = "";
		
		result += "Commutateurs : \n";
		
		for(int i = 0; i < listC.size(); ++i) {
			
			result += listC.get(i).toString();
			result += "\n";
		}
		
		result += "Arteres : \n";
		
		for(int i = 0; i < listA.size(); ++i) {
			
			result += listA.get(i).toString();
			result += "\n";
		}
		
		return result;
	}
}