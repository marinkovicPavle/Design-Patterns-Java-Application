package command;

import mvc.DrawingModel;
import shapes.Shape;

public class CmdBringToFront implements Command {

	private DrawingModel model;
	
	public CmdBringToFront(DrawingModel model) {
		this.model=model;
	}	
	
	@Override
	public void execute() {
		for(int j = 0;j<=model.getShapes().size()-1;j++){
			if(model.getShapes().get(j).isSelected()) {
				if(j==model.getShapes().size()-1 ) {
					//DrawingFrame.getTextAreaLog().append("Moved to front: "+model.getShapes().get(j).toString()+"\n");
					return;
				}else {
					Shape s = model.getShapes().get(j+1);
					model.getShapes().set(j+1, model.getShapes().get(j));
					model.getShapes().set(j, s);
				}
			}
		}
	}

	@Override
	public void unexecute() {
		for(int j = model.getShapes().size()-1;j>=0;j--){
			if(model.getShapes().get(j).isSelected()) {
				if(j==0) {
					//DrawingFrame.getTextAreaLog().append("Moved to back: "+model.getShapes().get(j).toString()+"\n");
					return;
				}else {
					Shape s = model.getShapes().get(j-1);
					model.getShapes().set(j-1, model.getShapes().get(j));
					model.getShapes().set(j, s);
				}
			}
		}
	}

}
