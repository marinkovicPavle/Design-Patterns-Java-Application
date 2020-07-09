package command;


import mvc.DrawingController;
import shapes.Shape;

public class CmdShapeSelect implements Command {
	
	private DrawingController controller;
	private Shape shape;
	//Graphics g;
	
	public CmdShapeSelect(DrawingController controller, Shape shape) {
		this.controller = controller;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		shape.setSelected(true);
		controller.getSelectedShapes().add(shape);
		//DrawingFrame.getTextAreaLog().append("Selected - "+shape+"\n");		
	}

	@Override
	public void unexecute() {
		shape.setSelected(false);
		controller.getSelectedShapes().remove(shape);
		//DrawingFrame.getTextAreaLog().append("Deselected - "+shape+"\n");		
	}

}
