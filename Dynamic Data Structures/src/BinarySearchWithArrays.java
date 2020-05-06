import java.io.*;

public class BinarySearchWithArrays {

	public static int search(int[] values, int number, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return -1;
		}
		int midIndex = (startIndex + endIndex) / 2;
		int arrayValue = values[midIndex];
		if (arrayValue == number) {
			return midIndex;
		} else if (arrayValue > number) {
			return search(values, number, startIndex, midIndex - 1);
		} else {
			return search(values, number, midIndex + 1, endIndex);
		}
	}


	public static void main(String[] args) throws Exception {

		BufferedReader filein = new BufferedReader(new FileReader("sorted.txt"));
		int[] values = new int[10000];
		int numValues = 0;
		String nextLine = filein.readLine();
		while (nextLine!=null) {
			values[numValues] = Integer.parseInt(nextLine);
			numValues++;
			nextLine = filein.readLine();
		}
		filein.close();

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Which number would you like to locate? ");
		int number = Integer.parseInt(stdin.readLine());

		int index = search(values, number, 0, numValues-1);

		if (index == -1) {
			System.out.println("Sorry, your number was not found.");
		} else {
			System.out.println("Your number was located at position " + index);
		}

	}

}