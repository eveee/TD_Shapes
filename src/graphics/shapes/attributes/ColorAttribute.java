package graphics.shapes.attributes;

import java.awt.*;

public class ColorAttribute extends Attribute {
	
	public boolean filled;
	public boolean stroked;
	public Color filledColor;
	public Color strokedColor;
	public static String id = "color";
	
	public ColorAttribute(){
		filled = false;
		stroked = true;
		filledColor = Color.WHITE;
		strokedColor = Color.BLACK;
				
	}
	
	public ColorAttribute(boolean filled, boolean stroked, Color filledColor, Color strokedColor){
		this.filled=filled;
		this.stroked=stroked;
		this.filledColor=filledColor;
		this.strokedColor=strokedColor;
	}

	public String getId() {
		return id;
	}
	
}
