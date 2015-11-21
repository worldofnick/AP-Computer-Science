// Nick Porter
public class AegisCruiser extends Cruiser{

	// 3 Levels deep
	public AegisCruiser() {
		super();
		setName("Aegis");
		super.setDisplayCharacter('c');
		this.protectedmovmentDescription = "Aegis " + this.protectedmovmentDescription;
		//super.setMovementDescription("Aegis" + " " +  + super.getMovementDescription());
		super.setCapabilityDescription("Good at carrier protection and air defense.");
		
	}
	
	// Overrides inherited method and call its.
	public void setName(String name) {
		/*
		 * Call a method that overrides a method in its superclass, 
		 * that in turn calls the overridden method.
		 */
		super.setName("Aegis " + super.getName());
	}
	
}
