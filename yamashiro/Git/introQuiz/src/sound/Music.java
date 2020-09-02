package sound;

import java.io.File;

import javafx.scene.media.AudioClip;



public class Music extends Sounds implements SoundAdjustment{

	@Override
	void playMp3(String path) {
		setFilePath(new File(path));
		AudioClip c = new AudioClip(getFilePath().toURI().toString());
		c.play();
	}

	@Override
	public void playLong(String filePath) {

		try {
			this.playMp3(filePath);
			// ３秒間再生する
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void playMiddle(String filePath) {

		try {
			this.playMp3(filePath);
			// 1.5秒間再生する
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void playShort(String filePath) {

		try {
			this.playMp3(filePath);
			// 0.5秒間再生する
			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// playLongメソッドをThreadで実行できるようにしたメソッド
	public Thread playMp3Thread(String filePath) {
		Thread playLongThread = new Thread(() -> {
			this.playMp3(filePath);
//			try {
//				Thread.sleep(8000);
//			} catch (InterruptedException e) {
//				// TODO 自動生成された catch ブロック
//				e.printStackTrace();
//			}
		});
		return playLongThread;
	}

	// playLongメソッドをThreadで実行できるようにしたメソッド
	public Thread playLongThread(String filePath) {
		Thread playLongThread = new Thread(() -> {
			this.playLong(filePath);
		});
		return playLongThread;
	}

	// playMiddleメソッドをThreadで実行できるようにしたメソッド
	public Thread playMiddleThread(String filePath) {
		Thread playMidlleThread = new Thread(() -> {
			this.playMiddle(filePath);
		});
		return playMidlleThread;
	}
}
