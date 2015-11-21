// Nick Porter
public class NavalUnit extends Unit {

	public NavalUnit(String unit, int speed, int hitPoints, String capabilityDescription) {
		// Calls on inherited methods
		super.setName(unit);
		super.setSpeed(speed);
		super.setHitPoints(hitPoints);
		this.protectedmovmentDescription = unit + " can move on the sea.";
		super.setCapabilityDescription(capabilityDescription);
	}
	
	public boolean canMoveOn(Terrain terrain) {
		
		if (terrain instanceof SeaTerrain) {
			return true;
		} else {
			return false;
		}		
	}
}
