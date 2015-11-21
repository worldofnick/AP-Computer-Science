
public class Destroyer extends NavalUnit {

	public String getMovementDescription() {
		return this.getName() + " "+ super.getMovementDescription();
	}
	
	public String getName() {
		return "Destroyers";
	}
	
	public int getSpeed() {
		return 2;
	}
	
	public int getHitPoints() {
		return 3;
	}
	
	public String getCapabilityDescription() {
		return "Good against submarines.";
	}
	
}
