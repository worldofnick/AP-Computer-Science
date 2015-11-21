
public class Armor extends LandUnit{

	public String getMovementDescription() {
		return this.getName() + " " + super.getMovementDescription();
	}
	
	public String getName() {
		return "Armor";
	}
	
	public int getSpeed() {
		return 2;
	}
	
	public int getHitPoints() {
		return 2;
	}
	
	public String getCapabilityDescription() {
		return super.getCapabilityDescription() + " and blitzkreig.";
	}
	
}
