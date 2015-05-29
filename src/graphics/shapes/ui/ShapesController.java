package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttribute;
import graphics.ui.Controller;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ShapesController extends Controller {

	private ShapesView sview;
	private Object model;
	private boolean zoom;

	public ShapesController(Object model) {
		super(model);
		zoom = false;
	}

	public void setView(ShapesView sview) {
		this.sview = sview;
	}

	protected void getTarget(Shape sh) {

		if (((SelectionAttribute) sh.getAttribute(SelectionAttribute.id))
				.isSelected()) {
			if (sh.isCollection()) {
				Iterator it = ((SCollection) sh).iterator();
				while (it.hasNext())
					this.getTarget((Shape) it.next());
			}

			else
				((SelectionAttribute) sh.getAttribute(SelectionAttribute.id))
						.unselect();

		}

		else {

			if (sh.isCollection()) {
				Iterator it = ((SCollection) sh).iterator();
				while (it.hasNext())
					this.getTarget((Shape) it.next());
			}

			else
				((SelectionAttribute) sh.getAttribute(SelectionAttribute.id))
						.select();

		}

	}

	public void mouseClicked(MouseEvent e) {

		int buttonDown = e.getButton();

		if (buttonDown == MouseEvent.BUTTON1) {

			this.x = e.getX();
			this.y = e.getY();

			Iterator<Shape> it = ((SCollection) super.model).iterator();

			while (it.hasNext()) {
				Shape nextShape = it.next();

				if (nextShape.getBounds().contains(this.x, this.y)) {

					/*
					 * if (((SelectionAttribute) nextShape
					 * .getAttribute(SelectionAttribute.id)).isSelected())// {
					 * ((SelectionAttribute) nextShape
					 * .getAttribute(SelectionAttribute.id)) .unselect(); //
					 * this.sview.paintComponent(this.sview.draftman.g);} else
					 * // { ((SelectionAttribute) nextShape
					 * .getAttribute(SelectionAttribute.id)).select(); //
					 * this.sview.paintComponent(this.sview.draftman.g);}
					 * 
					 * System.out.println(((SelectionAttribute) nextShape
					 * .getAttribute(SelectionAttribute.id)).isSelected());
					 */
					
					this.getTarget(nextShape);

					this.sview.update(this.sview.getGraphics());
				}
			}

		} else if (buttonDown == MouseEvent.BUTTON3) {

			if (zoom == false) {

				Graphics2D g = (Graphics2D) this.sview.getGraphics();
				g.translate(-e.getX(), -e.getY());
				g.scale(2, 2);
				g.translate(-e.getX(), -e.getY());
				this.sview.update(g);
				zoom = true;

			} else {

				this.sview.update(this.sview.getGraphics());
				zoom = false;

			}

		}

	}

	public void mouseDragged(MouseEvent evt) {
		Iterator<Shape> it = ((SCollection) super.model).iterator();
		while (it.hasNext()) {
			Shape nextShape = it.next();

			if (nextShape.getBounds().contains(evt.getX(), evt.getY())) {
				int X = nextShape.getLoc().x;
				int Y = nextShape.getLoc().y;
				if (evt.getX() - X > 1 & evt.getY() - Y > 1) {
					nextShape.translate(evt.getX() - X, evt.getY() - Y);
				} else {
					// nextShape.translateneg(evt.getX()-X, evt.getY()-Y);
				}

			}
			System.out.printf("X: " + evt.getX() + " Y: " + evt.getY());
		}

		this.sview.update(this.sview.getGraphics());
	}

}
