
public class Circle {
	// Fields/ Member Variables
	public double radius;
	public double circumfrence;
	public double area;
	
	public void calculate() {
		circumfrence = 2 * Math.PI * radius;
		area = Math.PI * radius * radius;
	}
	
	public String toString() {
		String result = "Radius: " + radius + 
				", Area: " + area + 
				", Circumfrence: " + circumfrence;
		return result;
	}
	
}
