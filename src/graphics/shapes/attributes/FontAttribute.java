package graphics.shapes.attributes;

import graphics.shapes.ui.ShapesView;
import graphics.ui.View;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;

public class FontAttribute extends Attribute {
	
	public Font font;
	public static String id = "font";
	
	public FontAttribute(){
		this.font = new Font("SANS_SERIF", 9, 15);
	}
	
	public FontAttribute(Font font){
		this.font = font;
	}
	
	public Font getFont(){
		return this.font;
	}
	
	public String getId() {
		return id;
	}
	
}
