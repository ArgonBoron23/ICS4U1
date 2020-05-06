import java.util.Vector;

public class TestingVector {

	public static void main(String[] args) {

		/*
		 * create a Vector of Integer objects. The <Integer> after the word Vector tells
		 * the Java compiler that any object stored within the Vector must be of type
		 * Integer, so all the Generics used in the Vector class will be replaced with
		 * Integer. When we call the add() method, only Integer objects can be used as
		 * parameters. When we called the get() method, the return object will be of
		 * type Integer so we can store it as an Integer variable without using casting.
		 * The Constructor's brackets () are empty since we are creating a Vector with
		 * the default initial size and incrementing behaviours
		 */
		Vector<Integer> v = new Vector<Integer>();

		/*
		 * Add values into the Vector. Notice that we do not need to create variables
		 * first and then add those variables. We can create the Objects directly as
		 * parameters inside of the method brackets. This saves some memory and runtime.
		 */
		v.add(new Integer(5));
		v.add(new Integer(10));
		v.add(new Integer(15));
		v.add(new Integer(21));

		/*
		 * Output the Vector to the console. We do not need to iterate through the
		 * Vector getting values and outputting it one at a time. The Vector has a
		 * behaviour method called toString() which will do that work on its own, and
		 * return a String representation of the Vector for us. If objects have a
		 * toString() method, the method is implicitly called whenever doing String
		 * concatenation like we are doing here.
		 */
		System.out.println("The Vector is: " + v);

		/*
		 * Get the object at index 2 (3rd position) and output to the console. Notice
		 * that we are storing the return object from the get() method directly to an
		 * Integer variable without casting. This is due to the <Integer> that we used
		 * above when creating the Vector. Also, we do not need to get the actual "int"
		 * value from within the Integer object since Integer objects have a behaviour
		 * method called toString() which will return a String representation of a
		 * Integer when doing String concatenation.
		 */
		Integer i = v.get(2);
		System.out.println("The Integer at index 2 is: " + i);

		/*
		 * Get the int value from within the Integer object and output to the console.
		 * It should output the same value as above.
		 */
		int value = i.intValue();
		System.out.println("The value of the Integer at index 2 is: " + value);

	}

}
