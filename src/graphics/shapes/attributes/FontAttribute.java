package graphics.shapes.attributes;

import java.awt.*;
import java.awt.font.FontRenderContext;

public class FontAttribute extends Attribute {
	
	public Font font;
	public Graphics2D DEFAULT_GRAPHICS;
	public static String id = "font";
	
	public FontAttribute(){

	}
	
	public FontAttribute(Font font){
		this.font = font;
	}
	
	public Rectangle getBounds(String s){
		FontRenderContext frc = DEFAULT_GRAPHICS.getFontRenderContext();
		return font.getStringBounds(s, frc).getBounds();
	}

	public String getId() {
		return id;
	}
	
}
