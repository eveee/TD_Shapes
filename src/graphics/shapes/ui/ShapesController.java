package graphics.shapes.ui;

import java.awt.event.MouseEvent;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.ui.Controller;

public class ShapesController extends Controller {

	public ShapesController(Object model) {
		super(model);
	}
	
	protected Shape getTarget(MouseEvent e){
		return null;
		
	}

}
