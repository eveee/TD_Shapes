package graphics.shapes.attributes;

import java.awt.Color;

public class SelectionAttribute extends Attribute{

	private boolean selected;
	public static String id = "selection";
	public Color selectionColor;
	
	public SelectionAttribute(){
		this.selected = false;
		this.selectionColor = Color.orange;
	}
	
	public boolean isSelected(){
		return this.selected;
	}
	
	public void select(){
		this.selected=true;
	}
	
	public void unselect(){
		this.selected=false;
	}
	
	public void toggleSelection(){
		if (this.selected)
			this.selected=false;
		else
			this.selected=true;
	}

	public String getId() {
		return id;
	}
	
}
