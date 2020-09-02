package display;

import sound.Music;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		Display startDisplay = new StartDisplay();
		Music sound = new Music();

		// sound.playLong("sample2.mp3");
		sound.playMp3Thread("sample2.mp3").start();
		startDisplay.display("StartDisplay.txt");

		startDisplay.waiting();

		// ProcessBuilderクラスを使いコマンドプロンプトの画面をクリアするコマンドを実行
		// する予定だけど、まだうまくいってない...
		new ClearDisplay();
		startDisplay.selector();


		// sound.playShort("sample2.mp3");
		// sound.playMiddle("sample2.mp3");
		// sound.playLong("sample2.mp3");

	}
}
