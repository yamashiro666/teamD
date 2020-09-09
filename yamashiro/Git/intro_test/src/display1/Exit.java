package display1;

public class Exit extends Display{

	@Override
	public void selector() {

		if(getPressedKey() == '1') {

			Display start = new StartDisplay();

			start.display("SartDisplay.txt");
			start.selector();

		}
	}

}
