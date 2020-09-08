/*
 *  コマンドプロンプトで実行する際は import display1.*; のコメントアウトをはずし、
 *  package display1; をコメントアウトする。
 */
package display1;

import sound.Music;

// import display1.*;

public class Main {
	public static void main(String[] args) {

		// DtartDisplayをインスタンス化
		StartDisplay startDisplay = new StartDisplay();

		Music sound = new Music();

		sound.playMp3Thread("music1.mp3").start();
		startDisplay.display("StartDisplay.txt");

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
