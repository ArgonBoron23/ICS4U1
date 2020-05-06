import becker.robots.*;

public class MeetInMiddle {

    public static void main(String[] args) {

        // creates new City
        City markham = new City();

        // obstacles
        new Wall(markham, 0, 1, Direction.WEST);
        new Wall(markham, 1, 1, Direction.WEST);
        new Wall(markham, 1, 1, Direction.SOUTH);

        // setup robots
        Robot wallE = new Robot(markham, 0, 0, Direction.SOUTH, 0);
        Robot eve = new Robot(markham, 0, 1, Direction.SOUTH, 0);

        // movement
        eve.move();
        wallE.move();
        eve.turnLeft();
        wallE.move();
        eve.move();
        wallE.turnLeft();

        // eve right turn
        for (int i = 0; i < 3; i++) {
            eve.turnLeft();
        }

        // both robots move
        wallE.move();
        eve.move();

        // right turn
        for (int i = 0; i < 3; i++) {
            eve.turnLeft();
        }

        // move
        eve.move();

    }

}