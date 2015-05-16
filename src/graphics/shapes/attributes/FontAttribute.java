package graphics.shapes.attributes;

import java.awt.*;
import java.awt.font.FontRenderContext;

import javax.swing.JPanel;

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
	
	/*public Rectangle getBounds(String s){
		FontRenderContext frc = DEFAULT_GRAPHICS.getFontRenderContext();
		return font.getStringBounds(s, frc).getBounds();
	}*/

	public String getId() {
		return id;
	}
	
}
