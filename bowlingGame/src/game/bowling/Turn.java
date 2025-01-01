package game.bowling;

import java.util.ArrayList;

public class Turn {
	
	private int id = 0;
	
	private int nbScore = 0;
	
	protected ArrayList<Score>  listScore = new ArrayList<>();

	protected ArrayList<Score> getListScore() {
		return listScore;
	}

	protected int getNbScore() {
		return nbScore;
	}

	protected void setNbScore(int nbScore) {
		this.nbScore = nbScore;
		for (int i=0;i<nbScore;i++) {

			listScore.add(new Score(i));

		}

	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}
	
	protected int getTotalScore() {
		
		int res = 0;
		
		for (Score sc : listScore) {

			res+= sc.getPoints();
		}
		
		return res;
	}
	
	public String toString() {
		String res = "";
		for (Score sc : listScore) {
			res += sc.toString();
		}
		
		res+= String.format("%-19s", "     " +getTotalScore()) + "|";
		return res + "\n";
	}
}
