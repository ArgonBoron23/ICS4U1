import becker.robots.*;

public class ClimbEveryMountain {

	public static void main(String[] args) {

		City kathmandu = new City();

		// mountain
		new Wall(kathmandu, 3, 2, Direction.NORTH);
		new Wall(kathmandu, 3, 2, Direction.WEST);
		new Wall(kathmandu, 2, 3, Direction.WEST);
		new Wall(kathmandu, 1, 3, Direction.NORTH);
		new Wall(kathmandu, 1, 3, Direction.EAST);
		new Wall(kathmandu, 1, 3, Direction.WEST);
		new Wall(kathmandu, 2, 4, Direction.NORTH);
		new Wall(kathmandu, 2, 4, Direction.EAST);
		new Wall(kathmandu, 3, 4, Direction.EAST);

		// create new Thing
		new Thing(kathmandu, 3, 1);

		// create new Robot
		Robot climber = new Robot(kathmandu, 3, 0, Direction.EAST, 0);

		// Moves and grabs Thing
		climber.move();
		climber.pickThing();

		// climbs mountain
		climber.turnLeft();
		climber.move();

		// turn right
		for (int i = 0; i < 3; i++) {
			climber.turnLeft();
		}

		// keeps climbing mountain
		climber.move();
		climber.turnLeft();
		climber.move();
		climber.move();

		// turn right
		for (int i = 0; i < 3; i++) {
			climber.turnLeft();
		}

		// moves to plant flag Thing
		climber.move();
		climber.putThing();
		climber.move();

		// turn right
		for (int i = 0; i < 3; i++) {
			climber.turnLeft();
		}

		// goes down mountain
		climber.move();
		climber.turnLeft();
		climber.move();

		// turn right
		for (int i = 0; i < 3; i++) {
			climber.turnLeft();
		}

		// goes down mountain and turn to leave
		climber.move();
		climber.move();
		climber.turnLeft();
	}

}