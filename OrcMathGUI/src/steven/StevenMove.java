package steven;

public class StevenMove implements MoveInterfaceSteven {

	private ButtonInterfaceSteven button;
	
	public StevenMove(ButtonInterfaceSteven button) {
		this.button=button;
	}

	@Override
	public ButtonInterfaceSteven getButton() {
		return button;
	}

}
