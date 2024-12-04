/*
 * Harrison Yim
 */
import java.util.Scanner;

public class VectorMath {
	public static void main(String[]args) {
		Scanner keyboard = new Scanner(System.in);
		boolean test = false;
		System.out.println("Welcome to the vector operations program");
		//Reruns code if vector size is invalid
		while(test == false) 
		{
			System.out.println("Enter 1. To Add 2 Vectors \nEnter 2. To Subtract 2 Vectors \nEnter 3. To Find the Magnitude of a Vector \nEnter 9. To Quit");
			int a = keyboard.nextInt();
			if (a == 9)
			{
				System.out.println("Bye");
				System.exit(0);
			}
			System.out.println("Enter the Size of the Vector(s)");
			int b = keyboard.nextInt();
			//Test if the vextor size is a vlaid input
			if(b<1) 
			{
				System.out.println("Invalid Input");
			}
			else
			{
				if (a == 1)
					Add(b);
				else if  (a == 2) 
					Sub(b);
				else if (a == 3) 
					Mag(b);
				test = true;
			}
		}

	}
	
	
	public static void Add(int c) 
	{
		Scanner keyboard = new Scanner(System.in);
		int size = c;
		//Create arrays
		double[] arrayA = new double[size];
		double[] arrayB = new double[size];
		double[] arrayC = new double[size];
		//Assign arrays values
		System.out.println("Enter the Values for Vector 1");
		for(int i = 0; i < size; i++) 
			arrayA[i] = keyboard.nextDouble();
		System.out.println("Enter the Values for Vector 2");
		for(int i = 0; i < size; i++) 
			arrayB[i] = keyboard.nextDouble();
		//Add each value of the arrays and place them into a new array
		for(int i = 0; i<size; i++) 
			arrayC[i] = arrayA[i] + arrayB[i];
		System.out.println("Result:");
		for(int i = 0; i<size; i++) 
			System.out.println(arrayA[i]);
		System.out.println("+");
		for(int i = 0; i<size; i++) 
			System.out.println(arrayB[i]);
		System.out.println("=");
		for(int i = 0; i < size; i++) 
			System.out.println(arrayC[i]);
	}
	public static void Sub(int c) 
	{
		Scanner keyboard = new Scanner(System.in);
		int size = c;

		//Create arrays
		double[] arrayA = new double[size];
		double[] arrayB = new double[size];
		double[] arrayC = new double[size];
		//Assign arrays values
		System.out.println("Enter the Values for Vector 1");
		for(int i = 0; i < size; i++) 
			arrayA[i] = keyboard.nextDouble();
		System.out.println("Enter the Values for Vector 2");
		for(int i = 0; i < size; i++) 
			arrayB[i] = keyboard.nextDouble();
		//Add each value of the arrays and place them into a new array
		for(int i = 0; i<size; i++) 
			arrayC[i] = arrayA[i] - arrayB[i];
		System.out.println("Result:");
		for(int i = 0; i<size; i++) 
			System.out.println(arrayA[i]);
		System.out.println("-");
		for(int i = 0; i<size; i++) 
			System.out.println(arrayB[i]);
		System.out.println("=");
		for(int i = 0; i < size; i++) 
			System.out.println(arrayC[i]);
	}
	public static void Mag(int c) 
	{
		Scanner keyboard = new Scanner(System.in);
		boolean test = false;
		int size = c;

		//Create array
		double[] arrayA = new double[size];
		int magnitude = 0;
		//Assign array values
		System.out.println("Enter the Values for the Vector");
		for(int i = 0; i < size; i++) 
			arrayA[i] = keyboard.nextDouble();
		//Add each squared value
		for(int i = 0; i< size; i++) 
			magnitude += arrayA[i]*arrayA[i];
		System.out.println("The magnitude is: " + Math.sqrt(magnitude));
	}

}
