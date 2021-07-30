import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class StonePaperScissor {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char choice;
		
		System.out.println("STONE PAPER SCISSOR");
		System.out.println("Rules:\n1. 5 chances to win"
				+ "\n2. Choose s: Stone"
				+ "\n3. Choose p: Paper"
				+ "\n4. Choose x: Scissor\n");
		System.out.println("Want to play [y/n]");
		choice = sc.next().charAt(0);
		
		if (choice=='y') {
			playgame();
		} else if (choice=='n') {
			System.out.println("Thanks for playing!");
		}
		
		sc.close();
		
	}

	private static void playgame() {
		
		Scanner sc = new Scanner(System.in);
		
		int user=0, computer=0;
		int computer_ch;
		char user_move, choice;
		
		Random random = new Random();
		
		System.out.println("Let's Start\n");
		for (int i=0;i<5;i++) {
			System.out.println("Enter your choice: \t \t \t Computer: "+computer+"\t User:"+user);
			user_move = sc.next().charAt(0);
			computer_ch = random.nextInt(3) + 0;
			
			//computer_ch {0:Stone, 1:Paper, 2:Scissor}
			
			if (computer_ch==0) {			//Computer chooses stone
				if (user_move=='s') {
					System.out.println("Computer choice: s \n Draw! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='p') {
					user++;
					System.out.println("Computer choice: s \n You win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='x') {
					computer++;
					System.out.println("Computer choice: s \n Computer win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				}
			} else if (computer_ch==1) {	//Computer chooses paper
				if (user_move=='s') {
					computer++;
					System.out.println("Computer choice: p \n Computer win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='p') {
					System.out.println("Computer choice: p \n Draw! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='x') {
					user++;
					System.out.println("Computer choice: p \n You win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				}
			} else if (computer_ch==2) {	//Computer chooses scissor
				if (user_move=='s') {
					user++;
					System.out.println("Computer choice: x \n You win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='p') {
					computer++;
					System.out.println("Computer choice: x \n Computer win! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				} else if (user_move=='x') {
					System.out.println("Computer choice: x \n Draw! \t \t \t Computer: "+computer+"\t User:"+user+"\n");
				}
			}
		}
		
		if (user>computer) {
			System.out.println("\n\n!!!!YOU WON THE GAME!!!!");
		} else if (computer>user) {
			System.out.println("\n\n****YOU LOST THE GAME****");
		} else if (computer==user) {
			System.out.println("\n\n$$$$ GAME DRAW $$$$");
		}
		
		System.out.println("Want to play again? [y/n]");
		choice = sc.next().charAt(0);
		
		if (choice=='y') {
			playgame();
		} else if (choice=='n') {
			System.out.println("Thanks for playing!");
		}
		
		sc.close();
		
	}
	
}
