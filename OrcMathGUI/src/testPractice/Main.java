package testPractice;

import guiTeacher.GUIApplication;
import steven.SimonGameSteven;
import steven.SimonScreenSteven;

public class Main extends GUIApplication {
	
	public static Start s = new Start(800, 550);
	public static Game g = new Game(800, 550);
	public static Restart r = new Restart(800, 550);
	public static Main m = new Main(800, 550);

	public Main(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		setScreen(s);
	}
	
	public static void main(String[] args) {
		Thread runner = new Thread(m);
		runner.start();
	}

}
