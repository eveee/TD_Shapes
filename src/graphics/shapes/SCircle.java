package graphics.shapes;

import graphics.shapes.ui.ShapeVisitor;

import java.awt.*;

public class SCircle extends Shape {
	
	private int radius;
	private Point loc;
	
	public SCircle(Point loc, int radius){
		this.loc=loc;
		this.radius=radius;
	}
	
	public int getRadius(){
		return this.radius;
	}
	
	public void setRadius(int radius){
		this.radius=radius;
	}
	
	public Point getLoc(){
		return this.loc;
	}
	
	public void setLoc(Point loc){
		this.loc=loc;
	}
	
	public void translate(int dx, int dy){
		this.loc.x=this.loc.x+dx;
		this.loc.y=this.loc.y+dy;
	}
	
	public Rectangle getBounds(){
		Rectangle bounds = new Rectangle(this.loc.x, this.loc.y, radius, radius);
		return bounds;
	}
	
	public void accept(ShapeVisitor v){
		
	}
}
