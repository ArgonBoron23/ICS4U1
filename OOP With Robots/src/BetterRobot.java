// import pre-made classes, including the Robot superclass
import becker.robots.*;

// define subclass BetterRobot as an extension of superclass Robot
public class BetterRobot extends Robot {

	// Constructors that override the constructors in Robot class.
	public BetterRobot(City aCity, int aStreet, int anAvenue, Direction aDirection) {
		// the reference to super(..) is the constructor in the superclass.
		super(aCity, aStreet, anAvenue, aDirection);
		this.setLabel("BR");
	}
	public BetterRobot(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings) {
		super(aCity, aStreet, anAvenue, aDirection, numThings);
		this.setLabel("BR");
	}

	// new method for Robot to be able to turn right (by turning left three times)
	public void turnRight() {
		this.turnLeft();
		this.turnLeft();
		this.turnLeft();
	}

	// new method for Robot to be able to turn around (by turning left two times)
	public void turnAround() {
		this.turnLeft();
		this.turnLeft();
	}

	// Overloading the "move" method to allow for an integer parameter
	// to indicate the number of spaces to move forward.
	public void move(int numMoves) {
		for (int i=1; i<=numMoves; i++) {
			this.move();
		}
	}

}