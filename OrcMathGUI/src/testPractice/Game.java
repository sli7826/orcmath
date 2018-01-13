package testPractice;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import guiTeacher.userInterfaces.*;

public class Game extends ClickableScreen implements Runnable{

	private TextArea t;
	private Button b;
	private int count;
	private int time;
	
	public Game(int width, int height) {
		super(width, height);
		count=0;
		time=10;
		Thread app = new Thread(this);
		app.start();
	}

	public Game(int width, int height, ArrayList<Visible> initWithObjects) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		t=new TextArea(250, 100, 100, 200, "Score: "+count+" Time left: "+time);	
		b=new Button(100, 100, 100, 100, "Click", new Action() {
			
			@Override
			public void act() {
				count++;
				t.setText("Score: "+count+" Time left: "+time);
			}
		});
		viewObjects.add(b);
		viewObjects.add(t);
	}
	
	public void run() {
		for(int i=time;i>0;i--) {
			time--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.setText("Score: "+count+" Time left: "+time);
		}
		if(time<=0) {
			Main.m.setScreen(Main.r);
		}
	}

}
