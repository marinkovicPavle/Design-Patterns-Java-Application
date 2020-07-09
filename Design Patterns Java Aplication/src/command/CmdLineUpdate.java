package command;

import shapes.Line;

public class CmdLineUpdate implements Command{
	private Line oldState;
	private Line newState;
	private Line original = new Line();
	
	public CmdLineUpdate(Line oldState, Line newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		/*original.getStartPoint().setX(oldState.getStartPoint().getX());
		original.getStartPoint().setY(oldState.getStartPoint().getY());
		original.setOutsideColor(oldState.getOutsideColor());*/
		original = oldState.clone(original);
		/*oldState.getStartPoint().setX(newState.getStartPoint().getX());
		oldState.getStartPoint().setY(newState.getStartPoint().getY());
		oldState.setOutsideColor(newState.getOutsideColor());*/
		oldState = newState.clone(oldState);
	}

	@Override
	public void unexecute() {
		/*oldState.getStartPoint().setX(original.getStartPoint().getX());
		oldState.getStartPoint().setY(original.getStartPoint().getY());
		oldState.setOutsideColor(original.getStartPoint().getOutsideColor());*/
		oldState = original.clone(oldState);
	}
}
