package graphics.shapes;

import graphics.shapes.attributes.FontAttribute;
import graphics.shapes.ui.ShapeVisitor;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

public class SText extends Shape {

	private String text;
	private Point loc;
	private FontAttribute fa;
	private Graphics2D DEFAULT_GRAPHICS = (Graphics2D) new BufferedImage(1, 1,
			BufferedImage.TYPE_INT_ARGB).getGraphics();

	public SText() {

	}

	public SText(Point loc, String text) {
		this.text = text;
		this.loc = loc;
		this.fa = (FontAttribute) this.getAttribute(FontAttribute.id);
		if (this.fa == null)
			fa = new FontAttribute();
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Point getLoc() {
		return this.loc;
	}

	public void setLoc(Point loc) {
		this.loc = loc;
	}

	public void translate(int dx, int dy) {
		this.loc.x = this.loc.x + dx;
		this.loc.y = this.loc.y + dy;
	}

	public Rectangle getBounds() {
		FontRenderContext frc = DEFAULT_GRAPHICS.getFontRenderContext();
		Rectangle bound = this.fa.font.getStringBounds(text, frc).getBounds();
		bound.translate(bound.x, bound.y);
		return new Rectangle(loc.x, loc.y - bound.height, bound.width,
				bound.height);
	}

	public void accept(ShapeVisitor v) {
		v.visitText(this);
	}

	public boolean isCollection() {
		return false;
	}

}
