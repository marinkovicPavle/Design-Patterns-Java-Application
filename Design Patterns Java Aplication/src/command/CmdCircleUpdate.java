package command;

import shapes.Circle;

public class CmdCircleUpdate implements Command {
	private Circle oldState;
	private Circle newState;
	private Circle original = new Circle();
	
	public CmdCircleUpdate(Circle oldState, Circle newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {
		/*try {
			original.setRadius(oldState.getRadius());
		} catch (Exception e) {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		original.getCenter().setX(oldState.getCenter().getX());
		original.getCenter().setY(oldState.getCenter().getY());
		original.setInsideColor(oldState.getInsideColor());
		original.setOutsideColor(oldState.getOutsideColor());
		
		try {
			oldState.setRadius(newState.getRadius());
		} catch (Exception e) {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		oldState.getCenter().setX(newState.getCenter().getX());
		oldState.getCenter().setY(newState.getCenter().getY());
		oldState.setInsideColor(newState.getInsideColor());
		oldState.setOutsideColor(newState.getOutsideColor());*/	
		
		original = oldState.clone(original);
		oldState = newState.clone(oldState);
	}

	@Override
	public void unexecute() {
		/*try {
			oldState.setRadius(original.getRadius());
		} catch (Exception e) {
			throw new NumberFormatException("Radius has to be a value greater then 0!");
		}
		oldState.getCenter().setX(original.getCenter().getX());
		oldState.getCenter().setY(original.getCenter().getY());
		oldState.setInsideColor(original.getInsideColor());
		oldState.setOutsideColor(original.getOutsideColor());*/
		
		oldState = original.clone(oldState);
	}
}
