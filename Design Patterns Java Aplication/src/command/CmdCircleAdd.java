package command;

import mvc.DrawingModel;
import shapes.Circle;

public class CmdCircleAdd implements Command {
	private DrawingModel model;
	private Circle circle;
	
	public CmdCircleAdd(DrawingModel model, Circle circle) {
		this.model = model;
		this.circle = circle;
	}

	@Override
	public void execute() {
		model.add(circle);
	}

	@Override
	public void unexecute() {
		model.remove(circle);
	}
}
