package mvc;

import java.util.ArrayList;
import java.util.List;

import shapes.Shape;

public class DrawingModel {
	
private List<Shape> shapes = new ArrayList<Shape>();
	
	public List<Shape> getShapes() {
		return shapes;
	}

	public void add(Shape s) {
		shapes.add(s);
	}
	
	public void remove(Shape s) {
		shapes.remove(s);
	}
	
	public Shape get(int i) {
		return shapes.get(i);
	}

}
