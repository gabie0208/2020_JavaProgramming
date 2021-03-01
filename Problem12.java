package mp1;

class SubsequenceChecker{
	public static void check(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int indexes[] = new int[len2];
		int j = 0;
		
		for(int i=0; i < len1; i++) {
			if(str1.charAt(i)==str2.charAt(j)) {
				indexes[j] = i;
				j++;
			}
			if(j == len2) {
				break;
			}
		}
		
		if(j==len2) {
			System.out.println(str2 + " is a subsequence of " + str1);
			
			for(int x:indexes) 
				System.out.print(x + " ");
			}else {
				System.out.println("\n" + str2 + " is not a subsequence of " + str1);
		}
	}
}

public class Problem12 {
	public static void main(String[] args) {
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "pads");
		SubsequenceChecker.check("supercalifragilisticexpialidocious", "padsx");
	}
}
