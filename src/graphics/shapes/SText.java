package graphics.shapes;

import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.ui.ShapeVisitor;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class SText extends Shape {

	private String text;
	private Point loc;
	
	public SText(){
		
	}
	
	public SText(Point loc,String text){
		this.text=text;
		this.loc=loc;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text=text;
	}
	
	public Point getLoc() {
		return this.loc;
	}

	public void setLoc(Point loc) {
		this.loc=loc;
	}

	public void translate(int dx, int dy) {
		this.loc.x=this.loc.x+dx;
		this.loc.y=this.loc.x+dy;
	}

	public Rectangle getBounds() {
		return null;
	}

	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

}
