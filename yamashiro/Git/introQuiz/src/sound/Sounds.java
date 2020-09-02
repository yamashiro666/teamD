package sound;

import java.io.File;

import javax.sound.sampled.Clip;

public class Sounds {

	// 音声ファイルのパスを表すフィールド
	private File filePath;

	void playMp3(String path) {}

	Clip playWav(String path) {
		return null;
	}

	public File getFilePath() {
		return this.filePath;
	}

	public void setFilePath(File path) {
		this.filePath = path;
	}
}
