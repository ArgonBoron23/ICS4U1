import becker.robots.*;

public class RetrieveNewspaper {

    // garbage method to turn right
    public void turnRight(Robot roboto) {
        roboto.turnLeft();
        roboto.turnLeft();
        roboto.turnLeft();
    }

    public static void main(String[] args) {

        City Markham = new City();

        Robot Karel = new Robot(Markham, 1, 2, Direction.SOUTH, 0);
        new Thing(Markham, 2, 2);

        // north wall
        new Wall(Markham, 1, 1, Direction.NORTH);
        new Wall(Markham, 1, 2, Direction.NORTH);

        // bedroom
        new Wall(Markham, 1, 2, Direction.EAST);
        new Wall(Markham, 1, 2, Direction.SOUTH);

        // west wall
        new Wall(Markham, 1, 1, Direction.WEST);
        new Wall(Markham, 2, 1, Direction.WEST);

        // outer south wall
        new Wall(Markham, 2, 1, Direction.SOUTH);

        // turn right
        for (int i = 0; i < 3; i++) {
            Karel.turnLeft();
        }

        // move to Thing
        Karel.move();
        Karel.turnLeft();
        Karel.move();
        Karel.turnLeft();
        Karel.move();

        // pick up the newspaper
        Karel.pickThing();

        // rotate 180 degrees
        for (int i = 0; i < 2; i++) {
            Karel.turnLeft();
        }

        // go back to bed
        Karel.move();
        for (int i = 0; i < 3; i++) {
            Karel.turnLeft();
        }
        Karel.move();
        for (int i = 0; i < 3; i++) {
            Karel.turnLeft();
        }
        Karel.move();

        // move back to starting orientation
        for (int i = 0; i < 3; i++) {
            Karel.turnLeft();
        }
    }

}