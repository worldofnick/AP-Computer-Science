// Nick Porter
public abstract class AirUnit extends Unit {
	
	
	public AirUnit(String unit, int speed, int hitPoints, String capabilityDescription) {
		super.setName(unit);
		super.setSpeed(speed);
		super.setHitPoints(hitPoints);
		// protected variable
		this.protectedmovmentDescription = unit + " Squadrons can move in the air.";
		super.setCapabilityDescription(capabilityDescription);
	}
	
}
