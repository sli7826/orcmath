package steven;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Component;

public class StevenProgress extends Component implements ProgressInterfaceSteven {

	private int round;
	private boolean game;
	private int seq;
	private int x;
	private int y;
	
	public StevenProgress(int x, int y, int w, int h) {
		super(x, y, w, h);
		game=true;
		round=1;
		seq=1;
		this.x=x;
		this.y=y;
		update();
	}

	@Override
	public void gameOver() {
		game=false;
		update();

	}

	@Override
	public void setRound(int i) {
		round=i;
		update();
	}

	@Override
	public void setSequenceSize(int i) {
		seq=i;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(game) {
			g.drawString(""+round, x, y);
			g.drawString(""+seq, x, y+20);
		}else {
			g.drawString("Game over", x, y);
		}

	}

}
