// Nick Porter
public abstract class Unit {
	
	private String name;
	private int speed;
	private int hitPoints;
	private String capabilityDescription;
	protected String  protectedmovmentDescription;
	protected char displayCharacter;
	
	public String toString() {
		String fullDescription = String.format("%s: speed %d, hit points: %d, %s %s\n", 
				name, speed, hitPoints, this.protectedmovmentDescription, capabilityDescription);
		return fullDescription;	
	}
	
public boolean canMoveOn(Terrain terrain) {
		return false;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public String getCapabilityDescription() {
		return capabilityDescription;
	}

	public void setCapabilityDescription(String capabilityDescription) {
		this.capabilityDescription = capabilityDescription;
	}

	public char getDisplayCharacter() {
		return displayCharacter;
	}

	public void setDisplayCharacter(char displayCharacter) {
		this.displayCharacter = displayCharacter;
	}
		
}
