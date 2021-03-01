package cse3040_hw2;

interface IntSequence{
	public boolean hasNext();
	public int next();
}
class FibonacciSequence implements IntSequence{
	private int n1, n2, n3;
	public FibonacciSequence() {
		n1 = -1; 
		n2 = 0; 
		n3 = 1;
	}
	public boolean hasNext() {
		n1++;
		return (n1)!= 20;
	}
	public int next(){
		if (n1 == 0) 
			return 0;
		else if (n1 == 1) 
			return 1;
		int result = n2 + n3;
		n2 = n3;
		n3 = result;
		return result;	
	}
}
public class Problem06 {
	public static void main(String[] args) {
		IntSequence seq = new FibonacciSequence();
		for(int i=0; i<20; i++) {
			if(seq.hasNext() == false) break;
			System.out.print(seq.next() + " ");
		}
		System.out.println(" ");
	}
}