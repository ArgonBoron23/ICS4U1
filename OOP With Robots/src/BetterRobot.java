import becker.robots.*;

// define subclass BetterRobot as extension Robot
public class BetterRobot extends Robot {

	BetterRobot(City aCity, int aStreet, int anAvenue, Direction aDirection) {

		// calls constructor for four parameters
		super(aCity, aStreet, anAvenue, aDirection);

		// default label
		this.setLabel("BR");
	}

	BetterRobot(City aCity, int aStreet, int anAvenue, Direction aDirection, int numThings) {

		// calls constructor for five parameters
		super(aCity, aStreet, anAvenue, aDirection, numThings);

		// default label
		this.setLabel("BR");

	}

	// single method to turn right
	public void turnRight() {

		// takes current speed of robot
		double defaultSpeed = this.getSpeed();

		// increases robot speed to make turning faster
		this.setSpeed(defaultSpeed * 3);

		for (int i = 0; i < 3; i++) {
			this.turnLeft();
		}

		// resests back to previous speed
		this.setSpeed(defaultSpeed);
	}

	// single method to turn around
	public void turnAround() {

		// takes current speed of robot
		double defaultSpeed = this.getSpeed();

		// increases robot speed to make turning faster
		this.setSpeed(defaultSpeed * 2);

		for (int i = 0; i < 2; i++) {
			this.turnLeft();
		}

		// resests back to previous speed
		this.setSpeed(defaultSpeed);
	}

	// single method to move a set amount of spaces
	public void move(int numSpaces) {

		// moves an amount of spaces
		for (int i = 0; i < numSpaces; i++) {
			this.move();
		}
	}

}