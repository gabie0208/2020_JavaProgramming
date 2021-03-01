package mp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

class ElementReader{
	public static ArrayList<Element> readElements(String filename){
		ArrayList<Element>list = new ArrayList<>();		
		try {
			Scanner in = new Scanner(new File(filename));
			while(in.hasNext()) {
				list.add(new Element(in.next(), in.nextDouble()));
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			return null;
			}
			return list;
	}
}

class Element implements Comparable<Element> {
    private String name;
    private double price;
    
    public Element(String name, double price) {
            this.name = name;
            this.price = price;
    }
    public String getName() {
            return name;
    }
    public double getPrice() {
            return price;
    }
    @Override
    public String toString() {
            return name + " " + price;
    }
    @Override
    public int compareTo(Element o) {
            if (price > o.price || price < o.price)
            {
            	if(price > o.price)
            		return 1;
            	else return -1;
            }
            else return name.compareTo(o.name);
    }
}

public class Problem16 {
	public static void main(String args[]) {
		ArrayList<Element> list = ElementReader.readElements("input.txt");
		if(list == null) {
			System.out.println("Input file not found.");
			return;
			}
		Collections.sort(list);
		Iterator<Element> it = list.iterator();
		while(it.hasNext()) System.out.println(it.next());	
	}
}

