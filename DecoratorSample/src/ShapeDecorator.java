/**
 * 
 */

/**
 * @author cscharff
 *
 */
public abstract class ShapeDecorator implements Shape {
	
	private Shape decoratedShape;
	
	public ShapeDecorator(Shape newDecoratedShape){
		this.decoratedShape = newDecoratedShape;
	}
	
	@Override
	public String draw() {
		System.out.println("ShapeDecorator Class- Draw");
		return decoratedShape.draw();
	}
	
}
