import display1.*;

public class Main {
	public static void main(String[] args) {

		// DtartDisplayをインスタンス化
		StartDisplay startDisplay = new StartDisplay();
		// 音楽を再生する為のクラス Music クラスインスタンス化
		//Music sound = new Music();

		//sound.playLong("sample2.mp3");
		//sound.playMp3Thread("sample2.mp3").start();
		startDisplay.display("textfile/StartDisplay.txt");

		
		
		startDisplay.input();

		// ProcessBuilderクラスを使いコマンドプロンプトの画面をクリアするコマンドを実行
		// する予定だけど、まだうまくいってない...
		// new ClearDisplay();
		startDisplay.selector();


		// sound.playShort("sample2.mp3");
		// sound.playMiddle("sample2.mp3");
		// sound.playLong("sample2.mp3");

	}
}
