import java.util.Random;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int rndNumber = getRandom();
		play(rndNumber);
		

	}
	private static void play(int rndNumber) {
		System.out.println("Guess a number between 1 and 100");
		int guess;
		Scanner input = new Scanner(System.in);
		boolean cycle = true;
		while(cycle){
			guess = input.nextInt();
			if(guess < rndNumber){
				System.out.println(guess + " is too low. Try again.");
			}
			else if(guess > rndNumber){
				System.out.println(guess + " is too high. Try again.");
			}
			else{
				System.out.println(guess + " is correct! You win!");
				System.out.println("Would you like to play again (y/n)?");
				String answer = input.next();
				if(answer.equals("y")){
					play(getRandom());
				}
				else{
					System.out.println("Thank you for playing! Goodbye!");
					cycle = false;
				}
			}
		}
		input.close();
		
	}
	public static int getRandom(){
		Random rnd = new Random();
		int rndNumber = rnd.nextInt(101);
		return rndNumber;
	}

}
