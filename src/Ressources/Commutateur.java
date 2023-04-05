package Ressources;

import java.util.ArrayList;
import java.util.List;

public class Commutateur {
	
	private String nomCommutateur;
	private List<Machine> list;
	
	public Commutateur(String nomCommutateur, List<Machine> list) {
		
		this.nomCommutateur = nomCommutateur;
		this.list = list;
	}
	
	public Commutateur(String nomCommutateur) {
		
		this.nomCommutateur = nomCommutateur;
		list = new ArrayList<>();
	}

	public String getNomCommutateur() {
		
		return nomCommutateur;
	}

	public void setNomCommutateur(String nomCommutateur) {
		
		this.nomCommutateur = nomCommutateur;
	}

	public List<Machine> getList() {
		
		return list;
	}

	public void setList(List<Machine> list) {
		
		this.list = list;
	}
}