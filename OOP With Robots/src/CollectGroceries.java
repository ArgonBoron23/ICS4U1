import becker.robots.*;
import becker.robots.IColor;
import becker.robots.Sim;

public class CollectGroceries {

    public static void main(String[] args) {

        // declares the City
        City markham = new City();

        // karel's house
        new Wall(markham, 2, 3, Direction.WEST);
        new Wall(markham, 2, 3, Direction.NORTH);
        new Wall(markham, 2, 3, Direction.EAST);
        new Wall(markham, 3, 3, Direction.EAST);
        new Wall(markham, 3, 3, Direction.SOUTH);

        // setup robots and adds labels
        Robot karel = new Robot(markham, 3, 3, Direction.EAST, 0);
        Robot maria = new Robot(markham, 0, 1, Direction.WEST, 0);
        karel.setLabel("K");
        maria.setLabel("M");

        // creates Things
        new Thing(markham, 0, 0);
        new Thing(markham, 1, 0);
        new Thing(markham, 1, 1);
        new Thing(markham, 1, 2);
        new Thing(markham, 2, 2);

        // maria moves and collects first grocery
        maria.move();
        maria.pickThing();
        maria.turnLeft();

        // karel turns around and leaves house
        for (int i = 0; i < 2; i++) {
            karel.turnLeft();
        }
        karel.move();

        // maria moves and picks second grocery
        maria.move();
        maria.pickThing();
        maria.turnLeft();

        // karel moves and picks first grocery
        for (int i = 0; i < 3; i++) {
            karel.turnLeft();
        }
        karel.move();
        karel.pickThing();

        //maria moves and picks third grocery
        maria.move();
        maria.pickThing();

        //karel moves and picks second grocery
        karel.move();
        karel.pickThing();
        karel.turnLeft();

    }

}