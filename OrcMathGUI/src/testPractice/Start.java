package testPractice;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.Screen;

public class Start extends ClickableScreen {

	private Button s;
	
	public Start(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public Start(int width, int height, ArrayList<Visible> initWithObjects) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		s=new Button(100, 100, 100, 100, "Start", new Action() {
			
			@Override
			public void act() {
				Main.m.setScreen(Main.g);
				
			}
		});
		viewObjects.add(s);

	}

}
