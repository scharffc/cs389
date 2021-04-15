/**
 * 
 */

/**
 * @author cscharff
 *
 */
public class RedShape extends ShapeDecorator {

	public RedShape(Shape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public String draw() {
		System.out.println("I am red!");
		// Very important to use super here
		return super.draw() + " red";
	}
}
