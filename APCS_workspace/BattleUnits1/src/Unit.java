
public abstract class Unit {

	public String getName() {
		return "";
	}
	
	public int getSpeed() {
		return 0;
	}
	
	public int getHitPoints() {
		return 0;
	}
	
	public String getMovementDescription() {
		return "";
	}
	
	public String getCapabilityDescription() {
		return "";
	}
	
	public String toString() {
		String fullDescription = String.format("%s: speed %d, hit points: %d, %s %s\n", 
				this.getName(), this.getSpeed(), this.getHitPoints(), this.getMovementDescription(), this.getCapabilityDescription());
		return fullDescription;
		
	}
}
