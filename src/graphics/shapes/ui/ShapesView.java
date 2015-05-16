package graphics.shapes.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import graphics.shapes.Shape;
import graphics.ui.View;

public class ShapesView extends View{

	ShapeDraftman draftman;
	
	public ShapesView(Object model) {
		super(model);
		this.draftman = new ShapeDraftman(this);
		
	}

	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("I am printing");
		
		this.draftman.setGraphics((Graphics2D) g);
		
		Shape model = (Shape) this.getModel();
		if (model == null) return;
		
		model.accept(this.draftman);
	}
}
