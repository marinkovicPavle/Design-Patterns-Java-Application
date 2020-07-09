package strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import mvc.DrawingModel;

public class SaveShapes implements Save {

	@Override
	public void save(Object o, File f) {
		DrawingModel model =(DrawingModel)o;
		ObjectOutputStream ous = null;
		try {
			ous = new ObjectOutputStream(new FileOutputStream(f));
			ous.writeObject(model.getShapes());
			ous.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
