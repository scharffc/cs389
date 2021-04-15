/**
 * 
 */

/**
 * @author cscharff
 *
 */
public class PizzaFactory {
	
	public Pizza createPizza(String type) {
		if (type.contentEquals("cheese")) {
			return new PizzaCheese();
		} 
		if (type.contentEquals("veggie")) {
			return new PizzaVeggie();
		} 
		return null;		
	}

}
