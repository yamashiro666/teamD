package display1;

import java.util.HashMap;
import java.util.Map;

class IntroStartBeginner extends Answer{

	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する

	//{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名}の2次元配列15種類の曲目リストを準備する
	String[][] songs = {
		{"正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		// ～15種類
	};

	void test() {
		Map<Character,String> map = new HashMap<Character,String>();
	}

	@Override
	public void display(String textFilePath){
		super.display(textFilePath);
		//カウントダウン画面を表示する
		//カウントダウン後、音声ファイルをランダムで選択し再生する
		//音声ファイルの再生中に♪を表示する
		//音声ファイル再生後、曲目リストを利用し、正解曲名1曲と不正解曲名1曲をランダムで配置し、表示する
	}

	@Override
	public void selector(){

		if(getPressedKey() == 0){  //Exit.txtを表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == songs[i][0]){  //CorrectAnswerをインスタンス生成及び表示

			if(super.correctCount == 0) {

				Answer correct = new IntroStartBeginner();

				correct.display("textfile/Correct.txt");
				correct.correctCount(); // 正解数をカウントする
				correct.input();
				correct.selector();

			}
		}else if(getPressedKey() == songs[i][1] || getPressedKey() == songs[i][2] || getPressedKey() == songs[i][3]){  //inCorrectAnswerをインスタンス生成及び表示

			if(super.inCorrectCount == 0){

				Answer incorrect = new IntroStartBeginner();

				incorrect.display("textfile/InCorrectAnswer.txt");
				incorrect.inCorrectCount(); // 不正解数をカウントする
				incorrect.input();
				incorrect.selector();

			}

		}else{

			System.out.println("適切な数値を入力してください。");

		}
	}
}