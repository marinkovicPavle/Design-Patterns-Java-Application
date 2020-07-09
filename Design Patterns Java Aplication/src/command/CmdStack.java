package command;

import java.util.ArrayList;

import shapes.Shape;

public class CmdStack {
	private ArrayList<Command> list = new ArrayList<Command>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<String> logCommandsUndo = new ArrayList<String>();
	private ArrayList<String> logCommandsRedo = new ArrayList<String>();

	private int current = -1;
	
	public int getCurrent() {
		return current;
	}
	
	public void setCurrent(int current) {
		this.current = current;
	}

	public ArrayList<Command> getList() {
		return list;
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public ArrayList<String> getLogCommandsUndo() {
		return logCommandsUndo;
	}
	
	public ArrayList<String> getLogCommandsRedo() {
		return logCommandsRedo;
	}

	public void deleteElementsAfterPointer(int current)
	{
	    if(list.size()<1)
	    	return;
	    for(int i = list.size()-1; i > current; i--)
	    {
	    	list.remove(i);
	    	shapes.remove(i);
	    	logCommandsUndo.remove(i);
	    	logCommandsRedo.remove(i);
	    }
	}
	
	public void undo() {
		
		/*if(redoStack.size()==0) {
			undoStack.push(list.get(current));
			//list.remove(current);
			System.out.println("Lista: "+list.size());
			System.out.println("Trenutni posle unda: "+current);
		}
		else {
			undoStack.push(redoStack.pop());
		}*/
		list.get(current).unexecute();
		current--;
	
	}
	public void redo() {
			
		if(current == list.size() - 1)
	        return;
		
		current++;
		list.get(current).execute();
		//redoStack.push(undoStack.pop());
	}
}
