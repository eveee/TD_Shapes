package graphics.shapes.ui;

import java.awt.Graphics2D;
import java.awt.Rectangle;


import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.Attribute;
import graphics.shapes.attributes.ColorAttribute;
import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.attributes.SelectionAttribute;
import graphics.ui.Controller;

public class ShapeDraftman implements ShapeVisitor {
	
	ShapesView sview;
	Graphics2D g;
	private static final ColorAttribute DEFAULT_COLOR_ATTRIBUTES = new ColorAttribute();
	private static final FontAttribute DEFAULT_FONT_ATTRIBUTES = new FontAttribute();	
	private static final SelectionAttribute DEFAULT_SELECTION_ATTRIBUTES = new SelectionAttribute();
	
	public ShapeDraftman(ShapesView sview){
		this.sview = sview;
		this.g = (Graphics2D) this.sview.getGraphics();
	}
	
	public void visitRectangle(SRectangle r) {
		Rectangle bounds = r.getBounds();
		ColorAttribute color = (ColorAttribute) r.getAttribute(ColorAttribute.id);
		SelectionAttribute selection = (SelectionAttribute) r.getAttribute(SelectionAttribute.id);
		
		if (color == null) color = DEFAULT_COLOR_ATTRIBUTES;
		if (selection == null) selection = DEFAULT_SELECTION_ATTRIBUTES;
		
		if (color.filled) {
			this.g.setColor(color.filledColor);
			this.g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}
		
		if (selection.isSelected()) 
			this.g.setColor(selection.selectionColor);
		else if (color.stroked) 
			this.g.setColor(color.strokedColor);
		
		this.g.drawRect(bounds.x,bounds.y,bounds.width,bounds.height);
		
	}

	public void visitCircle(SCircle c) {
		c.accept(this);
	}

	public void visitText(SText t) {
		t.accept(this);
		
	}

	public void visitCollection(SCollection coll) {
		Iterator<Shape> it = coll.iterator();
		while (it.hasNext()) it.next().accept(this);
	}
	
	public void drawHandler(Rectangle bounds){
		
	}

	public void setGraphics(Graphics2D g) {
		
		this.g = g;
	}

	
	public Controller defaultController(Object model){
		return new ShapesController(model);
	}
}
