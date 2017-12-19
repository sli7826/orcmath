package steven;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Button;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967334940075629874L;
	
	private TextField ram;
	private TextField storage;
	private TextField cpu;
	private TextField gpu;
	private Button button;

	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		ram=new TextField(40,40,200,30,"Enter GB","Ram");
		viewObjects.add(ram);
		storage=new TextField(40,90,200,30,"Enter GB","Storage");
		viewObjects.add(storage);
		cpu=new TextField(40,140,200,30,"What is your CPU","CPU");
		viewObjects.add(cpu);
		gpu=new TextField(40,190,200,30,"What is your GPU","GPU");
		viewObjects.add(gpu);
		button=new Button(40, 240, 60, 30, "Enter",new Color(154,87,146), null);
		viewObjects.add(button);
	}

}
