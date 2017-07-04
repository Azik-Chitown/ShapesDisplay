package main.se450.singletons;


import java.util.ArrayList;


import main.se450.interfaces.IShape;
import main.se450.model.Shape;

public class ShapeList
{
	//You need to complete the singleton pattern, including any addtional methods, constructors, or initializers
	private ArrayList<IShape> iShapes=null;
	private static ShapeList instance;
	
	public final static ShapeList getShapeList() 
	{
		if (instance==null){
			instance=new ShapeList();
		}
		return instance;
	}
	private ShapeList(){
		iShapes =new ArrayList<IShape>();
	}
	
	public synchronized final ArrayList<IShape> getShapes()
	{
		return this.iShapes;
	}
	public void addToList(Shape shape){
		iShapes.add(shape);
	}
	

}
      