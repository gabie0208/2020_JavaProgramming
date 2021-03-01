package cse3040_hw2;

interface Shape{
	public double areaSum();
}
class Circle implements Shape{
	private double r;
	public Circle(double r){
		this.r = r;
	}
	public double areaSum() {
		return Math.PI * r * r;
	}
}
class Square implements Shape{
	private double x;
	public Square(double x){
		this.x = x;
	}
	public double areaSum() {
		return x * x;
	}
}
class Rectangle implements Shape{
	private double w, h;
	public Rectangle(double w, double h){
		this.w = w;
		this.h = h;
	}
	public double areaSum() {
		return w * h;
	}
}
public class Problem08 {
	public static double sumArea(Shape[] arr) {
		double totalSum = 0;
		for (int i = 0; i < arr.length; ++i) {
			totalSum += arr[i].areaSum();
		}
		return totalSum;
	}
	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Square(4.0),
						new Rectangle(3.0, 4.0), new Square(5.0)};
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}
}
