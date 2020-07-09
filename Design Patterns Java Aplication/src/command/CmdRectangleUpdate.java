package command;

import shapes.Rectangle;

public class CmdRectangleUpdate implements Command{

	private Rectangle oldState;
	private Rectangle newState;
	private Rectangle original = new Rectangle();
	
	public CmdRectangleUpdate(Rectangle oldState, Rectangle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {	
		/*//cuvamo stare koordinate
		original.getUpperLeftPoint().setX(oldState.getUpperLeftPoint().getX()); 
		original.getUpperLeftPoint().setY(oldState.getUpperLeftPoint().getY());
		original.setHeight(oldState.getHeight());
		original.setWidth(oldState.getWidth());
		original.setInsideColor(oldState.getInsideColor());
		original.setOutsideColor(oldState.getOutsideColor());
		
		//podesavamo nove koordinate
		oldState.getUpperLeftPoint().setX(newState.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(newState.getUpperLeftPoint().getY());
		oldState.setHeight(newState.getHeight());
		oldState.setWidth(newState.getWidth());	
		oldState.setInsideColor(newState.getInsideColor());
		oldState.setOutsideColor(newState.getOutsideColor());*/
		
		original = oldState.clone(original);
		oldState = newState.clone(oldState);
	}

	@Override
	public void unexecute() {
		/*oldState.getUpperLeftPoint().setX(original.getUpperLeftPoint().getX());
		oldState.getUpperLeftPoint().setY(original.getUpperLeftPoint().getY());
		oldState.setHeight(original.getHeight());
		oldState.setWidth(original.getWidth());
		oldState.setInsideColor(original.getInsideColor());
		oldState.setOutsideColor(original.getOutsideColor());*/
		
		oldState = original.clone(oldState);
	}

}
