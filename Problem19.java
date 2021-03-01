package mp2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class MapManager extends TreeMap{
   private static Map<String, Double> map = null;
   public static Map ReadData(String filename){
   try{
   Scanner input = new Scanner(new File(filename));
   map = new TreeMap<String, Double>();
   while(input.hasNext()){
   String line = input.nextLine();
   String[] data = line.split(" ");
   map.put(data[0], Double.parseDouble(data[1]));
   }
   input.close();
   }
   catch(IOException exc){
   System.out.println("Input file not found");
   }
   return map;
   }
   public static void writeData(String filename){
   try{
   PrintWriter out = new PrintWriter(new File(filename));
   String outStr = "";
   for(Map.Entry<String, Double> node : map.entrySet()){
   outStr += node.getKey() + " " + node.getValue() + "\n";
   }
   out.write(outStr);
   out.close();
   }
   catch(FileNotFoundException exc){
   System.out.println("File not Found!");
   }
   }
  
   public static Map<String, Double> readData(String fileName) {
       HashMap<String, Double> map = new HashMap<String, Double>();
       PriceComparator bvc = new PriceComparator(map);
       TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
       try {
       Scanner input = new Scanner(new File(fileName));
       while (input.hasNextLine()) {
       String key = input.next();
       double value = input.nextDouble();
       map.put(key, value);
       }
       sorted_map.putAll(map);
       
       @Override String toString{
    	   StringBuffer res = new StringBuffer();
       for (Map.Entry<String,Double> entry : sorted_map.entrySet())
       {
       res.append( entry.getKey()+" "+ entry.getValue());
       }
       
       }
       res.close();
       } catch (IOException e) {

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
       } else if (map.get(a)> map.get(b)) {
       return 1;
       } else {
      
       if (a.compareTo(b) < 0) {
       return -1;
       }
       return 1;
       }// returning 0 would merge keys
       }
       }
      


       }
public class Problem19 {
   public static void main(String args[]) {
       Map<String,Double> map=MapManager.readData("input.txt");

       if(map == null) {

       System.out.println("Input file not found.");

       return;
       }
       System.out.println(map);
}
}