
// Nick Porter

public class Main {

	
	public static void main(String[] args) {
		
		System.out.println(padLeft("33", 4));
		
		DrawCone();
		ThreeSideBox();
		USABox();
		FullBox();
		DrawCone();
		

	}
	
	public static String padLeft(String s, int n) {
	    return String.format("%1$" + n + "s", s);  
	}

	private static void DrawCone(){
		System.out.println("    /\\    ");
		System.out.println("   /  \\    ");
		System.out.println("  /    \\    ");
	}
	
	private static void ThreeSideBox(){
		System.out.println(" +------+");
		System.out.println(" |      |");
		System.out.println(" |      |");
	}
	
	private static void FullBox(){
		System.out.println(" +------+");
		System.out.println(" |      |");
		System.out.println(" |      |");
		System.out.println(" +------+");
	}
	
	private static void USABox(){
		System.out.println(" +------+");
		System.out.println(" |United|");
		System.out.println(" |States|");
	}
}
