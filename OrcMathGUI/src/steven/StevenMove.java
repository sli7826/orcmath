package steven;

public class StevenMove implements MoveInterfaceSteven {

	private StevenButton button;
	
	public StevenMove(StevenButton button) {
		this.button=button;
	}

	@Override
	public ButtonInterfaceSteven getButton() {
		return button;
	}

}
