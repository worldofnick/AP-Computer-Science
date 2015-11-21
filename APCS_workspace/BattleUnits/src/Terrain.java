
public abstract class Terrain extends Unit {

	//boolean hasUnit = false;
	Unit unit;
	
	protected char displayCharacter;
	
	Terrain() {
		
	}

	public char getDisplayCharacter() {
		if (unit == null) {
			return displayCharacter;
		} else {
			return unit.displayCharacter;
		}
	}

	public void setDisplayCharacter(char displayCharacter) {
		this.displayCharacter = displayCharacter;
	}
	
	
}
