package hw;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Hello World");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your firstName :");
		String fName = scanner.nextLine();
		
		int grNumber;
		do {
			System.out.println("Enter group number (1, 2, 3) :");
			grNumber = scanner.nextInt();
		} while (grNumber < 1 || grNumber > 3);
		
		System.out.println("Welcome "+fName+" from Group "+grNumber);
		
		scanner.close();
	}

}
