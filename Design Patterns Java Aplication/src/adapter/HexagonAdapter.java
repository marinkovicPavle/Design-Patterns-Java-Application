package adapter;

import java.awt.Color;
import java.awt.Graphics;

import hexagon.Hexagon;
import shapes.Point;
import shapes.SurfaceShape;

public class HexagonAdapter extends SurfaceShape {
	private Hexagon hexagon;
	
	public HexagonAdapter(Point center, int r, Color insideColor, Color outsideColor) {
		this.hexagon = new Hexagon(center.getX(), center.getY(), r);
		this.hexagon.setAreaColor(insideColor);
		this.hexagon.setBorderColor(outsideColor);
	}
	
	public HexagonAdapter() {
		
	}
	
	/*public HexagonAdapter(Hexagon h, Color inside, Color outside) {
		this.hexagon = h;
		setInsideColor(inside);
		setOutsideColor(outside);
	}*/
	
	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Point center, int r, Color insideColor, Color outsideColor) {
		this.hexagon = new Hexagon(center.getX(), center.getY(), r);
		this.hexagon.setAreaColor(insideColor);
		this.hexagon.setBorderColor(outsideColor);
		hexagon.setSelected(true);
	}

	@Override
	public void moveBy(int byX, int byY) {

	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Hexagon) {
			Hexagon h = (Hexagon) o;
			return (int) (hexagon.getR() - h.getR());
		}
		else
			return 0;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}
	
	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		hexagon.setSelected(selected);
	}
	
	@Override
	public boolean isSelected() {
		return hexagon.isSelected();
	}
	
	public boolean equals(Object obj){
		if(obj instanceof HexagonAdapter){
			HexagonAdapter hexAdapter = (HexagonAdapter) obj;
			Point p1 = new Point(hexagon.getX(),hexagon.getY());
			Point p2 = new Point(hexAdapter.hexagon.getX(),hexAdapter.hexagon.getY());
			if(p1.equals(p2) && hexagon.getR() == hexAdapter.getHexagon().getR())
				return true;
			else
				return false;

		}
		else
			return false;
	}
	
	public Color getInsideColor() {
		return hexagon.getAreaColor();
	}

	public void setInsideColor(Color insideColor) {
		hexagon.setAreaColor(insideColor);
	}
	
	public Color getOutsideColor() {
		return hexagon.getBorderColor();
	}

	public void setOutsideColor(Color outsideColor) {
		hexagon.setBorderColor(outsideColor);
	}
	
	public double area() {
		return hexagon.getR() * hexagon.getR() * Math.PI;
	}
	
	public int getRadius() {
		return hexagon.getR();
	}
	
	public void setRadius(int radius) {
		hexagon.setR(radius);
	}
	
	public Point getCenter() {
		return new Point(hexagon.getX(),hexagon.getY());
	}
	
	public void setCenter(Point center) {
		hexagon.setX(center.getX());
		hexagon.setY(center.getY());
	}
	
	public String toString() {
		return "Hexagon: (" + getCenter().getX() + ", " + getCenter().getY() + "), " + "Radius="+getRadius()+", Inside Color: ("+Integer.toString(getInsideColor().getRGB())+")" + ", Outside Color: ("+Integer.toString(getOutsideColor().getRGB())+")";
	}

	@Override
	public void fill(Graphics g) {
		// TODO Auto-generated method stub
	}
	
	public HexagonAdapter clone(HexagonAdapter h) {
		
		//h.hexagon=new Hexagon(this.getCenter().getX(), this.getCenter().getY(), this.getRadius());
		h.getCenter().setX(this.getCenter().getX());
		h.getCenter().setY(this.getCenter().getY());
		h.setRadius(this.getRadius());
		h.setOutsideColor(this.getInsideColor());
		h.setInsideColor(this.getInsideColor());

		return h;
	}
	
}
