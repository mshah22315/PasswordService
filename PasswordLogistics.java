package pgCode;

public class PasswordLogistics {
	String value;
	int length;
	
	PasswordLogistics(String s) {
		value = s;
		length = s.length();
	}
	
	int CharType(char C) {
		int result = 0;
		
		if((int) C >= 65 && (int) C <= 90) {
			result = 1;
		}
		
		else if((int) C >= 97 && (int) C <= 122) {
			result = 2;
		}
		
		else if((int) C >= 48 && (int) C <= 57) {
			result = 3;
		}
		
		else if((int) C >= 33 && (int) C <= 47 || (int) C >= 58 && (int) C <= 64 || (int) C >= 91 && (int) C <= 96 || (int) C >= 123 && (int) C <= 126) {
			result = 4;
		}
		
		return result;
	}
	
	int PasswordStrength() {
		String s = this.value;
		boolean UsedUpper = false;
		boolean UsedLower = false;
		boolean UsedDigits = false;
		boolean UsedSpecChar = false;
		int type;
		int grade = 0;
		
		for (int i=0; i<length; i++) {
			char c = s.charAt(i);
			type = CharType(c);
			
			if(type == 1)	UsedUpper = true;
			if(type == 2)	UsedLower = true;
			if(type == 3)	UsedDigits = true;
			if(type == 4)	UsedSpecChar = true;
		}
		
		if(UsedUpper)	grade += 1;
		if(UsedLower)	grade += 1;
		if(UsedDigits)	grade += 1;
		if(UsedSpecChar)	grade +=1;
		
		if(length >= 8)	grade += 1;
		if(length >= 12)	grade += 1;
		if(length >= 16)	grade += 1;
		
		return grade;
	}
	
	String getPasswordGrade() {
		int grade = this.PasswordStrength();
		
		if (grade == 7)
			return "That's a powerful password, no need for improvement at all!";
		else if (grade >= 6)
			return "That's a strong password! Maybe make the password just a little bit stronger, and it'll be perfect!";
		else if (grade >= 5)
			return "That's a good password, but look into strengthening it further.";
		else if (grade >= 4)
			return "That's an OK password, but it certainly needs a lot of work.";
		else
			return "That password is definitely going to be cracked easily by a hacker, please improve it.";
		
	}
	
	public String toString() {
		return value;
	}
}
