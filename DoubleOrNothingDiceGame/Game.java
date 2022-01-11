
/*********************
 * 
 * Class:  Game
 *           
 * Khair Ahmed
 *CST8110
 *
 */
import java.util.Scanner;
public class Game {
	private int potAmount;
	private int betAmount;
	private String betType;
	private Scanner  input = new Scanner(System.in);
	private Die[] dice;

	public Game() {
		potAmount = 100;
		betAmount = 1;
		betType = "TBD";
		// initialize the array of DIe
				dice = new Die[3];
				for (int i = 0; i < dice.length; i++) {
					dice[i] = new Die();
				}
	}

	public void getBetFromUser() {
		//input user bet
		System.out.print("Enter your bet amount: ");
		betAmount = input.nextInt();
		while (betAmount < 0 || betAmount > potAmount) {
			System.out.print("Error - cannot bet less than 0 or more than " + potAmount + "...Enter your bet amount: ");
			betAmount = input.nextInt();
		}

		if (betAmount >0) {
			//input bet type (odd, even, high, low)
			System.out.println("Enter bet type");
			betType= input.next();

			//limit the input to 4 different selections
			while (true) {
				if (betType.equalsIgnoreCase("even") || betType.equalsIgnoreCase("odd") ||
						betType.equalsIgnoreCase("high") || betType.equalsIgnoreCase("low")) {
					System.out.println("you Have selected " + betType);
					break;

				}
				else {
					System.out.println("Invalid choice, choose odd, even, high or low");
					betType= input.next();
				}
			}

		}
	}

	public void playGame() {
		//Intro Line
		System.out.println("Welcome to Double of Nothing Dice Game.. bet and amount and type"
				+ " \n    - if you are correct, you win twice your bet,"
				+ " \n    - otherwise you lose your bet"
				+ " \nA bet of 0 ends the game");



		System.out.println ("Your current pot is $" + potAmount);
		getBetFromUser();

		while (betAmount != 0 && potAmount > 0) {
			potAmount -= betAmount;


			System.out.print ("Your die are: ");
			dice[0].rollDie();
			dice[0].displayDie();
			System.out.print (" and ");
			dice[1].rollDie();


			dice[1].displayDie();
			System.out.print(" and ");

			dice[2].rollDie();
			dice[2].displayDie();
			System.out.println ();



			// win if you guess even and get a sum of a even number
			if ((dice[0].getValue() + dice[1].getValue() + dice[2].getValue()) %2 == 0 && betType.equalsIgnoreCase("even")) {
				System.out.println("\n You WIN... Double your bet\n");
				potAmount = potAmount + 2*betAmount;
			}

			// win if user guess odd and get a sum of a odd number
			else if((dice[0].getValue() + dice[1].getValue() + dice[2].getValue()) %2 == 1 && betType.equalsIgnoreCase("odd")) {
				System.out.println("\nYou WIN... Double your bet");
				potAmount = potAmount + 2*betAmount;
			}
			// win if user guess high and get a high number
			else if((dice[0].getValue() + dice[1].getValue() + dice[2].getValue())  >=9 && betType.equalsIgnoreCase("high")) {
				System.out.println("\nYou WIN... Double your bet");
				potAmount = potAmount + 2*betAmount;
			}
			// win if user guess low and get a low number
			else if((dice[0].getValue() + dice[1].getValue() + dice[2].getValue())<9 && betType.equalsIgnoreCase("low")) {
				System.out.println("\nYou WIN... Double your bet ");
				potAmount = potAmount + 2*betAmount;
			}
			//if user didn't guess correct
			else {
				System.out.println(" you lose ");
			}
			System.out.println ("\nYour current pot is " + potAmount);
			if (potAmount > 0)
				getBetFromUser();


		}
		System.out.println ("You end the game with pot of " + potAmount);
	}


}
