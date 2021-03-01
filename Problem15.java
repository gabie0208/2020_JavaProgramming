package mp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

class Item{
	private String itemName;
	private int itemCount;
	
	public Item(String name, int count) {
		this.itemName = name;
		this.itemCount = count;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String name) {
		this.itemName = name;
	}
	public void setItemCount(int count) {
		this.itemCount = count;
	}
	public int getItemCount() {
		return itemCount;
	}
	
	@Override
	public String toString() {
		return itemName + " " + itemCount;
	}
}

class MyFileReader {
	public static boolean readDataFromFile(String filename, ArrayList<Item> list) {
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String line;
			
			while((line = br.readLine()) != null) {
				sb.append(line + " ");
			}
			String textFile = sb.toString().toLowerCase();
			String[] strArray = textFile.split(" ");
			int i = 0;
			int length = strArray.length;
			for(i=0; i < length; i++) {
				boolean isExist = false;
				for(Item item:list) {
					if(item.getItemName().equals(strArray[i])) {
						item.setItemCount(item.getItemCount() + 1);
						isExist = true;
					}
				}
				if(!isExist) {
					Item newItem = new Item(strArray[i], 1);
					list.add(newItem);
				}
				br.close();
			}
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}

public class Problem15 {
	public static void main(String[] args) {
		ArrayList<Item> list = new ArrayList<>();
		boolean rv = MyFileReader.readDataFromFile("input_prob15.txt", list);
		if(rv == false) {
			System.out.println("Input file not found.");
			return;
			}
		for(Item it: list) System.out.println(it);
	}
}
