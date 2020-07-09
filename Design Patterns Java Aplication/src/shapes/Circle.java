package shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {

	private Point center = new Point();
	protected int radius;
	//private Color outsideColor;
	//private Color insideColor;
	
	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, Color insideColor, Color outsideColor) {
		this.center = center;
		this.radius = radius;
		setInsideColor(insideColor);
		setOutsideColor(outsideColor);
		//this.insideColor = insideColor;
		//this.outsideColor = outsideColor;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		setSelected(selected);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getOutsideColor());
		g.drawOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		
		/* g.setColor(getInsideColor());
		g.fillOval(this.getCenter().getX()+1 - this.radius, getCenter().getY()+1 - getRadius(), (this.getRadius()-1)*2, (this.getRadius()-1)*2);
		*/
		
		fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
		}
	}

	@Override
	public void fill(Graphics g) {
		g.setColor(getInsideColor());
		g.fillOval(this.getCenter().getX()+1 - this.radius, getCenter().getY()+1 - getRadius(), (this.getRadius()-1)*2, (this.getRadius()-1)*2);
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle) {
			return (this.radius - ((Circle) o).radius);
		}
		return 0;
	}
	
	public boolean contains(int x, int y) {
		return this.getCenter().distance(x, y) <= radius ;
	}
	
	public boolean contains(Point p) {
		return p.distance(p.getX(), p.getY()) <= radius;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle c = (Circle) obj;
			if (this.center.equals(c.getCenter()) && this.radius == c.getRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/*public Color getInsideColor() {
		return insideColor;
	}

	public void setInsideColor(Color insideColor) {
		this.insideColor = insideColor;
	}
	
	public Color getOutsideColor() {
		return outsideColor;
	}

	public void setOutsideColor(Color outsideColor) {
		this.outsideColor = outsideColor;
	}*/
	
	public double area() {
		return radius * radius * Math.PI;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws Exception {
		if (radius >= 0) {
			this.radius = radius;
		} else {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
	}
	
	public String toString() {
		return "Circle: (" + center.getX() + ", " + center.getY() + "), " + "Radius="+radius+ ", Inside Color: ("+Integer.toString(getInsideColor().getRGB())+")" + ", Outside Color: ("+Integer.toString(getOutsideColor().getRGB())+")";
	}
	
	public Circle clone(Circle c) {

		c.getCenter().setX(this.getCenter().getX());
		c.getCenter().setY(this.getCenter().getY());
		try {
			c.setRadius(this.getRadius());
		} catch (Exception e) {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		c.setOutsideColor(this.getOutsideColor());
		c.setInsideColor(this.getInsideColor());
		
		return c;
	}
}
