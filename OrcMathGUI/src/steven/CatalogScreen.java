package steven;

import java.awt.Color;
import java.io.File;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.*;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CatalogScreen extends FullFunctionScreen implements FileRequester {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7967334940075629874L;
	
	private TextField ram;
	private TextField storage;
	private TextField cpu;
	private TextField gpu;
	private Button button;
	private TextArea text;
	private FileOpenButton open;
	private Button save;
	private Button delete;
	private CatalogMaker catalog;

	public CatalogScreen(int width, int height) {
		super(width, height);
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		catalog=new CatalogMaker();
		ram=new TextField(40,40,200,30,"Enter GB","Ram");
		viewObjects.add(ram);
		storage=new TextField(40,90,200,30,"Enter GB","Storage");
		viewObjects.add(storage);
		cpu=new TextField(40,140,200,30,"What is your CPU","CPU");
		viewObjects.add(cpu);
		gpu=new TextField(40,190,200,30,"What is your GPU","GPU");
		viewObjects.add(gpu);
		text=new TextArea(350,40,200,30,"Text");
		viewObjects.add(text);
		button=new Button(40, 240, 60, 30, "Add",new Color(154,87,146),new Action() {
			
			@Override
			public void act() {
				addClick();
				
			}
		});
		viewObjects.add(button);
		open=new FileOpenButton(110,240,60,30,null,this);
		viewObjects.add(open);
		delete=new Button(180, 240, 60, 30, "Delete",new Color(154,87,146),new Action() {
			
			@Override
			public void act() {
				addClick();
				
			}
		});
		viewObjects.add(delete);
		save=new Button(250, 240, 60, 30, "Save",new Color(154,87,146),new Action() {
			
			@Override
			public void act() {
				addClick();
				
			}
		});
		viewObjects.add(save);
	}

	protected void addClick() {
		text.setText("Add button clicked");
		
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
