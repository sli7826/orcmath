package steven;


import guiPlayer.CustomGUI;
import guiPlayer.CustomScreen;
import guiTeacher.GUIApplication;

public class SimonGameSteven extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5833396305503525536L;
	
	public static void main(String[] args) {
		SimonGameSteven s = new SimonGameSteven(800, 550);
		Thread runner = new Thread(s);
		runner.start();
	}

	
	public SimonGameSteven(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		SimonScreenSteven screen = new SimonScreenSteven(getWidth(), getHeight());
		setScreen(screen);

	}

}
