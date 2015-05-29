package graphics.shapes.ui;

import graphics.shapes.Shape;
import graphics.ui.View;

import java.awt.Graphics;
import java.awt.Graphics2D;

@SuppressWarnings("serial")
public class ShapesView extends View {

	ShapeDraftman draftman;
	private ShapesController scontroller;

	public ShapesView(Object model) {
		super(model);
		this.draftman = new ShapeDraftman(this);
		this.scontroller = new ShapesController(model);
		this.scontroller.setView(this);
		this.addMouseListener(this.scontroller);
		this.addMouseMotionListener(this.scontroller);
		this.addKeyListener(this.scontroller);

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("I am printing");

		this.draftman.setGraphics((Graphics2D) g);

		Shape model = (Shape) this.getModel();
		if (model == null)
			return;

		model.accept(this.draftman);
	}

}
