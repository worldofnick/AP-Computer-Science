
public class Bomber extends AirUnit{
	
	public String getMovementDescription() {
		return this.getName() + " "+ super.getMovementDescription();
	}
	
	public String getName() {
		return "Bomber";
	}
	
	public int getSpeed() {
		return 5;
	}
	
	public int getHitPoints() {
		return 2;
	}
	
	public String getCapabilityDescription() {
		return "Good against ships and land units.";
	}
	
}
