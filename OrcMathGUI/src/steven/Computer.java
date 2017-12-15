package steven;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;


public class Computer extends Component {
	
	private int ram;
	private int storage;
	private String cpuName;
	private String gpuName;
	
	public Computer(int ram,int storage,String cpuName,String gpuName) {
		super(200, 200, 130, 120);
		this.ram=ram;
		this.storage=storage;
		this.cpuName=cpuName;
		this.gpuName=gpuName;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		
	}
	
	public String toString() {
		return ram+","+storage+","+cpuName+","+gpuName;
		
	}

}
