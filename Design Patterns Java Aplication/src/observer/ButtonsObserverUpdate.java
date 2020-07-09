package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mvc.DrawingFrame;

public class ButtonsObserverUpdate implements PropertyChangeListener{
	private DrawingFrame frame;
	
	public ButtonsObserverUpdate(DrawingFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("deleteButton")) {
			frame.getBtnDelete().setEnabled((boolean)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("editButton")) {
			frame.getBtnEdit().setEnabled((boolean)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("bringToFrontButton")) {
			frame.getBtnBringToFront().setEnabled((boolean)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("bringToBackButton")) {
			frame.getBtnBringToBack().setEnabled((boolean)evt.getNewValue());
		}	
		if(evt.getPropertyName().equals("toFrontButton")) {
			frame.getBtnToFront().setEnabled((boolean)evt.getNewValue());
		}
		if(evt.getPropertyName().equals("toBackButton")) {
			frame.getBtnToBack().setEnabled((boolean)evt.getNewValue());
		}
	}

}
