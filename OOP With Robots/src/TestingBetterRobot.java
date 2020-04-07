import becker.robots.*;

public class TestingBetterRobot {

	public static void main(String[] args) {
		
		City toronto = new City(10, 10);
		BetterRobot bob = new BetterRobot(toronto, 5, 5, Direction.NORTH);

		bob.move(2);
		bob.turnRight();
		bob.move(3);
		bob.turnRight();
		bob.move(4);
		bob.turnRight();
		bob.move(5);
		bob.turnRight();
		bob.turnLeft();
		
	}

}