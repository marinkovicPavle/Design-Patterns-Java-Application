package shapes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Circle {

	private int innerRadius;
	//private Color color;
	//private Color smallInsideColor = Color.BLACK;
	//private Color smallOutsideColor = Color.BLACK;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, Color outterInsideColor, Color outterOutsideColor) {
		super(center, radius);
		this.innerRadius = innerRadius;
		if(outterInsideColor == null) {
			setInsideColor(Color.BLACK);
		} else {
			setInsideColor(outterInsideColor);
		}
		if(outterOutsideColor == null) {
			setOutsideColor(Color.BLACK);
		} else {
			setOutsideColor(outterOutsideColor);
		}
		//this.smallInsideColor = smallInsideColor;
		//this.smallOutsideColor = smallOutsideColor;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	/*public void draw(Graphics g) {
		/*g.setColor(getColor());
		g.drawOval(this.getCenter().getX() - this.radius, getCenter().getY() - getRadius(), this.getRadius()*2, this.getRadius()*2);
		
		g.setColor(getInsideColor());
		g.fillOval(this.getCenter().getX()+1 - this.radius, getCenter().getY()+1 - getRadius(), (this.getRadius()-1)*2, (this.getRadius()-1)*2);/*
		
		super.draw(g);
		
		g.setColor(getSmallOutsideColor());
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		//Graphics2D g2d = (Graphics2D) g; //pravimo da bih unutrasnjost malog kruga bila transparentna
		g.setColor(getSmallInsideColor());
		
		//g2d.setComposite(AlphaComposite.SrcOver.derive(0.2f));
		//g2d.setColor(new Color(getSmallInsideColor().getRed(),getSmallInsideColor().getGreen(),getSmallInsideColor().getBlue(),125));
		g.fillOval(this.getCenter().getX()+1 - this.innerRadius, this.getCenter().getY()+1 - this.getInnerRadius(), (this.getInnerRadius()-1)*2, (this.innerRadius-1)*2);
		
		//g2d.setComposite(AlphaComposite.SrcOver.derive(0.9f)); //da vratimo transparentnost
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);
		}
		g.setColor(getSmallInsideColor());
	}*/
	
	public void draw(Graphics g) {
		Ellipse2D bigCircle = new Ellipse2D.Double(this.getCenter().getX() - this.getRadius(), this.getCenter().getY() - this.getRadius(), this.getRadius()*2, this.getRadius()*2);
		Ellipse2D smallCircle = new Ellipse2D.Double(this.getCenter().getX() - this.getInnerRadius(), this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.getInnerRadius()*2);
		Area bigArea = new Area(bigCircle);
		bigArea.subtract(new Area(smallCircle));
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(getInsideColor());
		g2d.fill(bigArea);
		g2d.setColor(getOutsideColor());
		g2d.draw(bigArea);

		//super.draw(g);
		
		/*g.setColor(getSmallOutsideColor());
		g.drawOval(this.getCenter().getX() - this.innerRadius, this.getCenter().getY() - this.getInnerRadius(), this.getInnerRadius()*2, this.innerRadius*2);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(getSmallInsideColor().getRed(),getSmallInsideColor().getGreen(),getSmallInsideColor().getBlue(), 0)); //podesavanje transparentnosti kruga sa rupom
		
		g2d.fillOval(this.getCenter().getX()+1 - this.innerRadius, this.getCenter().getY()+1 - this.getInnerRadius(), (this.getInnerRadius()-1)*2, (this.innerRadius-1)*2);
		*/
		if (isSelected()) {
			g.setColor(Color.BLUE);
			/*g.drawRect(getCenter().getX() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() + getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - getRadius() - 3, getCenter().getY() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() + getRadius() - 3, 6, 6);
			g.drawRect(getCenter().getX() - 3, getCenter().getY() - getRadius() - 3, 6, 6);*/
			g.drawRect(this.getCenter().getX() + getInnerRadius() - 3, this.getCenter().getY()-3, 6, 6);
			g.drawRect(this.getCenter().getX() - getInnerRadius() - 3, this.getCenter().getY()-3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + getInnerRadius() -3, 6, 6);
			g.drawRect(this.getCenter().getX()  - 3, this.getCenter().getY() - getInnerRadius() -3, 6, 6);
			
			g.drawRect(this.getCenter().getX() + getRadius() - 3, this.getCenter().getY()-3, 6, 6);
			g.drawRect(this.getCenter().getX() - getRadius() - 3, this.getCenter().getY()-3, 6, 6);
			g.drawRect(this.getCenter().getX() - 3, this.getCenter().getY() + getRadius() -3, 6, 6);
			g.drawRect(this.getCenter().getX()  - 3, this.getCenter().getY() - getRadius() -3, 6, 6);
		}
	}
	
	public int compareTo(Object o) {
		if (o instanceof Donut) {
			return (int) (this.area() - ((Donut) o).area());
		}
		return 0;
	}
	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return dFromCenter > innerRadius &&
				super.contains(x, y);
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return dFromCenter > innerRadius &&
				super.contains(p.getX(), p.getY());
	}
	
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*public Color getSmallInsideColor() {
		return smallInsideColor;
	}

	public void setSmallInsideColor(Color smallInsideColor) {
		this.smallInsideColor = smallInsideColor;
	}

	public Color getSmallOutsideColor() {
		return smallOutsideColor;
	}

	public void setSmallOutsideColor(Color smallOutsideColor) {
		this.smallOutsideColor = smallOutsideColor;
	}*/
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return "Donut: (" + getCenter().getX() + ", " + getCenter().getY() + "), " + "Radius="+radius+ ", Inside Color: ("+Integer.toString(super.getInsideColor().getRGB())+")" + ", Outside Color: ("+Integer.toString(super.getOutsideColor().getRGB())+")" + " Small: Radius="+innerRadius+".";
	}
	
	public Donut clone(Donut d) {
		
		d.getCenter().setX(this.getCenter().getX());
		d.getCenter().setY(this.getCenter().getY());
		d.setInnerRadius(this.getInnerRadius());
		try {
			d.setRadius(this.getRadius());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		d.setOutsideColor(this.getOutsideColor());
		d.setInsideColor(this.getInsideColor());
		
		return d;
	}
}
