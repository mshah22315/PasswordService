package pgCode;
import java.util.Scanner;

public class PrimaryInterface {

	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		PasswordGenerator generator = new PasswordGenerator(input);
		generator.mainLoop();
		input.close();
	}

}
