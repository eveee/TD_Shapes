package graphics.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Controller implements MouseListener, MouseMotionListener,
		KeyListener {

	protected Object model;
	private View view;
	protected int x;
	protected int y;

	public Controller(Object newModel) {
		model = newModel;
	}

	public void setView(View view) {
		this.view = view;
	}

	final public View getView() {
		return this.view;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public Object getModel() {
		return this.model;
	}

	public void mousePressed(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		/*
		 * this.x = e.getX(); this.y = e.getY();
		 * 
		 * Iterator<Shape> it = ((SCollection) this.model).iterator();
		 * 
		 * while (it.hasNext()){ Shape nextShape = it.next();
		 * 
		 * if (nextShape.getBounds().contains(this.x, this.y)){
		 * 
		 * if(((SelectionAttribute)
		 * nextShape.getAttribute(SelectionAttribute.id)).isSelected())
		 * ((SelectionAttribute)
		 * nextShape.getAttribute(SelectionAttribute.id)).unselect(); else
		 * ((SelectionAttribute)
		 * nextShape.getAttribute(SelectionAttribute.id)).select();
		 * 
		 * System.out.println(((SelectionAttribute)
		 * nextShape.getAttribute(SelectionAttribute.id)).isSelected());
		 * this.view.invalidate(); } }
		 */

	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent evt) {
	}

	public void mouseDragged(MouseEvent e) {
		/*
		 * int dx = e.getX() - this.x; int dy = e.getY() - this.y;
		 * 
		 * Iterator<Shape> it = ((SCollection) this.model).iterator();
		 * 
		 * while (it.hasNext()){ Shape nextShape = it.next();
		 * 
		 * if (nextShape.getBounds().contains(this.x, this.y)) {
		 * nextShape.getBounds().x += dx; nextShape.getBounds().y += dy; }
		 * 
		 * x += dx; y += dy;
		 * 
		 * }
		 */
	}

	public void keyTyped(KeyEvent evt) {
	}

	public void keyPressed(KeyEvent evt) {
	}

	public void keyReleased(KeyEvent evt) {
	}

}
