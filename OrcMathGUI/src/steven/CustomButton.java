package steven;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {

	private String s1;
	private String s2;
	private Color c;

	public CustomButton(int x, int y) {
		super(x, y, 60, 10, "", null);
		// TODO Auto-generated constructor stub
	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.BLACK);
		g.drawString(s1, 10, 10);
		g.drawString(s2, 10, 10);
		g.setColor(c);
		g.drawRect(10, 10, 60, 10);
		g.fillRect(10, 10, 60, 10);
	}
	
	public void updateString1(String string) {
		s1=string;
	}
	
	public void updateString2(String string) {
		s2=string;
	}
	
	public void setIconColor(Color color) {
		c=color;
	}
}
