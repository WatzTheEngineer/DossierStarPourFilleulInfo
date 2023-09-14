package bees.gui;

public class Console {

	public static void title(String title) {
		Console.message(Console.SEPARATOR);
		Console.message(title);
		Console.message(Console.SEPARATOR);
	}

	public static void message(String text) {
		System.out.println(text);
	}

	public static final String SEPARATOR = "--------------------------------------------";

	
	
}
