package pgCode;
import java.util.Scanner;

public class PasswordGenerator {
	Characters characters;
	public static Scanner keyboard;
	
	PasswordGenerator(Scanner scanner) {
		keyboard = scanner;
	}
	
	PasswordGenerator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeDigits, boolean IncludeSpecChar) {
		characters = new Characters(IncludeUpper, IncludeLower, IncludeDigits, IncludeSpecChar);
	}
	
	void mainLoop() {
		System.out.println("This is Shah Password Services: ");
		printMenu();
		
		String userChoice = "-1";
		
		while (!userChoice.equals("4")) {
			userChoice = keyboard.next();
			
			switch (userChoice) {
				case "1":
					askForPassword();
					printMenu();
					break;
				case "2":
					checkPassword();
					printMenu();
					break;
				case "3":
					passwordTidbits();
					printMenu();
					break;
				case "4":
					quitProgram();
					break;
				default:
					System.out.println("Please choose one of the options.");
					printMenu();
			}
		}
	}
	
	private PasswordLogistics GeneratePassword(int length) {
		final StringBuilder pass = new StringBuilder("");
		
		final int characterLength = characters.getCharacters().length();
		
		int max = characterLength;
		int min = 0;
		int range = max - min;
		
		for (int i=0; i<length; i++) {
			int index = (int) (Math.random() * range) + min;
			pass.append(characters.getCharacters().charAt(index));
		}
		
		return new PasswordLogistics(pass.toString());
	}
	
	private void passwordTidbits() {
		System.out.println();
		System.out.println("These are some useful tidbits about passwords:");
		System.out.println("Make sure your password is at least 8 characters.");
		System.out.println("Have a proper mix of uppercase letters, lowercase letters, numbers, and/or special characters.");
		System.out.println("DO NOT use the same password for multiple accounts!");
		System.out.println("Avoid any character sequences that can be easily typed (i.e. repeated characters, keyboard patterns, common words).");
		System.out.println("Avoid using any personal information (i.e. your name and other biographical information, family/pet names");
	}
	
	private void askForPassword() {
		boolean IncludeUpper = false;
		boolean IncludeLower = false;
		boolean IncludeDigits = false;
		boolean IncludeSpecChar = false;
		
		boolean correctParams;
		
		System.out.println();
		System.out.println("This is the Password Generator! Before we get started, however, answer Yes or No to these questions:");
		
		do {
			String input;
			correctParams = false;
			
			do {
				System.out.println("Would you like uppercase letters in your password?");
				input = keyboard.next();
				PasswordRequestError(input);
			}	while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));
			
			if (isInclude(input))	IncludeUpper = true;
			
			do {
				System.out.println("Lowercase letters?");
				input = keyboard.next();
				PasswordRequestError(input);
			}	while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));
			
			if (isInclude(input))	IncludeLower = true;
			
			do {
				System.out.println("Numbers?");
				input = keyboard.next();
				PasswordRequestError(input);
			}	while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));
			
			if (isInclude(input))	IncludeDigits = true;
			
			do {
				System.out.println("Special characters?");
				input = keyboard.next();
				PasswordRequestError(input);
			}	while (!input.equalsIgnoreCase("Yes") && !input.equalsIgnoreCase("No"));
			
			if (isInclude(input))	IncludeSpecChar = true;
			
			
			if (!IncludeUpper && !IncludeLower && !IncludeDigits && !IncludeSpecChar) {
				System.out.println("You haven't selected any type of characters for your password, please try again and select at least one.");
				correctParams = true;
			}
		}	while (correctParams);
		
		System.out.println("Now that you've picked your character types, enter the length of your password: ");
		int length = keyboard.nextInt();
		
		final PasswordGenerator generator = new PasswordGenerator(IncludeUpper, IncludeLower, IncludeDigits, IncludeSpecChar);
		final PasswordLogistics password = generator.GeneratePassword(length);
		
		System.out.println("Your randomly generated password is: " + password);
	}
	
	private boolean isInclude(String Input) {
		if (Input.equalsIgnoreCase("Yes"))
			return true;
		else
			return false;
	}
	
	private void PasswordRequestError(String i) {
		if (!i.equalsIgnoreCase("Yes") && !i.equalsIgnoreCase("No"))
			System.out.println("Invalid answer, try again.");
	}
	
	private void checkPassword() {
		String input;
		
		System.out.println();
		System.out.println("Please type out the password you wish to use: ");
		input = keyboard.next();
		
		final PasswordLogistics p = new PasswordLogistics(input);
		
		System.out.println(p.getPasswordGrade());
	}
	
	private void printMenu() {
		System.out.println();
		System.out.println("For access to the password generator, press 1.");
		System.out.println("To check how strong a password is, press 2.");
		System.out.println("To receive information on how to generate a strong password, press 3.");
		System.out.println("To quit, press 4.");
		System.out.print("Your Choice: ");
	}
	
	private void quitProgram() {
		System.out.println();
		System.out.println("Thanks for using Shah Password Services! Feel free to come back again!");
	}
}
