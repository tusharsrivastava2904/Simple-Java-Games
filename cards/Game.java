package cards;

public abstract class Game {
	String nameString;
	int balance, bet;
	
	abstract void gameStart();
	abstract void roundWinner();
	
}
