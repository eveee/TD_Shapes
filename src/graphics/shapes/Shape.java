package graphics.shapes;

import graphics.shapes.attributes.Attribute;
import graphics.shapes.attributes.ColorAttribute;
import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.ui.ShapeVisitor;

import java.awt.*;
import java.util.*;

public abstract class Shape {
	
	private Map<String, Attribute> attributes = new TreeMap<String, Attribute>();

	
	public void addAttribute(Attribute attribute){
		attributes.put(attribute.getId(), attribute);
	}
	
	public Attribute getAttribute(String id){
		return (Attribute) attributes.get(id);
	}
	
	public abstract Point getLoc();
	public abstract void setLoc(Point loc);
	public abstract void translate(int dx, int dy);
	public abstract Rectangle getBounds();
	public abstract void accept(ShapeVisitor v);
	
}
