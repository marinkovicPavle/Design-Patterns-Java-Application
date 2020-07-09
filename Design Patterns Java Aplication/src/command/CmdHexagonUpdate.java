package command;

import adapter.HexagonAdapter;
import hexagon.Hexagon;
import mvc.DrawingFrame;
import shapes.Point;

public class CmdHexagonUpdate implements Command {
	private HexagonAdapter oldState;
	private HexagonAdapter newState;
	private HexagonAdapter original = new HexagonAdapter();
	
	public CmdHexagonUpdate(HexagonAdapter oldState, HexagonAdapter newState) {
		this.oldState = oldState;
		this.newState = newState;
	}

	@Override
	public void execute() {

		HexagonAdapter h = new HexagonAdapter(new Point(oldState.getHexagon().getX(), oldState.getHexagon().getY()), oldState.getHexagon().getR(), oldState.getInsideColor(), oldState.getOutsideColor());;
		original.setHexagon(h.getCenter(),h.getRadius(),h.getInsideColor(),h.getOutsideColor());
		
		//original = oldState.clone(original);

		
		HexagonAdapter h1 = new HexagonAdapter(new Point(newState.getHexagon().getX(), newState.getHexagon().getY()), newState.getHexagon().getR(), newState.getInsideColor(), newState.getOutsideColor());;
		oldState.setHexagon(h1.getCenter(),h1.getRadius(),h1.getInsideColor(),h1.getOutsideColor());
		
		//oldState = newState.clone(original);

	}

	@Override
	public void unexecute() {
		
		HexagonAdapter h2 = new HexagonAdapter(new Point(original.getHexagon().getX(), original.getHexagon().getY()), original.getHexagon().getR(), original.getInsideColor(), original.getOutsideColor());;
		oldState.setHexagon(h2.getCenter(), h2.getRadius(), h2.getInsideColor(), h2.getOutsideColor());
		
		//oldState = original.clone(oldState);

	}
}
