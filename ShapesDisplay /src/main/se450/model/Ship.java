package main.se450.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import main.se450.interfaces.IShape;
import main.se450.interfaces.IStrategy;

/**
 * 
 * This constructs a Shape object called Ship. The Object is created by drawing 4 consecutive line objects.  
 * @author Azamat Abdikadirov
 * @version 1L
 * @param float nLeft, nTop, nRight and nBottom are pixel positions of points from which lines are drawn.
 * @param float nX and nY are horizal and vertical positions of to which Ship object moves
 * @param float nRotation determines degree of object rotation
 * @param int Color integer value for the color of the ship object
 * @param IStrategy iStrategy parameter which determines how object should behave when they hit the edges of the panel.
 * @throws BadShapeException
 * @return 4 consecutive Line objects  
 *    
 */
public class Ship extends Shape
{
	//Read only pattern
	  private ArrayList<IShape> sides = new ArrayList<IShape>(4);

	    private final static int SIDE_ONE  = 0;
	    private final static int SIDE_TWO  = 1;
	    private final static int SIDE_THREE= 2;
	    private final static int SIDE_FOUR=  3;
	    
	public Ship(float nLeft, float nTop, float nRight, float nBottom, float nX, float nY, float nRotation, int nColor, final IStrategy iStrategy)
	{
		super(nLeft, nTop, nRight, nBottom, nX, nY, nRotation, nColor, iStrategy);
		createLines();


    	//TODO
    }

    public float getMidpointX()
    {
    	
    	return  ((getRight() + getLeft()) * 0.5f);
    }	
	
    public float getMidpointY()
    
    {
    	return ((getTop() + getBottom()) * 0.5f);
    	
    }

	
	@Override
	public void draw(Graphics graphics) 
	{
        Iterator<IShape> iSides = sides.iterator();
        while (iSides.hasNext())
        {
            iSides.next().draw(graphics);
        }
    
    //TODO - add other methods

	}
	 @Override
	    public void move(float x, float y)
	    {
	        super.move(x, y);

	        createLines();
	    }

	    @Override
	    public void move()
	    {
	        super.move();

	        createLines();
	    }
	    
	    @Override
	    public void strategicmove()
	    {
	        super.strategicmove();

	        createLines();
	    }
	    
	 private void createLines()
	    {
	        sides.clear();

	        sides.add(SIDE_ONE, new Line(getLeft(),     getBottom(), getMidpointX(),    getTop(), getX(), getY(), getRotation(), getColor(), getStrategy()));
	        sides.add(SIDE_TWO,   new Line(getLeft(),     getBottom(), getMidpointX(), getMidpointY   (), getX(), getY(), getRotation(), getColor(), getStrategy()));
	        sides.add(SIDE_THREE,  new Line(getMidpointX(), getTop(),    getRight(),    getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
	        sides.add(SIDE_FOUR,  new Line(getMidpointX(), getMidpointY(),    getRight(),    getBottom(), getX(), getY(), getRotation(), getColor(), getStrategy()));
	    }
}
    