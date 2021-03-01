package cse3040_hw2;

import java.util.Scanner;

interface IntSequenceStr{
	public boolean hasNext();
	public int next();
}
class BinarySequenceStr implements IntSequenceStr{
	private int n;
	private double k;

	BinarySequenceStr(int num){
		this.n = num;
		k = Math.pow(2, 20);
		if (num == 0) {
			k = 0; 
			return;
		}
		else if (num > 0) {
			while(k != 0) {
				if((num & (int)k) > 0) break;
				k /= 2;
			}
			num = num / 2;
		}
		return;
	}
	public boolean hasNext() {
		if(k >= 1) return true;
		else   	   return false;
	}
	public int next() {
		int temp = this.n & (int)k;
		k /= 2;
		if (temp > 0) return 1;
		else 		  return 0;
	}
}
public class Problem07 {
	 public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 System.out.print("Enter a positive integer: ");
	 String str = in.nextLine();
	 int num = Integer.parseInt(str);
	 in.close();
	 System.out.println("Integer: " + num);
	 IntSequenceStr seq = new BinarySequenceStr(num);
	 System.out.print("Binary number: ");
	 while(seq.hasNext()) System.out.print(seq.next());
	 System.out.println(" ");
	}
}