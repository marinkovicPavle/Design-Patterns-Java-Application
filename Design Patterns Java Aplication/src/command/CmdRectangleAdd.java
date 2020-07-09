package command;

import mvc.DrawingModel;
import shapes.Rectangle;

public class CmdRectangleAdd implements Command {

	private DrawingModel model;
	private Rectangle rectangle;
	
	public CmdRectangleAdd(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.add(rectangle);
	}

	@Override
	public void unexecute() {
		model.remove(rectangle);
	}

}
