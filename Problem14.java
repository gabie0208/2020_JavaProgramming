package mp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Fruit{
	private String fruitName;
	private double fruitPrice;	
	public Fruit() {
		fruitName = new String();
		fruitPrice = 0.0;
	}
	public Fruit(String name, double price) {
		this.fruitName = name;
		this.fruitPrice = price;
	}
	public Fruit(Fruit item) {
		this.fruitName = item.getName();
		this.fruitPrice = item.getPrice();
	}
	public String getName() {
		return this.fruitName;
	}
	public double getPrice() {
		return this.fruitPrice;
	}
	public void setName(String name) {
		this.fruitName = name;
	}
	public void setPrice(double price) {
		this.fruitPrice = price;
	}
	public String toString() {
		return fruitName + " " + String.valueOf(fruitPrice);
	}
}
class FruitBox<T extends Fruit>{
	private List<T> items;
	private T maxItem;
	private T minItem;	
	public FruitBox() {
		items = new ArrayList<T>();
	}	
	public void add(T item) {
		items.add(item);
		System.out.println(item);
		
		if(items.size() == 1) {
			maxItem = item;
			minItem = item;
		}
		else {
			if(item.getPrice() > maxItem.getPrice())
				maxItem = item;
			if(item.getPrice() < minItem.getPrice())
				minItem = item;
		}
	}	
	public int getNumItems() {
		return items.size();
	}
	public double getAvgPrice() {
		double average = 0.0;
		double sum = 0.0;
		
		for(T item: items) {
			sum += item.getPrice();
		}
		average = sum / getNumItems();
		return average;
	}
	public String getMaxItem() {
		return maxItem.getName();
	}
	public String getMinItem() {
		return minItem.getName();
	}
	public double getMaxPrice() {
		return maxItem.getPrice();
	}
	public double getMinPrice() {
		return minItem.getPrice();
	}
}
class ItemReader{
	public static boolean fileToBox(String filename, FruitBox<Fruit> box) {
		try {
			File file = new File(filename);
			Scanner in = new Scanner(file);			
			while(in.hasNext()) {
				String[] str = in.nextLine().split(" ");
				Fruit fruit = new Fruit(str[0], Double.parseDouble(str[1]));
				box.add(fruit);
			}
			in.close();
			return true;	
		}
		catch(FileNotFoundException exc) {
			System.out.println("Input file not found.");
		}
		return false;
	}
}
public class Problem14 {
	public static void main(String[] args) {
		FruitBox<Fruit> box = new FruitBox<>();
		boolean rv = ItemReader.fileToBox("input_prob14.txt", box);
		if(rv == false) return;
		box.add(new Fruit("orange", 9.99));
		System.out.println("----------------");
		System.out.println(" Summary");
		System.out.println("----------------");
		System.out.println("number of items: " + box.getNumItems());
		System.out.println("most expensive item: " + box.getMaxItem() + " (" +
							box.getMaxPrice() + ")");
		System.out.println("cheapest item: " + box.getMinItem() + " (" +
							box.getMinPrice() + ")");
		System.out.printf("average price of items: %.2f", box.getAvgPrice());}
}