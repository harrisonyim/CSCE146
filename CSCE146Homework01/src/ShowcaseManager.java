/*
 * Harrison Yim
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
public class ShowcaseManager 
{
	public static void main(String[] args) 
	{
		printGreeting();
		//Create new prize
		//Populate the prize
		Prize[] prizes = readFile("prizeList.txt");
		if (prizes == null) 
		{
			System.out.println("Error reading prize list.");
			return;
		}
		boolean playAgain = true;
		while(playAgain) 
		{
			//Selects random prizes
			Prize[] showcase = randomizePrizes(prizes);
			//shows random prizes
			displayShowcase(showcase);
			double userGuess = getUserGuess();
			double showcaseTotal = calculateTotalPrice(showcase);
			checkWin(userGuess, showcaseTotal);
			playAgain = playAgain();
		}
	}
	public static void printGreeting() 
	{
		System.out.println("Welcome to the showcase\n"
				+ "You will guess the total cost of five objects.\n"
				+ "If you are $1300 or less below the total cost you win!!!");
	}
	public static Prize[] readFile(String file) 
	{
		Prize[] prizes = new Prize[100];
		int prizeCount = 0;
		
		try 
		{
			Scanner fileScanner = new Scanner(new File(file));
			while (fileScanner.hasNextLine()) 
			{
				String fileLine = fileScanner.nextLine();
				String[] next = fileLine.split("\t");
				//make sure it follows the format
				if(next.length == 2) 
				{
					try
					{
						//Assign name and price
						String name = next[0];
						double price = Double.parseDouble(next[1].trim());
						prizes[prizeCount++] = new Prize(name, price);
					}
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			}
			fileScanner.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		//Return array
		Prize[] validPrizes = new Prize[prizeCount];
		System.arraycopy(prizes, 0, validPrizes, 0, prizeCount);
		return validPrizes;
	}
	//Select 5 random prizes for the showcase
	public static Prize[] randomizePrizes(Prize[] prizes) 
	{
		Random rand = new Random();
		Prize[] showcase = new Prize[5];
		boolean[] selected = new boolean[prizes.length];
		int count = 0;
		while (count <5) 
		{
			int index = rand.nextInt(prizes.length);
			//make sure prizes are unique and not repeating
			if(!selected[index]) 
			{
				selected[index] = true;
				showcase[count++] = prizes[index];
			}
		}
		return showcase;
	}
	public static double calculateTotalPrice(Prize[] showcase) 
	{
		double total = 0;
		for(Prize prize : showcase) 
			total += prize.getPrice();
		return total;
	}
	public static void displayShowcase(Prize[] showcase) 
	{
		System.out.println("Here are your prizes");
		for(Prize prize : showcase)
			System.out.println(prize.getName());
	}
	public static double getUserGuess() 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your guess for the total price of the five item:");
		return keyboard.nextDouble();
	}
	
//Check if they won
	public static void checkWin(double userGuess, double total) 
	{
		if(userGuess >= total - 1300 && userGuess <= total)
			System.out.println("Congratulations You Won!!! The total price was: "+total);
		else
			System.out.println("You lose. The total price was: " + total);
	}
	//see if user wants to play again
	public static boolean playAgain() 
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter 1. To play again \nEnter 9. To quit");
		int response = keyboard.nextInt();
		if(response == 1)
			return true;
		else
			System.out.println("Thanks for Playing");
			return false;
	}

}
