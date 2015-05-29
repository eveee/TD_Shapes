package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttribute;
import graphics.shapes.attributes.SelectionAttribute;
import graphics.ui.Controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;

public class ShapeDraftman implements ShapeVisitor {

	ShapesView sview;
	Graphics2D g;
	private static final ColorAttribute DEFAULT_COLOR_ATTRIBUTES = new ColorAttribute();
	private static final SelectionAttribute DEFAULT_SELECTION_ATTRIBUTES = new SelectionAttribute();

	public ShapeDraftman(ShapesView sview) {
		this.sview = sview;
		this.g = (Graphics2D) this.sview.getGraphics();
	}

	public void visitRectangle(SRectangle r) {
		Rectangle bounds = r.getBounds();
		ColorAttribute color = (ColorAttribute) r
				.getAttribute(ColorAttribute.id);
		SelectionAttribute selection = (SelectionAttribute) r
				.getAttribute(SelectionAttribute.id);

		if (color == null)
			color = DEFAULT_COLOR_ATTRIBUTES;
		if (selection == null)
			selection = DEFAULT_SELECTION_ATTRIBUTES;

		if (color.filled) {
			this.g.setColor(color.filledColor);
			this.g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
		}

		if (selection.isSelected()){
			this.drawHandler(bounds);
			this.g.setColor(selection.selectionColor);
		}
		else if (color.stroked)
			this.g.setColor(color.strokedColor);

		this.g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
		
	}

	public void visitCircle(SCircle c) {
		Rectangle bounds = c.getBounds();
		ColorAttribute color = (ColorAttribute) c
				.getAttribute(ColorAttribute.id);
		SelectionAttribute selection = (SelectionAttribute) c
				.getAttribute(SelectionAttribute.id);

		if (color == null)
			color = DEFAULT_COLOR_ATTRIBUTES;
		if (selection == null)
			selection = DEFAULT_SELECTION_ATTRIBUTES;

		if (color.filled) {
			this.g.setColor(color.filledColor);
			this.g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
		}

		if (selection.isSelected()){
			this.drawHandler(bounds);
			this.g.setColor(selection.selectionColor);
		}
		else if (color.stroked)
			this.g.setColor(color.strokedColor);

		this.g.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	public void visitText(SText t) {
		Rectangle bounds = t.getBounds();
		ColorAttribute color = (ColorAttribute) t
				.getAttribute(ColorAttribute.id);
		SelectionAttribute selection = (SelectionAttribute) t
				.getAttribute(SelectionAttribute.id);

		if (color == null)
			color = DEFAULT_COLOR_ATTRIBUTES;
		if (selection == null)
			selection = DEFAULT_SELECTION_ATTRIBUTES;

		if (color.filled) {
			this.g.setColor(color.filledColor);
			this.g.fillRect(t.getLoc().x - 2, t.getLoc().y - bounds.height,
					bounds.width + 2, bounds.height + 2);

			if (selection.isSelected()) {
				this.drawHandler(new Rectangle(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2));
				this.g.setColor(selection.selectionColor);
				this.g.drawRect(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);

			} else if (color.stroked) {
				this.g.setColor(color.strokedColor);
				this.g.drawRect(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);

			} else {
				this.g.setColor(color.strokedColor);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);
			}

		} else {

			if (selection.isSelected()) {
				this.drawHandler(new Rectangle(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2));
				this.g.setColor(selection.selectionColor);
				this.g.drawRect(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);

			} else if (color.stroked) {
				this.g.setColor(color.strokedColor);
				this.g.drawRect(t.getLoc().x - 2, t.getLoc().y - bounds.height,
						bounds.width + 2, bounds.height + 2);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);

			} else {
				this.g.setColor(color.strokedColor);
				this.g.drawString(t.getText(), t.getLoc().x, t.getLoc().y);
			}

		}

	}

	public void visitCollection(SCollection coll) {
		/*SelectionAttribute selection = (SelectionAttribute) coll.getAttribute(SelectionAttribute.id);
		Iterator<Shape> it = coll.iterator();
		if (selection.isSelected()) {
			while(it.hasNext())
				((SelectionAttribute) it.next().getAttribute(SelectionAttribute.id)).select();
		}
		*/
		/*else{
			Iterator<Shape> it = coll.iterator();
			while(it.hasNext())
				((SelectionAttribute) it.next().getAttribute(SelectionAttribute.id)).unselect();
			this.sview.invalidate();
		}
		*/
		Iterator<Shape> ite = coll.iterator();
		while (ite.hasNext())
			ite.next().accept(this);
	}

	public void drawHandler(Rectangle bounds) {
		this.g.setColor(Color.BLACK);
		this.g.drawRect(bounds.x-5, bounds.y-5, 5, 5);
		this.g.drawRect(bounds.x+bounds.width, bounds.y+bounds.height, 5, 5);
	}

	public void setGraphics(Graphics2D g) {

		this.g = g;
	}

	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}
}
