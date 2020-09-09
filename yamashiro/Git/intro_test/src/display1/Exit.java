package display1;

public class Exit extends Display{

	@Override
	public void display(String filePath) {
		super.display(filePath);
		super.streamClose();
	}

}
