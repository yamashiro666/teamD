package display1;

import sound.Music;

public class IntroQuiz{
	public static void main(String[] args) throws InterruptedException {

		StartDisplay start = new StartDisplay();
		// Music sound = new Music();

		Music.playMp3Thread("sample2.mp3").start(); //sample2.mp3を再生

		start.display("StartDisplay.txt");  //StartDisplay.txtを表示
		start.input();  //キーボード入力待ち
		start.selector();  //入力した値を元に条件分岐し、各ファイルをインスタンス生成及び表示

	}
}