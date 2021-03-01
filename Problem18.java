package mp2_for_18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class MapManager{
   private static Map<String, Double> map = null;
   public static Map<String, Double> ReadData(String input){
	   File file = new File(input);   
	   try{
		   Scanner in = new Scanner(file);
		   map = new TreeMap<String, Double>();
		   while(in.hasNext()){
			   String line = in.nextLine();
			   String[] data = line.split(" ");
			   map.put(data[0], Double.parseDouble(data[1]));
		   }
		   in.close();
	   }
	   catch(IOException exc){
		   System.out.println("Input file not found");
	   }
	   return map;
   	}
  
   public static Map<String, Double> readData(String input) {
       HashMap<String, Double> map = new HashMap<String, Double>();
       PriceComparator bvc = new PriceComparator(map);
       TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
       File file = new File(input);  
       try {
    	   Scanner in = new Scanner(file);
    	   while (in.hasNextLine()) {
    		   String key = in.next();
    		   double value = in.nextDouble();
    		   map.put(key, value);
    	   }
    	   sorted_map.putAll(map);
       
    	   for (Map.Entry<String,Double> entry : sorted_map.entrySet()){
    		   System.out.println(entry.getKey()+" "+ entry.getValue());
    	   } 
    	   in.close();
       }
       
       catch (FileNotFoundException e) {
    	   return null;
       }
	return sorted_map;
}
static class PriceComparator implements Comparator<String> {
       Map<String, Double> map;
       public PriceComparator(Map<String, Double> base) {
       this.map = base;
       }
       
       @Override
       public int compare(String a, String b) {
    	   if (map.get(a) < map.get(b)) {
    		   return -1;
    	   } 
    	   else if (map.get(a)> map.get(b)) {
    		   return 1;
    	   } 
    	   else {
      
    		   if (a.compareTo(b) < 0) {
    			   return -1;
    		   	}
    		   return 1;
    	   	}
       	}
       }
      
 }

public class Problem18 {
    public static void main(String[] args) {
        Map<String, Double> map = MapManager.readData("input.txt");
        if (map == null) {
            System.out.println("Input file not found.");
            return;
        }
        System.out.println(map);
    }
}