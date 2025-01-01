package game.bowling;

import java.util.Scanner;

public class Game {
	
	
	private int nbTurn  = 5;//le nombre de tours, le nombre de colonnes
	
	private static Game instance = null;
	
	private Game() { // nbtrn = le nombre de tour pour chaque joueur pour une partie
		
		while (true && Player.listPlayer.size() < 3) {
			Player.subscribe(nbTurn);
		}
				
		
	}
	
	
	public static Game getInstance() {
		
		if ( instance == null ) {
			instance = new Game();
		}
		
		return instance;
	}
	
	private void rankPlayer() {
		// Trier les joueurs en fonction du score total
	    Player.listPlayer.sort((p1, p2) -> Integer.compare(p2.getTurn().getTotalScore(), p1.getTurn().getTotalScore()));
	}
	
	public void start() {
		Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Début de la partie ===\n");

		for (int currentTurn= 0; currentTurn < nbTurn; currentTurn++) {
            System.out.println("=== Tour " + (currentTurn + 1) + " ===\n");
			for (Player p : Player.listPlayer) {
				//displaye the name player
	            System.out.println(p.myName());

				System.out.print("Appuiyez sur la touche entrée pour le premier lancer");
				sc.nextLine();
				
				int  firstPoint = p.throwBall();
				//autoriser l'affichage au niveau du score
				p.getTurn().getListScore().get(currentTurn).setCurrent(true);;

				System.out.println("Le premier lancer a obtenu : " + firstPoint + " points.");

				//save first points
				p.getTurn().getListScore().get(currentTurn).setFirstTryPoints(firstPoint);;
				
				System.out.print("Appuiyez sur la touche netrée pour le second lancer");
				sc.nextLine();
				
				int  secondPoint = p.throwBall();
				System.out.println("Le second lancer a obtenu : " + secondPoint + " points.");

				//save second points
				p.getTurn().getListScore().get(currentTurn).setSecondTryPoints(secondPoint);
				
				System.out.print(this);
			}
			
		}
		
        System.out.println("\n=== Fin de la partie ===");
        //Trier les joueurs
        this.rankPlayer();
        
        System.out.print(this);

	}
	
	
	
	public String toString() {
		// Créer la ligne de délimitation supérieure
	    String res = "_".repeat(20*(nbTurn+2)) + "_\n";
	    
	    res+= String.format("%-20s", "Surnom") + "|";
	    for (int i = 1; i <= nbTurn; i++) {
	        res += String.format("%-19s","   Tour " + i) + "|";  // aligner les titres des tours
	    }
	    
	    res+= String.format("%-19s", "   Total-Score") + "|\n";
	    
	    res+= "_".repeat(20*(nbTurn+2)) + "_\n";


	    for (Player pl : Player.listPlayer) {
			res += pl.toString();
			res+= "_".repeat(20*(nbTurn+2)) + "_\n";
		}
	    
		return res + "\n\n";
	}
	
}
