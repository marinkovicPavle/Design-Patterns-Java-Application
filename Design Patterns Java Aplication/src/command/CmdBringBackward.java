package command;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdBringBackward implements Command {
	private DrawingModel model;

	
	public CmdBringBackward(DrawingModel model) {
		this.model=model;
	}

	@Override
	public void execute() {
		for(int j = 0;j<=model.getShapes().size()-1;j++){
		if(model.getShapes().get(j).isSelected()) {
			if(j==0) {
				return;
			}else {
				Shape s = model.getShapes().get(j-1);
				model.getShapes().set(j-1, model.getShapes().get(j));
				model.getShapes().set(j, s);
				//DrawingFrame.getTextAreaLog().append("Moved backward: "+model.get(j-1)+"\n");
				return;
			}
		}
	}
		//DrawingFrame.getTextAreaLog().append("\nMoved backward: ");
	}

	@Override
	public void unexecute() {
		for(int j = 0;j<=model.getShapes().size()-1;j++){
			if(model.getShapes().get(j).isSelected()) {
				if(j==model.getShapes().size()-1 ) {
					return;
				}else {
					Shape s = model.getShapes().get(j+1);
					model.getShapes().set(j+1, model.getShapes().get(j));
					model.getShapes().set(j, s);
					//DrawingFrame.getTextAreaLog().append("Moved forward: "+model.get(j+1)+"\n");
					return;
				}
			}
		}	
	}
}
