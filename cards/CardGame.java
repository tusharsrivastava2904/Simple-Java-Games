package cards;

import java.util.Random;
import java.util.Scanner;

public class CardGame extends Game implements Card {
	
	Scanner scanner = new Scanner(System.in);
	
	int rounds=0;
	
	boolean play=true;
	
	int[][] allCards = new int[4][13];
	
	int[][] cards = new int[3][2];
	
	
// GET CARD
	@Override
	public int[] getCard() {
		Random random = new Random();
		int[] card = new int[2];
		card[0] = random.nextInt(SYMNUM);
		card[1] = random.nextInt(CARDNUM);
		
		for (int i=0; i<4; i++) {
			for (int j=0; j<13; j++) {
				while (card[0]==i && card[1]==allCards[i][j]) {
					card[0] = random.nextInt(SYMNUM);
					card[1] = random.nextInt(CARDNUM);
				}
			}
		}
		
//		mark(card);
		return card; //suit,rank
	}
//MARK
	private void mark(int[] card) {
		if (allCards[card[0]][card[1]] != -1) {
			allCards[card[0]][card[1]] = -1; //marked
		} else if (allCards[card[0]][card[1]] == -1) {
			System.out.println("Beware of cheating, this card has been used!");
		}
	}
//GAME START
	@Override
	void gameStart() {
		balance = 100;
		System.out.println("****Game start!****\nEnter your name: ");
		nameString = scanner.next();
		initialize();
		newRound();
	}

	//INITIALIZE
private void initialize() {
	for (int i=0; i<4; i++) {
		for (int j=0; j<13; j++) {
			allCards[i][j] = 0;
		}
	}
	
}
//NEW ROUND	
	int[][] newRound(){
		cards[0] = getCard();
		cards[1] = getCard();
		display(cards[0]);
		display(cards[1]);
		System.out.println("0: Fold \n1: Play\n\n");
		int input = scanner.nextInt();
		if (input==1) {
			play=true;
			rounds++;
			cards[2] = getCard();
			display(cards[2]);
			mark(cards[2]);
			roundWinner();
		} else if (input==0) {
			play=false;
			toString(balance, rounds, play);
			reset();
			System.out.println("\n\n****END GAME!****");
		} else {
			System.out.println("INVALID INPUT");
		}
		return cards;
	}
//DISPLAY
	private void display(int[] b) {
		String suit = "";
		int rank = b[1]+1;
		if (b[0]==0) suit = "Club";
		else if (b[0]==1) suit = "Diamonds";
		else if (b[0]==2) suit = "Hearts";
		else if (b[0]==3) suit = "Spades";
		
		System.out.println(rank + "," + suit+"\n");
	}
//ROUND WINNER
	@Override
	void roundWinner() {
		boolean win = false;
		if(cards[2][1] < cards[1][1]
				&& cards[2][1] > cards[0][1]) {
			win = true;
		}
		if (win==true) {
			balance++;
			toString(balance, rounds, win);
		} else if (win==false) {
			balance--;
			toString(balance, rounds, win);
		}
	}
	
	public void toString(int balance, int rounds, boolean win) {
		System.out.println("Name: "+nameString+" Initial balance: 100, Rounds played: "
	+rounds+", Winning status: "+win+", Current balance: "+balance+"\n@@@@");		
	}
	
	public void reset() {
		for (int i=0; i<4 ;i++) {
			for (int j=0; j<13; j++) {
				allCards[i][j]=0;
			}
		}
		balance = 100;
		rounds = 0;
	}
	

}
