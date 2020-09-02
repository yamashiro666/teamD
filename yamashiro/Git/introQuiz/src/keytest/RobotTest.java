package keytest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotTest {
	public static void main(String[] args) {
		ProcessBuilder pbAppleScript = new ProcessBuilder();
		try {
		        Robot robot = new Robot();
		        // Simulate a key press
		        robot.keyPress(KeyEvent.VK_A);
		        robot.keyRelease(KeyEvent.VK_A);


		} catch (AWTException e) {
		        e.printStackTrace();
		}
	}

}
