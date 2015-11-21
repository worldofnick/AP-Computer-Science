
public class Fighter extends AirUnit{

	public String getMovementDescription() {
		return this.getName() + " "+ super.getMovementDescription();
	}
	
	public String getName() {
		return "Figther";
	}
	
	public int getSpeed() {
		return 6;
	}
	
	public int getHitPoints() {
		return 1;
	}
	
	public String getCapabilityDescription() {
		return "Good at recon, ship defense, and against bombers.";
	}
	
}
