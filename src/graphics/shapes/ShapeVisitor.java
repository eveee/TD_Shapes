package graphics.shapes;

public interface ShapeVisitor {

	public void visitRectangle(SRectangle sRect);

	public void visitCircle(SCircle sCircle);

	public void visitText(SText sText);

	public void visitCollection(SCollection sColl);

}
