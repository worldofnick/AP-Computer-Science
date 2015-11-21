
public class Cruiser extends NavalUnit{

	public String getMovementDescription() {
		return this.getName() + " "+ super.getMovementDescription();
	}
	
	public String getName() {
		return "Cruiser";
	}
	
	public int getSpeed() {
		return 2;
	}
	
	public int getHitPoints() {
		return 6;
	}
	
	public String getCapabilityDescription() {
		return "Good at carrier protection.";
	}
	
}
