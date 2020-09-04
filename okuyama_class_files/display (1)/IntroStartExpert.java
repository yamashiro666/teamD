package display;

class IntroStartExpert extends Answer{
	
	//以下コメント化した問題と音声のランダム出題は現在開発中
	
	/*
	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
	
	//{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名}の2次元配列15種類の曲目リストを準備する
	String songs[] = {
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		～15種類
	}
	
	@override
	void display(){
		//カウントダウン画面を表示する
		//カウントダウン後、音声ファイルをランダムで選択し再生する
		//音声ファイルの再生中に♪を表示する
		//音声ファイル再生後、入力待ちの状態を作り、「答えを入力してください」と表示する
	}
	*/
	
	
	//以下コメント化した条件分岐の条件は現在開発中
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(/*入力した文字列*/ == /*正解の文字列*/){  //CorrectAnswerをインスタンス生成及び表示
			if(super.answerNum == 0)CorrectAnswer correct = new CorrectAnswer();
			correct.display("Correct.txt");
			correct.count(3);
			correct.input();
			correct.selector();
		}else{  //InCorrectAnswerをインスタンス生成及び表示
			if(super.answerNum == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("InCorrectAnswer.txt");
			incorrect.count(3);
			incorrect.input();
			incorrect.selector();
		}
	}
}