
public class Infantry extends LandUnit{

	public String getMovementDescription() {
		return this.getName() + " "+ super.getMovementDescription();
	}
	
	public String getName() {
		return "Infantry";
	}
	
	public int getSpeed() {
		return 1;
	}
	
	public int getHitPoints() {
		return 1;
	}
	
	
}
