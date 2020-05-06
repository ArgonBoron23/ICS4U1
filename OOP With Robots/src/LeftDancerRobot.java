import becker.robots.*;

// define subclass BetterRobot as extension Robot
public class LeftDancerRobot extends RobotSE {

	LeftDancerRobot(City aCity, int aStreet, int anAvenue, Direction aDirection) {

		// calls constructor for four parameters
		super(aCity, aStreet, anAvenue, aDirection);

		// default label
		this.setLabel("LDR");
	}

	LeftDancerRobot(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings) {

		// calls constructor for five parameters
		super(aCity, aStreet, anAvenue, aDirection, numThings);

		// default label
		this.setLabel("LDR");

	}

	// single method to move a set amount of spaces
	public void move() {

		// turn left and move
		this.turnLeft();
		super.move();

		// turn right and move twice
		for (int j = 0; j < 2; j++) {
			this.turnRight();
			super.move();
		}

		// turn left
		this.turnLeft();

	}

}