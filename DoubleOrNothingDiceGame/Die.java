import java.util.Random;


public class Die{
	private int dieValue;

	public Die() {
		dieValue = 1;
	}

	public int rollDie() {
		Random randomNumbers = new Random();
		dieValue = randomNumbers.nextInt(6) + 1;
		return dieValue;
	}

	public void displayDie() {
		System.out.print (dieValue);
	}

	public int getValue() {
		return dieValue;
	}

}
