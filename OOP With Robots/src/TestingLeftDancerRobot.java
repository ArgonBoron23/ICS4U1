import becker.robots.*;

public class TestingLeftDancerRobot {

	public static void main(String[] args) {

		//creates new instances of City and Robot
		City toronto = new City();
		LeftDancerRobot dancer = new LeftDancerRobot(toronto, 5, 2, Direction.NORTH);

		// calls the new move method
		dancer.move();

	}

}