package graphics.shapes;

import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.ui.ShapeVisitor;
import graphics.shapes.ui.ShapesView;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

public class SText extends Shape {

	private String text;
	private Point loc;
	
	
	
	public SText(){
		
	}
	
	public SText(Point loc,String text){
		this.text=text;
		this.loc=loc;
	}
	
	public String getText(){
		return this.text;
	}
	
	public void setText(String text){
		this.text=text;
	}
	
	public Point getLoc() {
		return this.loc;
	}

	public void setLoc(Point loc) {
		this.loc=loc;
	}

	public void translate(int dx, int dy) {
		this.loc.x=this.loc.x+dx;
		this.loc.y=this.loc.x+dy;
	}

	public Rectangle getBounds(){
		// FontRenderContext frc = ((Graphics2D)this.view.getGraphics()).getFontRenderContext();
		return null;// ((FontAttribute) this.getAttribute(FontAttribute.id)).font.getStringBounds(this.text, frc).getBounds();
	}


	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

}
