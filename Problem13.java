package mp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Text{
	private String textFile;	
	public boolean readTextFromFile(String fileName) {
		try {
			File file = new File(fileName);
			BufferedReader in = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String line;
			
			while((line = in.readLine()) != null) {
				sb.append(line + "\n");
			}
			textFile = sb.toString().toLowerCase();
			in.close();
		}
		catch(Exception e) {
			System.out.println("Input file not found.");
		} 
		return true;
	}
	
	public int countChar(char ch) {
		int i;
		int cnt = 0;
		int length = textFile.length();
		
		for(i=0; i < length; i++) {
			if(textFile.charAt(i) == ch) {
				cnt++;
			}
		}
		return cnt;
	}
}

public class Problem13 {
	public static void main(String[] args) {
		Text t = new Text();
		if(t.readTextFromFile("input_prob13.txt")) {
			for(char c = 'a'; c <= 'z'; c++) {
				System.out.println(c + ": " + t.countChar(c));
			}
		}
	}
}
