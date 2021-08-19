package cards;

public class Test {

	public static void main(String[] args) {
		CardGame cardGame = new CardGame();
		Boolean playBoolean=true;
		cardGame.gameStart();
		while(playBoolean==true) {
			if (cardGame.play==true) {
				cardGame.newRound();
			} else {
				cardGame.reset();
			}
		}
	}

}