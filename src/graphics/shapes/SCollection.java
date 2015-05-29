package graphics.shapes;

import graphics.shapes.ui.ShapeVisitor;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape {

	public ArrayList<Shape> shapes;
	private Point loc;

	public SCollection() {
		shapes = new ArrayList<Shape>();
		loc = new Point();
	}

	public Iterator<Shape> iterator() {
		return this.shapes.iterator();
	}

	public void add(Shape shape) {
		this.shapes.add(shape);
	}

	public Point getLoc() {
		loc.x = ((SCollection) this.shapes.get(0)).getLoc().x;
		loc.y = ((SCollection) this.shapes.get(0)).getLoc().y;

		for (int i = 1; i < this.shapes.size(); i++) {
			if (((SCollection) this.shapes.get(i)).getLoc().x < this.loc.x)
				this.loc.x = ((SCollection) this.shapes.get(i)).getLoc().x;
		}

		for (int i = 1; i < this.shapes.size(); i++) {
			if (((SCollection) this.shapes.get(i)).getLoc().y > this.loc.y)
				this.loc.y = ((SCollection) this.shapes.get(i)).getLoc().y;
		}

		return loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;

	}

	public void translate(int dx, int dy) {
		this.loc.x = this.loc.x + dx;
		this.loc.y = this.loc.y + dy;

	}

	public Rectangle getBounds() {

		Rectangle bounds = new Rectangle();
		Iterator<Shape> it = this.iterator();
		bounds = bounds.union(((Shape) it.next()).getBounds());
		return bounds;

	}

	public void accept(ShapeVisitor v) {
		v.visitCollection(this);

	}
	
	public boolean isCollection() {
		return true;
	}

}
