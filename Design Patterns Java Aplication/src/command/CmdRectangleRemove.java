package command;

import mvc.DrawingModel;
import shapes.Rectangle;

public class CmdRectangleRemove implements Command {

	private DrawingModel model;
	private Rectangle rectangle;
	
	public CmdRectangleRemove(DrawingModel model, Rectangle rectangle) {
		this.model = model;
		this.rectangle = rectangle;
	}

	@Override
	public void execute() {
		model.remove(rectangle);
	}

	@Override
	public void unexecute() {
		model.add(rectangle);
	}

}
