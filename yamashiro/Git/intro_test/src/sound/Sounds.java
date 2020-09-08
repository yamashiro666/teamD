package sound;

import java.io.File;

import javax.sound.sampled.Clip;

public class Sounds {


	private static File filePath;

	public void playMp3(String path) {}

	public Clip playWav(String path) {
		return null;
	}

	public static File getFilePath() {
		return filePath;
	}

	static public void setFilePath(File path) {
		filePath = path;
	}
}
