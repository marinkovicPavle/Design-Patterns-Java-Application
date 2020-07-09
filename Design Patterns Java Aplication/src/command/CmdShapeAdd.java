package command;

import mvc.DrawingFrame;
import mvc.DrawingModel;
import shapes.Shape;

public class CmdShapeAdd implements Command {

	private DrawingModel model;
	private Shape shape;
	
	public CmdShapeAdd(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
	}
	
	@Override
	public void execute() {
		model.add(shape);
		//DrawingFrame.getTextAreaLog().append("Added - "+shape+"\n");
	}

	@Override
	public void unexecute() {
		model.remove(shape);
		//DrawingFrame.getTextAreaLog().append("Removed - "+shape+"\n");
	}


}
