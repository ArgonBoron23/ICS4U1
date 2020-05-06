import becker.robots.*;

public class RetrieveNewspaper {

    public static void main(String[] args) {

        // creates new City
        City markham = new City();

        // creates new Robot
        Robot karel = new Robot(markham, 1, 2, Direction.SOUTH, 0);

        // places new Thing
        new Thing(markham, 2, 2);

        // north wall
        new Wall(markham, 1, 1, Direction.NORTH);
        new Wall(markham, 1, 2, Direction.NORTH);

        // bedroom
        new Wall(markham, 1, 2, Direction.EAST);
        new Wall(markham, 1, 2, Direction.SOUTH);

        // west wall
        new Wall(markham, 1, 1, Direction.WEST);
        new Wall(markham, 2, 1, Direction.WEST);

        // outer south wall
        new Wall(markham, 2, 1, Direction.SOUTH);

        // turn right
        for (int i = 0; i < 3; i++) {
            karel.turnLeft();
        }

        // move to Thing
        karel.move();
        karel.turnLeft();
        karel.move();
        karel.turnLeft();
        karel.move();

        // pick up the newspaper
        karel.pickThing();

        // rotate 180 degrees
        for (int i = 0; i < 2; i++) {
            karel.turnLeft();
        }

        // go back to bed
        karel.move();
        for (int i = 0; i < 3; i++) {
            karel.turnLeft();
        }
        karel.move();
        for (int i = 0; i < 3; i++) {
            karel.turnLeft();
        }
        karel.move();

        // move back to starting orientation
        for (int i = 0; i < 3; i++) {
            karel.turnLeft();
        }
    }

}