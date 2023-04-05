package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Ressources.Artere;
import Ressources.Commutateur;
import Ressources.Interface;
import Ressources.Machine;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Combien de machines dans le réseau ?");
		int nbMachine = sc.nextInt();
		
		Machine[] tab = new Machine[nbMachine];
		
		for(int i = 0; i < nbMachine; ++i) {
			
			tab[i] = new Machine("m" + (i+1));
		}
		
		System.out.println("Combien de commutateurs dans le réseau ?");
		int nbComm = sc.nextInt();
		
		List<Commutateur> commutateurs = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		List<Machine>[] machines = new ArrayList[nbComm];
		
		for(int i = 0; i < nbComm; ++i) {
			
			commutateurs.add(new Commutateur("c" + (i+1)));
			machines[i] = new ArrayList<Machine>();
		}
		
		for(int i = 0; i < nbMachine; ++i) {
			
			System.out.println("Quel est le numéro du commutateur sur lequel la machine " + (i+1) + " est connectée ?");			
			int numC = sc.nextInt();
			
			machines[--numC].add(tab[i]);
		}
		
		for(int i = 0; i < nbComm; ++i) {
			
			commutateurs.get(i).setList(machines[i]);
		}
		
		System.out.println("Combien d'artères dans le réseau ?");
		int nbArt = sc.nextInt();
		
		List<Artere> arteres = new ArrayList<>();
		
		for(int i = 0; i < nbArt; ++i) {
			
			System.out.println("Pour l'artère " + (i+1) + ", donnez les deux commutateurs à relier : ");
			int numC1, numC2;
			
			do {
				
				System.out.println("Numéro de c1 : ");
				numC1 = sc.nextInt();
				
				if(numC1 <= 0 || numC1 > nbComm) {
					
					System.out.println("Le numéro de C1 rentré est invalide, rentrez un numéro inferieur au nombre de commutateurs et superieur à 0.");
				}
			} while(numC1 <= 0 || numC1 > nbComm);
			
			do {
				
				System.out.println("Numéro de c2 : ");
				numC2 = sc.nextInt();
				
				if(numC2 <= 0 || numC2 > nbComm) {
					
					System.out.println("Le numéro de C2 rentré est invalide, rentrez un numéro inferieur au nombre de commutateurs et superieur à 0.");
				}
			} while(numC2 <= 0 || numC2 > nbComm);
			
			arteres.add(new Artere(commutateurs.get(--numC1), commutateurs.get(--numC2)));
		}
		
		Interface reseau = new Interface(commutateurs, arteres);
		System.out.println(reseau);
		
		sc.close();
	}
}