package pgCode;

public class Characters {
	
	// Set up all possible usable characters 
	public static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE = "abcdefghijklmnopwrstuvwxyz";
	public static final String DIGITS = "1234567890";
	public static final String SPECIAL = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~[]";
	
	private final StringBuilder pool;
	
	Characters(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean digitsIncluded, boolean specialCharactersIncluded) {
		pool = new StringBuilder();
		if (uppercaseIncluded)	pool.append(UPPERCASE);
		if (lowercaseIncluded)	pool.append(LOWERCASE);
		if (digitsIncluded)	pool.append(DIGITS);
		if (specialCharactersIncluded)	pool.append(SPECIAL);
	}
	
	String getCharacters() {
		return pool.toString();
	}
}
