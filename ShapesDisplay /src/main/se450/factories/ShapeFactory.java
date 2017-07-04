package main.se450.factories;

import main.se450.exceptions.BadShapeException;
import main.se450.exceptions.BadDataException;
import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;
import main.se450.model.Circle;
import main.se450.model.Line;
import main.se450.model.Ship;
import main.se450.model.Square;
import main.se450.model.Triangle;
/**
 * 
 * This is factory class for IShape objects. Depending on string provided, the class creates Circle, Line, Ship, Square and Triangle objects
 * @author Azamat Abdikadirov
 * @version 1L
 * @param float nLeft, nTop, nRight and nBottom are pixel positions of points from which lines are drawn.
 * @param float nX and nY are horizal and vertical positions of to which Ship object moves
 * @param float nRotation determines degree of object rotation
 * @param int Color integer value for the color of the ship object
 * @param IStrategy iStrategy parameter which determines how object should behave when they hit the edges of the panel.
 * @throws BadShapeException
 * @throws BadDataExceptions 
 * @return IShape type
 *
 */
public class ShapeFactory
{
	private ShapeFactory()
	{
	}
	
	public static IShape makeShape(final String type, float left, float top, float right, float bottom, float x, float y, float rotation, int color, IStrategy iStrategy) throws BadShapeException, BadDataException
	{
		if ((Math.abs(x)>5)||( Math.abs(y)>5))throw new BadDataException();
		IShape iShape = null;

    	if (type.equals("Circle"))
    	{
    		iShape = new Circle(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
        else if (type.equals("Square"))
    	{
    		iShape = new Square(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Line"))
    	{
    		iShape = new Line(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Triangle"))
    	{
    		iShape = new Triangle(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else if (type.equals("Ship"))
    	{
    		iShape = new Ship(left, top, right, bottom, x, y, rotation, color, iStrategy);
    	}
    	else
    	{
    		throw new BadShapeException(type);
    	}
		
		return iShape;
	}
}
      