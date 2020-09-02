package keytest;

import java.io.InputStreamReader;

public class KeyTest {
	public static void main(String[] argv) {
		try {
			InputStreamReader unbuffered = new InputStreamReader(System.in);
			for (int i = 0; i < 10; ++i) {
				int x = unbuffered.read();
				System.out.println(String.format("%08x", x));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}