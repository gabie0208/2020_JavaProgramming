package mp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class MapManager{
   public static Map<String,Double> readData(String input) {  
       Map<String,Double> map1 = new TreeMap<String,Double>();
       File file = new File(input);          
       try {         
           Scanner in = new Scanner(file);                    
           while(in.hasNextLine()){             
               String line = in.nextLine();              
               String data[] = line.split(" "); 
               Double price = Double.parseDouble(data[1]);
               map1.put(data[0], price);
           }
           in.close();
           
           TreeMap<String, Double> map2 = new TreeMap<String, Double>(){
			@Override
               public String toString(){
				StringBuffer res = new StringBuffer();
                for (Map.Entry<String, Double>entry : this.entrySet()) {
                	res.append(entry.getKey() + " " + entry.getValue() + "\n");
                	}
                return res.toString();
               }
           };
           map2.putAll(map1);
           return map2;
       } 
       catch (FileNotFoundException e) {
           return null;
       }
   }
}

public class Problem17 {
	public static void main(String args[]) {
		Map<String, Double> map = MapManager.readData("input.txt");
		if(map == null) {
			System.out.println("Input file not found.");
			return;
		}
		System.out.println(map);
	}
}