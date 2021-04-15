/**
 * 
 */

/**
 * @author cscharff
 *
 */
public class SingletonClass {
	
	private static SingletonClass uniqueInstance;

	// private constructor
	private SingletonClass(){
		
	}
	
	// return the unique instance or create it if it does not exist
	public static SingletonClass getInstance() {
		if (uniqueInstance == null) {
			return uniqueInstance;
		}
	return new SingletonClass();
	}

}
