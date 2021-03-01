package mp1;

class PalindromeChecker{
	public static void check(String str) {
		boolean isPalindrome = true;
		int i = 0;
		int length = str.length();
		
		for(i=0; i < length; i++) {	
			if(str.charAt(i) != str.charAt(length-1-i)) {
				isPalindrome = false;
				break;
			}
		}		
		if(isPalindrome) {
			System.out.println(str + " is a palindrome.");
		}
		else {
			System.out.println(str + " is not a palindrome.");
		}
	}
	
	public static void check(int num) {
		int reversedInt = 0;
		int givenInt = num;
		int rem;
		
		while(num != 0) {
			rem = num % 10;
			reversedInt = reversedInt * 10 + rem;
			num /=  10;
		}	
		if(givenInt == reversedInt) {
			System.out.println(givenInt + " is a palindrome.");
		}
		else {
			System.out.println(givenInt + " is not a palindrome.");
		}
	}
}

public class Problem11 {
	public static void main(String[] args) {
		PalindromeChecker.check("abcde");
		PalindromeChecker.check("abcba");
		PalindromeChecker.check(1234);
		PalindromeChecker.check(12321);
	}
}
