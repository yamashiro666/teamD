package sound;

import java.io.File;

import javax.sound.sampled.Clip;

public class Sounds {

	// 音声ファイルのパスを表すフィールド
	private static File filePath;

	static void playMp3(String path) {}

	Clip playWav(String path) {
		return null;
	}

	public static File getFilePath() {
		return filePath;
	}

	static public void setFilePath(File path) {
		filePath = path;
	}
}
