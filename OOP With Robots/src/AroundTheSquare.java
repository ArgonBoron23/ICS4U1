import becker.robots.*;

public class AroundTheSquare {

	public static void main(String[] args) {

		City markham = new City();

		// north Wall
		new Wall(markham, 1, 1, Direction.NORTH);
		new Wall(markham, 1, 2, Direction.NORTH);

		// west Wall
		new Wall(markham, 1, 1, Direction.WEST);
		new Wall(markham, 2, 1, Direction.WEST);

		// east Wall
		new Wall(markham, 1, 2, Direction.EAST);
		new Wall(markham, 2, 2, Direction.EAST);

		// south Wall
		new Wall(markham, 2, 1, Direction.SOUTH);
		new Wall(markham, 2, 2, Direction.SOUTH);

		// create new robot
		Robot ozai = new Robot(markham, 0, 2, Direction.WEST, 0);

		// move forward
		for (int i = 0; i < 2; i++) {
			ozai.move();
		}

		// turn to move south
		ozai.turnLeft();

		// move forward
		for (int i = 0; i < 3; i++) {
			ozai.move();
		}

		// turn to move east
		ozai.turnLeft();

		// move forward
		for (int i = 0; i < 3; i++) {
			ozai.move();
		}

		// turn to move north
		ozai.turnLeft();

		// move forward
		for (int i = 0; i < 3; i++) {
			ozai.move();
		}

		// turn to move west
		ozai.turnLeft();

		// move forward to starting position
		ozai.move();
	}

}