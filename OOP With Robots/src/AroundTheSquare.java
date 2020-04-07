import becker.robots.*;

public class AroundTheSquare {

	public static void main(String[] args) {
		
		City markham = new City();
		
		// North Wall
		new Wall(markham, 1, 1, Direction.NORTH);
		new Wall(markham, 1, 2, Direction.NORTH);
		
		// West Wall
		new Wall(markham, 1, 1, Direction.WEST);
		new Wall(markham, 2, 1, Direction.WEST);
		
		// East Wall
		new Wall(markham, 1, 2, Direction.EAST);
		new Wall(markham, 2, 2, Direction.EAST);
		
		// South Wall
		new Wall(markham, 2, 1, Direction.SOUTH);
		new Wall(markham, 2, 2, Direction.SOUTH);

		// create Karl the Robot
		Robot karel = new Robot(markham, 0, 2, Direction.WEST, 0);
		
		// move forward two spaces and turn left.
		karel.move();
		karel.move();
		karel.turnLeft();
		
		// for the remaining three sides, move forward 3 spaces then turn left.
		for (int i=0; i<3; i++) {
			karel.move();
			karel.move();
			karel.move();
			karel.turnLeft();
		}
		
		// move forward one last time to end up on the starting space
		karel.move();		
		
	}
	
}