package command;

import mvc.DrawingModel;
import shapes.Donut;

public class CmdDonutAdd implements Command {
	private DrawingModel model;
	private Donut donut;
	
	public CmdDonutAdd(DrawingModel model, Donut donut) {
		this.model = model;
		this.donut = donut;
	}

	@Override
	public void execute() {
		model.add(donut);
	}

	@Override
	public void unexecute() {
		model.remove(donut);
	}
}
