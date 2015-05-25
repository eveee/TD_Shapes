package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttribute;
import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.attributes.SelectionAttribute;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

public class Editor extends JFrame
{
	ShapesView sview;
	SCollection model;
	
	public Editor()
	{	
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		
		this.buildModel();
		
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(300,300));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
		
	}

	
	private void buildModel()
	{
		this.model = new SCollection();
		this.model.addAttribute(new SelectionAttribute());
		
		SRectangle r = new SRectangle(new Point(10,10),20,30);
		r.addAttribute(new ColorAttribute(false,true,Color.BLUE,Color.BLUE));
		r.addAttribute(new SelectionAttribute());
		this.model.add(r);
		
		SCircle c = new SCircle(new Point(100,100),100);
		c.addAttribute(new ColorAttribute(true,true,Color.orange,Color.pink));
		c.addAttribute(new SelectionAttribute());
		this.model.add(c);
		
		/*SText t= new SText(new Point(100,100),"hello");
		t.addAttribute(new ColorAttribute(false,true,Color.YELLOW,Color.BLUE));
		t.addAttribute(new FontAttribute());
		t.addAttribute(new SelectionAttribute());
		this.model.add(t);*/
		
		SCollection sc = new SCollection();
		sc.addAttribute(new SelectionAttribute());
		r= new SRectangle(new Point(20,30),30,30);
		r.addAttribute(new ColorAttribute(true,false,Color.MAGENTA,Color.BLUE));
		r.addAttribute(new SelectionAttribute());
		sc.add(r);
		c = new SCircle(new Point(150,100),20);
		c.addAttribute(new ColorAttribute(false,true,Color.BLUE,Color.DARK_GRAY));
		c.addAttribute(new SelectionAttribute());
		sc.add(c);
		this.model.add(sc);
	}
	
	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);
	}
}
