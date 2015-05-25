package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttribute;
import graphics.ui.Controller;
import graphics.ui.View;

import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ShapesController extends Controller {
	
	private ShapesView sview;
	private Object model;

	public ShapesController(Object model) {
		super(model);
	}
	
	protected void getTarget(){
		
		/*Iterator<Shape> it = ((SCollection) this.model).iterator();
	     
	     while (it.hasNext()){
	    	 Shape nextShape = it.next();
	     
	      if (nextShape.getBounds().contains(super.x, super.y)){
	    	  
	    	  ((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).select();
	      	  this.sview.paintComponent(this.sview.draftman.g);
	      	  System.out.println(((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).isSelected());
	      }
	      
	     }*/
		
	}

}
