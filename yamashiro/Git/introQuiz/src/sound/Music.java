package sound;

import java.io.File;

import javafx.scene.media.AudioClip;



public class Music extends Sounds implements SoundAdjustment{


	static void playMp3(String path) {
		setFilePath(new File(path));
		AudioClip c = new AudioClip(getFilePath().toURI().toString());
		c.play();
	}

	@Override
	public void playLong(String filePath) {

		try {
			playMp3(filePath);
			// �R�b�ԍĐ�����
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void playMiddle(String filePath) {

		try {
			playMp3(filePath);
			// 1.5�b�ԍĐ�����
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void playShort(String filePath) {

		try {
			playMp3(filePath);
			// 0.5�b�ԍĐ�����
			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// playMp3���\�b�h��Thread�Ŏ��s�ł���悤�ɂ������\�b�h
	public static Thread playMp3Thread(String filePath) {
		Thread playLongThread = new Thread(() -> {
			playMp3(filePath);
//			try {
//				Thread.sleep(8000);
//			} catch (InterruptedException e) {
//				// TODO �����������ꂽ catch �u���b�N
//				e.printStackTrace();
//			}
		});
		return playLongThread;
	}

	// playLong���\�b�h��Thread�Ŏ��s�ł���悤�ɂ������\�b�h
	public Thread playLongThread(String filePath) {
		Thread playLongThread = new Thread(() -> {
			this.playLong(filePath);
		});
		return playLongThread;
	}

	// playMiddle���\�b�h��Thread�Ŏ��s�ł���悤�ɂ������\�b�h
	public Thread playMiddleThread(String filePath) {
		Thread playMidlleThread = new Thread(() -> {
			this.playMiddle(filePath);
		});
		return playMidlleThread;
	}
}
