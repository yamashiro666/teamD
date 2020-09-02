package keytest;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Key implements KeyListener {

	static int position = 0;

	public static void main(String[] args) {

		new Key();
	}

	public Key() {

		JFrame frame = new JFrame();
		frame.setSize(50, 50);
		frame.setTitle("KEYPRESSSAMPLE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.addKeyListener(this);

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			position = 1;
			System.out.println("position=1");
		}
		if (key == KeyEvent.VK_RIGHT) {
			position = 2;
			System.out.println("position=2");

		}
		if (key == KeyEvent.VK_UP) {
			position = 3;
			System.out.println("position=3");

		}
		if (key == KeyEvent.VK_DOWN) {
			position = 4;
			System.out.println("position=4");

		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

}