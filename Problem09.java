package cse3040_hw2;

class Point{
    private double dist[]; 
    Point (double arr[]){
        this.dist = arr;
    }
    public double[] getSize(){
        return this.dist;
    }
}
class EuclideanDistance{
   public static double getDist(Point p1, Point p2){
	   if(p1.getSize().length == p2.getSize().length){
		   double res = 0;
		   for (int i= 0 ; i < p1.getSize().length; i++) 
			   res += Math.pow((p2.getSize()[i] - p1.getSize()[i]), 2); 
		   return Math.pow(res, 0.5);
		}
	   else return -1; 
   }
}
class ManhattanDistance{
	public static double getDist(Point p1, Point p2){
        if(p1.getSize().length == p2.getSize().length){
            double res = 0;
            for (int i= 0; i < p1.getSize().length; i++)             
            	res += Math.abs(p2.getSize()[i] - p1.getSize()[i]);            
            return res;
        }
        else return -1;
    }	
}
public class Problem09 {
	public static void main(String[] args) {
		Point p1 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p2 = new Point(new double[] {4.0, 5.0, 6.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] {1.0, 2.0, 3.0});
		Point p4 = new Point(new double[] {4.0, 5.0});
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}