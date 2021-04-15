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
		String pizzaType = "veggie";
		PizzaFactory pf = new PizzaFactory();
		Pizza p = pf.createPizza(pizzaType);

	}

}
