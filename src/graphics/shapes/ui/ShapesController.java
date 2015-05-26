package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttribute;
import graphics.ui.Controller;
import graphics.ui.View;

import java.awt.Container;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

public class ShapesController extends Controller {
	
	private ShapesView sview;
	private Object model;

	public ShapesController(Object model) {
		super(model);
	}
	
	public void setView(ShapesView sview)
	{
		this.sview = sview;
	}
	
	public void mouseClicked(MouseEvent e){
		this.x = e.getX();
		this.y = e.getY();
		
		Iterator<Shape> it = ((SCollection) super.model).iterator();
	     
	     while (it.hasNext()){
	    	 Shape nextShape = it.next();
	     
	    	 if (nextShape.getBounds().contains(this.x, this.y)){
	    		 
	    		if(((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).isSelected())//{
	    			((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).unselect(); 
	    			//this.sview.paintComponent(this.sview.draftman.g);}
	    		else//{
	    		 	((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).select();
	    		 	//this.sview.paintComponent(this.sview.draftman.g);}
	    		 
	    		 System.out.println(((SelectionAttribute) nextShape.getAttribute(SelectionAttribute.id)).isSelected());

	    		 this.sview.paintComponent(this.sview.getGraphics());
	    	 }
	     }
		
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
