//51行目58行目に修正有り


package display1;

import sound.Music;

class IntroStartExpert extends Answer{
//
//	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
//
//	//{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名}の2次元配列15種類の曲目リストを準備する
//	String songs[] = {
//		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
//		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
//		～15種類
//	}
//
//	@override
//	void display(){
//		//カウントダウン画面を表示する
//		//カウントダウン後、音声ファイルをランダムで選択し再生する
//		//音声ファイルの再生中に♪を表示する
//		//音声ファイル再生後、入力待ちの状態を作り、「答えを入力してください」と表示する
//	}


	@Override
	public void display(String path){

		// カウントダウン画面を表示する & 音声ファイルの再生中に♪を表示する
		CountDown cd = new CountDown();
		cd.display("textfile/Countdown1.txt");

		answerMp3 = songsFileName[randomNum];

		// カウントダウン後、音声ファイルをランダムで選択し再生する
		// playMp3メソッドはstaticメソッドにしました。
		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]のいずれかを再生

		super.shuffle4Taku();
	}

//
//	@override
//	void selector(){
//		if(args[0] == 0){  //exit.txtを表示
//			Exit exit = new Exit();
//			exit.display(exit.txt);
//		}else if(args[0] == songs[i][0]){  //correctAnswerをインスタンス生成及び表示
			//正解用効果音の用意が必要
//			if(super.correctCount.length == 0)CorrectAnswer correct = new CorrectAnswer();
//			correct.display("correct.txt");
//			correct.count();
//			correct.input();
//			correct.selector();
//		}else{  //inCorrectAnswerをインスタンス生成及び表示
			//不正解用効果音の用意が必要
//			if(super.inCorrectCount.length == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
//			incorrect.display("inCorrectAnswer.txt");
//			incorrect.count();
//			incorrect.input();
//			incorrect.selector();
//		}
//	}
}