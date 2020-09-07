package display1;

import sound.Music;

class IntroStartMedium extends Answer{

//	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
//
//	//{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名}の2次元配列15種類の曲目リストを準備する
//	String[][] songs = {
//		{"正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
//		{"正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
//		// ～15種類
//	};

	@Override
	public void display(String path){

		// カウントダウン画面を表示する & 音声ファイルの再生中に♪を表示する
		CountDown cd = new CountDown();
		cd.display("Countdown1.txt");

		answerMp3 = songsFileName[randomNum];

		// カウントダウン後、音声ファイルをランダムで選択し再生する
		// playMp3メソッドはstaticメソッドにしました。
		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]のいずれかを再生

		super.shuffle4Taku();
	}

//	@Override
//	public void selector(){
//		if(getPressedKey() == 0){  //exit.txtを表示
//			Exit exit = new Exit();
//			exit.display("Exit.txt");
//		}else if(getPressedKey() == songs[i][0]){  //correctAnswerをインスタンス生成及び表示
//			if(super.correctCount.length == 0)CorrectAnswer correct = new CorrectAnswer();
//			correct.display("correct.txt");
//			correct.count();
//			correct.input();
//			correct.selector();
//		}else if(args[0] == songs[i][1] || args[0] == songs[i][2] || args[0] == songs[i][3]){  //inCorrectAnswerをインスタンス生成及び表示
//			if(super.inCorrectCount.length == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
//			incorrect.display("inCorrectAnswer.txt");
//			incorrect.count();
//			incorrect.input();
//			incorrect.selector();
//		}else{
//			System.out.println("適切な数値を入力してください。");
//		}
//	}
}