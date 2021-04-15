/**
 * 
 */

/**
 * @author cscharff
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// NO NO
		// If I would have put that in a Driver class it would have been more obvious
		// SingletonClass sc = new SingletonClass();
		
		// This is how you use the class
		SingletonClass sc = SingletonClass.getInstance();

	}

}
