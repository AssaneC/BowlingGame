package game.bowling;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
	private String nickName;
	
	private String firstName;
	
	private String lastName;
	
	private int points; 
	
	private int id  = 0;
	
	private Random random = new Random();
	
	private Turn turn = new Turn();
	
	
	
	static ArrayList<Player> listPlayer = new ArrayList<>();
	
	protected Turn getTurn() {
		return turn;
	}


	protected void setTurn(Turn turn) {
		this.turn = turn;
	}
	
	protected String myName() {
		return nickName + " (" + firstName + " " + lastName + ")";
	}
	public Player(int p_id, String p_nickName,String  p_firstName, String p_lastName ,int nbScore) {
		
		id = p_id;
		
		nickName = p_nickName;
		
		firstName = p_firstName;
		
		lastName = p_lastName;
		
		turn.setId(p_id);
		turn.setNbScore(nbScore);
	
	}
	
	
	protected int throwBall() {
		
		return random.nextInt(0 + 9) + 0;
	}
	
	
	
	private static String ask(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.print(message + " : ");
		String res = sc.next();
		return res;
	}
	
	public static void subscribe(int nbScore) {
		
        System.out.println("=== Inscription d'un nouveau joueur ===");

		String nick = ask("Saisir votre surnom");
		
		String first = ask("Saisir votre prénom");

		String last = ask("Saisir votre nom");
		
		
		int id = listPlayer.size();
		
		Player plyr = new Player(id , nick , first , last, nbScore);
		
		listPlayer.add(plyr);
		
        System.out.println("Inscription réussié ! Bienvenue " + nick + " !");

	}
	@Override
	public String toString() {
		
	    return String.format("%-20s", nickName) + " " + turn.toString();
	    
	}
	
	

}
