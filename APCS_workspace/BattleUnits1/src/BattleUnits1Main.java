import java.util.ArrayList;

// Nick Porter

public class BattleUnits1Main {

	public static void main(String[] args) {
		
		ArrayList<Unit> units = new ArrayList<Unit>();
		
		Infantry infantryDivision = new Infantry();
		units.add(infantryDivision);
		Armor armorDivision = new Armor();
		units.add(armorDivision);
		Fighter fighter = new Fighter();
		units.add(fighter);
		Bomber bomber = new Bomber();
		units.add(bomber);
		Destroyer destroyer = new Destroyer();
		units.add(destroyer);
		Cruiser cruiser = new Cruiser();
		units.add(cruiser);
		AegisCruiser aegisCruiser = new AegisCruiser();
		units.add(aegisCruiser);
		
		for(Unit u : units) {
			System.out.print(u);
		}

	}

}
