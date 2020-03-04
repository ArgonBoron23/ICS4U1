import java.io.*;

public class Sorted2Gen {

    public static void main(String[] args) throws Exception {

        final int numCount = 1000 / 50;
        int number;

        BufferedWriter writer = new BufferedWriter(new FileWriter("sorted2.txt"));

        writer.write("" + 1000);

        for (double a = 0; a < numCount; a += 0.02) {

            number = (int) Math.pow(2, a);
            writer.newLine();
            writer.write("" + number);
           
        }

        writer.close();
    }

}