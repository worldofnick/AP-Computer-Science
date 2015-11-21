
public class MainReturnValues {
// Nick Porter
	public static void main(String[] args) {
		
		printResult();
	}
	
	private static double printCone(double height, double radius ){
		double coneFormula = 1.0 / 3.0  * Math.PI * Math.pow(radius, 2) * height;
		System.out.print("Height: " + (int) height + " Radius: " + (int)radius + ": " + "Cone Volume: " +coneFormula + ", ");
		return coneFormula;
	}
	
	private static double printCylinder(double height, double radius ){
		double cylinderFormula = Math.PI * Math.pow(radius, 2) * height;
		System.out.print("Cylinder Volume: " + cylinderFormula);
		return cylinderFormula;
	}
	
	private static void printResult(){
		for (int height = 10; height <= 20; height = height + 5) {
			for (int radius = 10; radius <= 30; radius = radius + 10) {
				printCone(height, radius);
				printCylinder(height ,radius);
				System.out.println();
			}
		}
	}

}

/* 
Height: 10 Radius: 10: Cone Volume: 1047.1975511965977, Cylinder Volume: 3141.5926535897934
Height: 10 Radius: 20: Cone Volume: 4188.790204786391, Cylinder Volume: 12566.370614359173
Height: 10 Radius: 30: Cone Volume: 9424.77796076938, Cylinder Volume: 28274.333882308136
Height: 15 Radius: 10: Cone Volume: 1570.7963267948965, Cylinder Volume: 4712.38898038469
Height: 15 Radius: 20: Cone Volume: 6283.185307179586, Cylinder Volume: 18849.55592153876
Height: 15 Radius: 30: Cone Volume: 14137.166941154068, Cylinder Volume: 42411.50082346221
Height: 20 Radius: 10: Cone Volume: 2094.3951023931954, Cylinder Volume: 6283.185307179587
Height: 20 Radius: 20: Cone Volume: 8377.580409572782, Cylinder Volume: 25132.741228718347
Height: 20 Radius: 30: Cone Volume: 18849.55592153876, Cylinder Volume: 56548.66776461627
*/