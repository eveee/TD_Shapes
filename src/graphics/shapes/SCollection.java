package graphics.shapes;

import graphics.shapes.ui.ShapeVisitor;

import java.awt.*;
import java.util.*;

public class SCollection extends Shape {

	private ArrayList<Shape> shapes;
	private Point loc;
	
	public SCollection(){
		shapes = new ArrayList<Shape>();
		loc = new Point();
	}
	
	public Iterator<Shape> iterator(){
		return this.shapes.iterator();
	}
	
	public void add(Shape shape){
		this.shapes.add(shape);
	}
	
	public Point getLoc() {
		loc.x=((SCollection) this.shapes.get(0)).getLoc().x;
		loc.y=((SCollection) this.shapes.get(0)).getLoc().y;
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().x<this.loc.x)
				this.loc.x=((SCollection) this.shapes.get(i)).getLoc().x;
		}
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().y>this.loc.y)
				this.loc.y=((SCollection) this.shapes.get(i)).getLoc().y;
		}
		
		return loc;
	}

	public void setLoc(Point loc) {
		this.loc=loc;
		
	}

	public void translate(int dx, int dy) {
		this.loc.x=this.loc.x+dx;
		this.loc.y=this.loc.y+dy;
		
	}

	public Rectangle getBounds() {
	
		int x1=((SCollection) this.shapes.get(0)).getLoc().x; int x2=((SCollection) this.shapes.get(0)).getLoc().x;
		int y1=((SCollection) this.shapes.get(0)).getLoc().y; int y2=((SCollection) this.shapes.get(0)).getLoc().y;
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().x<x1)
				x1=((SCollection) this.shapes.get(i)).getLoc().x;
		}
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().x>x2)
				x2=((SCollection) this.shapes.get(i)).getLoc().x;
		}
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().y<y1)
				y1=((SCollection) this.shapes.get(i)).getLoc().y;
		}
		
		for (int i=1; i<this.shapes.size(); i++){
			if (((SCollection) this.shapes.get(i)).getLoc().y>y2)
				y2=((SCollection) this.shapes.get(i)).getLoc().y;
		}
		
		Rectangle bounds = new Rectangle(x1,y2,x2-x1,y2-y1);
		return bounds;
		
	}

	public void accept(ShapeVisitor v) {
		v.visitCollection(this);
		
	}

}
