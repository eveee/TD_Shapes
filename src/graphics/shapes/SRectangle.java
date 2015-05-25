package graphics.shapes;

import graphics.shapes.ui.ShapeVisitor;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {
	
	
	private Rectangle rect;
	
	public SRectangle(){

		this.rect = new Rectangle();
	}
	
	public SRectangle(Point loc,int width,int height){
		Dimension d=new Dimension(width,height);
		this.rect=new Rectangle(loc,d);
		
	}
	
	public Rectangle getRect(){
		return this.rect;
	}
	
	public Point getLoc(){
		Point loc = new Point();
		loc.x=this.rect.x;
		loc.y=this.rect.y;
		return loc;
	}
	
	public void setLoc(Point loc){
		this.rect.x=loc.x;
		this.rect.y=loc.y;
	}
	
	public void translate(int dx, int dy){
		this.rect.x=this.rect.x+dx;
		this.rect.y=this.rect.y+dy;
	}
	
	public Rectangle getBounds(){
		return (Rectangle) this.rect.clone();
	}
	
	
	public void accept(ShapeVisitor v){
		v.visitRectangle(this);
	}
}
