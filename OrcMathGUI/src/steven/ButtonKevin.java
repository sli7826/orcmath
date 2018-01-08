package steven;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class ButtonKevin extends Button implements ButtonInterfaceSteven{

	public Color color;
	public ButtonKevin(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public ButtonKevin(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, "", null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		
	}

	@Override
	public void highlight() {
		setColor(Color.YELLOW);
		
	}

	@Override
	public void dim() {
		setColor(color);
		
	}
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.
	}

}
