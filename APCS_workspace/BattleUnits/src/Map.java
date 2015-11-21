import java.util.Random;

// Creates a map using objects of type Terrain.
// Nick Porter
public class Map {
	private Terrain[][] map;
	
	Map(int height, int width) {
		generateMap(height, width);
		generateLandMass();
		generateUnits();
		
	}
	
	private void generateMap(int height, int width) {
		this.map = new Terrain[height][width];
		for (int i = 0; i < height; i ++ ) {
		    for (int j = 0; j < width; j ++ ) {
		      // Initialize each object
		      this.map[i][j] = new SeaTerrain();
		    }
		}
	}
	
	private void generateLandMass(){
		Random r = new Random();
		int height = 0;
		int width = 0;
		int xOrigin = 0;
		int yOrigin = 0;
		
		for (int numOfLandMass = 0; numOfLandMass < 2; numOfLandMass++) {
			// Generate random starting point, height and width.
			height = r.nextInt(9) + 3;
			width = r.nextInt(12) + 5;
			xOrigin = r.nextInt(this.map[0].length);
			yOrigin = r.nextInt(this.map.length) + 2;
	
			for (int i = 0; i < height; i++) {
				boolean hasMountains = false;
				// Only have land mass on land 4 or taller and 5 or wider.
				if (height >= 4 && width >= 5) {
					// Only a chance of mountains.
					int mountains = r.nextInt(5);
					if (mountains == 4) {
						hasMountains = true;
					}
				}
				
				if (hasMountains) {
					setTerrain(yOrigin - i, xOrigin, true);
					setTerrain(yOrigin - i, xOrigin + 1, true);
					setTerrain(yOrigin - i, xOrigin - 1, true);
				} else {
					setTerrain(yOrigin - i, xOrigin, false);
				}
				// Add land to the left
				for (int j = 1; j < width / 2; j++) {
						// Adds mountains to the row above.
						if (hasMountains) {
							setTerrain(yOrigin - i + 1, xOrigin + j - 1, true);
							setTerrain(yOrigin - i + 1, xOrigin + j + 1, true);
							setTerrain(yOrigin - i + 1, xOrigin - j , true);
						} else {
							setTerrain(yOrigin - i, xOrigin - j, false);
						}
				}
				// Add land to the left
				for (int j = 1; j < width / 2; j++) {

						if (hasMountains) {
							setTerrain(yOrigin - i + 1, xOrigin + j - 1, true);
							setTerrain(yOrigin - i + 1, xOrigin + j + 1, true);
							setTerrain(yOrigin - i, xOrigin + j, true);
							
							//this.map[yOrigin - i + 1][xOrigin + j - 1] = new MountainTerrain();
							//this.map[yOrigin - i + 1][xOrigin + j + 1] = new MountainTerrain();
							//this.map[yOrigin - i][xOrigin + j] = new MountainTerrain();
						} else {
							setTerrain(yOrigin - i, xOrigin + j, false);
							//this.map[yOrigin - i][xOrigin + j] = new LandTerrain();
						}
				}

				int widthGen = r.nextInt(4);
				if (widthGen == 1) {
					width++;
				} else if (widthGen == 2) {
					width--;
				} else if (widthGen == 3) {
					width = width + 2;
				} else if (widthGen == 4) {
					width = width - 2;
				}
			}
		}
	}
	
	public void printMap() {
		
		for (int i = 0; i < this.map.length; i ++ ) {
		    for (int j = 0; j < this.map[i].length; j ++ ) {
		     System.out.print(this.map[i][j].getDisplayCharacter());
		    }
		    System.out.println();
		  }
	}

	public void generateUnits() {
		Random r = new Random();
		final int numberOfFighters = r.nextInt(4);
		for (int i = 0; i < numberOfFighters; i++) {
			int x = r.nextInt(this.map[0].length);
			int y = r.nextInt(this.map.length);
			// Can move anywhere
			this.map[y][x].unit = new Fighter();
		}
		
		final int numberOfBombers = r.nextInt(4);
		for (int i = 0; i < numberOfBombers; i++) {
			int x = r.nextInt(this.map[0].length);
			int y = r.nextInt(this.map.length);
			// Can move anywhere
			this.map[y][x].unit = new Bomber();
		}
		
		final int numberOfCruisers = r.nextInt(3);
		for (int i = 0; i < numberOfCruisers; i++) {
			boolean unitCreated = false;
			while (!unitCreated) {
				int x = r.nextInt(this.map[0].length);
				int y = r.nextInt(this.map.length);
				NavalUnit cruiser = new Cruiser();
				if (cruiser.canMoveOn(this.map[y][x])) {
					this.map[y][x].unit = cruiser;
					unitCreated = true;
				}
			}
		}
		
		final int numberOfAegisCruisers = r.nextInt(4);
		for (int i = 0; i < numberOfAegisCruisers; i++) {
			boolean unitCreated = false;
			while (!unitCreated) {
				int x = r.nextInt(this.map[0].length);
				int y = r.nextInt(this.map.length);
				NavalUnit aegisCruiser = new AegisCruiser();
				if (aegisCruiser.canMoveOn(this.map[y][x])) {
					this.map[y][x].unit = aegisCruiser;
					unitCreated = true;
				}
			}
		}
		
		final int numberOfDestroyers = r.nextInt(4);
		for (int i = 0; i < numberOfDestroyers; i++) {
			boolean unitCreated = false;
			while (!unitCreated) {
				int x = r.nextInt(this.map[0].length);
				int y = r.nextInt(this.map.length);
				NavalUnit destroyer = new Destroyer();
				if (destroyer.canMoveOn(this.map[y][x])) {
					this.map[y][x].unit = destroyer;
					unitCreated = true;
				}
			}
		}
		
		final int numberOfArmorDivisions = r.nextInt(4);
		for (int i = 0; i < numberOfArmorDivisions; i++) {
			boolean unitCreated = false;
			while (!unitCreated) {
				int x = r.nextInt(this.map[0].length);
				int y = r.nextInt(this.map.length);
				LandUnit armorDivision = new ArmorDivision();
				if (armorDivision.canMoveOn(this.map[y][x])) {
					this.map[y][x].unit = armorDivision;
					unitCreated = true;
				}
			}
		}
		
		final int numberOfInfantryDivision = r.nextInt(7);
		for (int i = 0; i < numberOfInfantryDivision; i++) {
			boolean unitCreated = false;
			while (!unitCreated) {
				int x = r.nextInt(this.map[0].length);
				int y = r.nextInt(this.map.length);
				LandUnit infantryDivision = new InfantryDivision();
				if (infantryDivision.canMoveOn(this.map[y][x])) {
					this.map[y][x].unit = infantryDivision;
					unitCreated = true;
				}
			}
		}
	}
	
	public Terrain[][] getMap() {
		return map;
	}

	public void setMap(Terrain[][] map) {
		this.map = map;
	}

	public void setTerrain(int y, int x, boolean mountain) {
		
		if (y > this.map.length - 1 || y < 0 || x > this.map[0].length - 1 || x < 0) {
			// Out of bounds
		} else {
			if (mountain) {
				this.map[y][x] = new MountainTerrain();
			} else {
				this.map[y][x] = new LandTerrain();
			}
		}
	}
}


