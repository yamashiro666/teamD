package sound;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;

import javafx.scene.media.AudioClip;



public class Music extends Sounds implements SoundAdjustment{

	AudioClip c;

	public void playMp3(String path) {

		URL pathToMp3 = ClassLoader.getSystemResource(path);

		String encodedURL ;
		String decodedURL;

		try {
			Pattern p = Pattern.compile("%2520");
			// URLをデコードする処理
			String encodedTmpURL = URLEncoder.encode(pathToMp3.toString(), "UTF-8");
//			System.out.println(encodedTmpURL.replace("file%3A%2F", ""));
			encodedURL = encodedTmpURL.replace("file%3A", "");
//			encodedURL = encodedURL.replace(p.pattern(), "%20");
//			encodedURL = encodedURL.replace("25", "");
//			System.out.println(encodedURL);
//			decodedURL = URLDecoder.decode(encodedURL , "UTF-8");
			c = new AudioClip(pathToMp3.toString());
			c.setVolume(1);
			c.play();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public void musicStop() {
		c.stop();
	}


	@Override
	public void playLong(String filePath) {

		try {
			playMp3(filePath);
			// ３秒間再生する
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}


	public void playMiddle(String filePath) {

		try {
			playMp3(filePath);
			// 1.5秒間再生する
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void playShort(String filePath) {

		try {
			playMp3(filePath);
			// 0.5秒間再生する
			Thread.sleep(500);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// playMp3メソッドをThreadで実行できるようにしたメソッド
	public Thread playMp3Thread(String filePath) {
		Thread playLongThread = new Thread(() -> {
			playMp3(filePath);
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
			playLong(filePath);
		});
		return playLongThread;
	}

	// playMiddleメソッドをThreadで実行できるようにしたメソッド
	public Thread playMiddleThread(String filePath) {
		Thread playMidlleThread = new Thread(() -> {
			playMiddle(filePath);
		});
		return playMidlleThread;
	}


}
