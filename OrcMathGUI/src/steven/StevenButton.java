package steven;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class StevenButton extends Button implements ButtonInterfaceSteven {

	private Color color;
	private boolean highlighted;
	private int x;
	private int y;

	public StevenButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		this.x=x;
		this.y=y;
		highlighted=false;
		color=Color.black;
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlighted) {
			g.setColor(Color.red);
			g.fillRect(x,y,getWidth(),getHeight());
		}else {
			g.setColor(Color.black);
			g.fillRect(x,y,getWidth(),getHeight());
		}
	}

	@Override
	public void setColor(Color color) {
		this.color=color;
	}

	@Override
	public void highlight() {
		highlighted=true;

	}

	@Override
	public void dim() {
		highlighted=false;

	}

}
