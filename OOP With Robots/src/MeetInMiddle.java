import becker.robots.*;
import becker.robots.IColor;
import becker.robots.Sim;

public class MeetInMiddle {

    public static void main(String[] args) {

        City Markham = new City();

        // obstacles
        new Wall(Markham, 0, 1, Direction.WEST);
        new Wall(Markham, 1, 1, Direction.WEST);
        new Wall(Markham, 1, 1, Direction.SOUTH);

        // setup robots
        Robot WallE = new Robot(Markham, 0, 0, Direction.SOUTH, 0);
        Robot Eve = new Robot(Markham, 0, 1, Direction.SOUTH, 0);

        // movement
        Eve.move();
        WallE.move();
        
        Eve.turnLeft();
        WallE.move();
        
        Eve.move();
        WallE.turnLeft();
       
        // right turn
        for (int i = 0; i<3; i++) {
            Eve.turnLeft();
        }

        WallE.move();

        
        Eve.move();

        // right turn
        for (int i = 0; i<3; i++) {
            Eve.turnLeft();
        }

        Eve.move();
        


    }

}