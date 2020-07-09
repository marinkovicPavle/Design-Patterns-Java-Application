package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ButtonsObserver {
	private boolean deleteButtonActivated;
	private boolean editButtonActivated;
	private boolean bringToFrontButtonActivated;
	private boolean bringToBackButtonActivated;
	private boolean toBackButtonActivated;
	private boolean toFrontButtonActivated;
	
	private PropertyChangeSupport propertyChangeSupport;
	
	public ButtonsObserver() {
		propertyChangeSupport = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		propertyChangeSupport.addPropertyChangeListener(pcl);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener pcl) {
		propertyChangeSupport.removePropertyChangeListener(pcl);
	}
	
	public void setDeleteButtonActivated(boolean deleteButtonActivated) {
		propertyChangeSupport.firePropertyChange("deleteButton", this.deleteButtonActivated, deleteButtonActivated);
		this.deleteButtonActivated = deleteButtonActivated;
	}

	public void setEditButtonActivated(boolean editButtonActivated) {
		propertyChangeSupport.firePropertyChange("editButton", this.editButtonActivated, editButtonActivated);
		this.editButtonActivated = editButtonActivated;
	}
	
	public void setBringToFrontButtonActivated(boolean bringToFrontButtonActivated) {
		propertyChangeSupport.firePropertyChange("bringToFrontButton", this.bringToFrontButtonActivated, bringToFrontButtonActivated);
		this.bringToFrontButtonActivated = bringToFrontButtonActivated;
	}

	public void setBringToBackButtonActivated(boolean bringToBackButtonActivated) {
		propertyChangeSupport.firePropertyChange("bringToBackButton", this.bringToBackButtonActivated, bringToBackButtonActivated);
		this.bringToBackButtonActivated = bringToBackButtonActivated;
	}

	public void setToFrontButtonActivated(boolean toFrontButtonActivated) {
		propertyChangeSupport.firePropertyChange("toFrontButton", this.toFrontButtonActivated, toFrontButtonActivated);
		this.toFrontButtonActivated = toFrontButtonActivated;
	}

	public void setToBackButtonActivated(boolean toBackButtonActivated) {
		propertyChangeSupport.firePropertyChange("toBackButton", this.toBackButtonActivated, toBackButtonActivated);
		this.toBackButtonActivated = toBackButtonActivated;
	}
	
}
