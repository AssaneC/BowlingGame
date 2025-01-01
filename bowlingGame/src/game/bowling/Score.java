package game.bowling;

public class Score {
	private boolean isStricke = false;
	private boolean isSpare = false;
	private int firstTryPoints = 0;
	private int secondTryPoints = 0;
	private int idTurn = 0;
	
	private boolean isCurrent = false;
	
	
	//constructeur
	public Score(int idTur ) {
		idTurn = idTur;
	}
	
	protected void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	protected boolean isStricke() {
		return isStricke;
	}
	
	protected void setStricke(boolean isStricke) {
		this.isStricke = isStricke;
	}
	
	protected boolean isSpare() {
		return isSpare;
	}
	
	protected void setSpare(boolean isSpare) {
		this.isSpare = isSpare;
	}
	
	protected int getFirstTryPoints() {
		return firstTryPoints;
	}
	
	public void setFirstTryPoints(int firstTryPoints) {
		this.firstTryPoints = firstTryPoints;
	}
	
	protected int getSecondTryPoints() {
		return secondTryPoints;
	}
	
	public void setSecondTryPoints(int secondTryPoints) {
		this.secondTryPoints = secondTryPoints;
	}
	
	protected int getIdTurn() {
		return idTurn;
	}
	
	protected void setIdTurn(int idTurn) {
		this.idTurn = idTurn;
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected int getPoints(){
		return firstTryPoints + secondTryPoints;
	}
	
	
	protected boolean isPreviousScoreIsSpare(Turn turn) {
		if (idTurn <= 0 ) {
			return false;
		} else {
			
			//retourne {est-ce que le score d'indice idTurn - 1 est un spare
			return turn.getListScore().get(idTurn - 1).isSpare();
			
		}
	}
	
	protected boolean isPreviousScoreIsStricke(Turn turn) {
		
		if (idTurn <= 0 ) {
			return false;
		} else {
			//retourne {est-ce que le score d'indice idTurn - 1 est un stricke
			return turn.getListScore().get(idTurn - 1).isStricke();
		}
	}
	
	public String toString() {
		
		//String res = String.format("%-19s", "   1st = " + firstTryPoints + " 2nd = " + secondTryPoints) + "|";
		
		String res = (this.isCurrent ) ? String.format("%-19s", "   1st = " + firstTryPoints + " 2nd = " + secondTryPoints) + "|" :String.format("%19s", " ") + "|" ;
		
		return res;
	}
	
	
}



