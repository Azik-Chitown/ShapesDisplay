package main.se450.strategies;

import java.awt.Dimension;

import main.se450.collections.Septuplet;
import main.se450.interfaces.IStrategy;

public class ReboundStrategy implements IStrategy
{
	private Dimension dimension = new Dimension(0,0);
	
	public ReboundStrategy(Dimension newDimension)
	{
		dimension.setSize(newDimension);
	}

	@Override
	public Septuplet<?,?,?,?,?,?,?> execute(float left, float top, float right, float bottom, float x, float y, int color) 
	{//TODO
		if (left < 0.0f){
			float rightMov=left;
			left=0.0f;
			right=right-rightMov;
			x=-x;
		}
		else if (right>dimension.width) {
			float movLeft=right-dimension.width;
			right=dimension.width;
			left=left-movLeft;
			x=-x;
		}
		
		if (top<0.0f){
			float movDown=top;
			top=0.0f;
			bottom=bottom-movDown;
			y=-y;
		}
		else if (bottom>dimension.height){
			float movUp=bottom-dimension.height;
			bottom=dimension.height;
			top=top-movUp;
			y=-y;
		}
		

		return new Septuplet<Float,Float,Float,Float,Float,Float,Integer>(left,top,right,bottom,x,y,color);
	}
}