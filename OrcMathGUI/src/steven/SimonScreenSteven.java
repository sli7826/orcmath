package steven;

import java.util.ArrayList;
import java.awt.Color;
import java.util.List;



import guiTeacher.components.Action;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SimonScreenSteven extends ClickableScreen implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2028781790220195673L;
	
	private TextLabel label;
	private ButtonInterfaceSteven[] buttons;
	private TextLabel progress;
	private ArrayList<MoveInterfaceSteven> sequence;
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;

	public SimonScreenSteven(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();

	}

	private void nextRound() {
		acceptingInput=false;
		roundNumber++;
		sequence.add(randomMove());
		progress.setText("Round: "+roundNumber+"  Size: "+sequence.size());
		changeText("Simon's turn");
		playSequence();
		acceptingInput = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceSteven b=null;
		for(int i=0;i<sequence.size();i++) {
			if(b!=null) {
				b.dim();
			}
			b=sequence.get(i).getButton();
			b.highlight();
			int sleepTime=1000/roundNumber;
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		b.dim();
		
	}

	private void changeText(String string) {
		label.setText(string);
		try {
			Thread.sleep(800);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		label.setText("");
		
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		for(ButtonInterfaceSteven b: buttons){ 
		    viewObjects.add(b); 
		}
		progress = new TextLabel(230,330,300,40,"");
		label = new TextLabel(230,230,300,40,"Let's play Simon!");
		
		sequence = new ArrayList<MoveInterfaceSteven>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(label);
		viewObjects.add(progress);
	}

	private MoveInterfaceSteven randomMove() {
		int bIndex = (int)(Math.random()*buttons.length);
	    while(bIndex == lastSelectedButton){
	        bIndex = (int)(Math.random()*buttons.length);
	    }
	    lastSelectedButton=bIndex;
	    return getMove(bIndex);
	}

	private MoveInterfaceSteven getMove(int bIndex) {
		// TODO Auto-generated method stub
		return new StevenMove(buttons[bIndex]);
	}

	private ProgressInterfaceSteven getProgress() {
		// TODO Auto-generated method stub
		return new StevenProgress(100,100,100,100);
	}

	private void addButtons() {
		int numberOfButtons = 6;
		buttons=new ButtonInterfaceSteven[numberOfButtons];
		Color[] colors={Color.blue,Color.green,Color.red,Color.orange,Color.gray,Color.pink};
		for(int i=0;i<numberOfButtons;i++) {
			final ButtonInterfaceSteven b = getAButton();
			buttons[i] = b;
			b.setColor(colors[i]);
			b.setX(100);
			b.setY(100+50*i);
			b.setAction(new Action() {
				
				@Override
				public void act() {
					if(acceptingInput) {
						Thread blink = new Thread(new Runnable(){

							public void run(){
								b.highlight();
								try {
									Thread.sleep(800);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								b.dim();
							}
							

						});
						blink.start();
						if(b == sequence.get(sequenceIndex).getButton()) {
							sequenceIndex++;
						}else {
							progress.setText("Game Over");
						}

						if(sequenceIndex == sequence.size()){ 
						    Thread nextRound = new Thread(SimonScreenSteven.this); 
						    nextRound.start(); 
						}
					}
					
				}
			});
		}
	}

	private ButtonInterfaceSteven getAButton() {
		return new StevenButton(10,10,40,40,"",null);
	}


	

}
