// Nick Porter
public abstract class LandUnit extends Unit {

	public LandUnit(String unit, int speed, int hitPoints, String capabilityDescription) {
		super.setName(unit);
		super.setSpeed(speed);
		super.setHitPoints(hitPoints);
		this.protectedmovmentDescription = unit + " Divisions can move on the land.";
		super.setCapabilityDescription(capabilityDescription);
	} 
	
	public boolean canMoveOn(Terrain terrain) {
		
		if (terrain instanceof LandTerrain || terrain instanceof MountainTerrain) {
			return true;
		} else {
			return false;
		}		
	}
	
}
