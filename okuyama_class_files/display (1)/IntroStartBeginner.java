package display;

import sound.Music;

class IntroStartBeginner extends Answer{
	
	/*
	//以下コメント化した問題と音声のランダム出題は現在開発中
	
	
	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
	String songsFileName[] = {
		"1.mp3",
		"2.mp3",
		"3.mp3",
		"4.mp3",
		"5.mp3",
		"6.mp3",
		"7.mp3",
		"8.mp3",
		"9.mp3",
		"10.mp3"
	}
	
	//正解曲名1曲, 不正解曲名9曲の2次元配列10種類の曲目リストを準備する
	String songsTitleName[][] = {
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
		{正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名, 不正解曲名},
	}
	
	//0～10の乱数。songFileName[]とsongsTitleName[][]からクイズに必要な音声ファイルと曲名リストをランダムで取得する時に使用
	int 
	;
	
	@override
	void display(){
		//カウントダウン画面を表示する
		xxx
		
		//音声ファイルの再生中に♪を表示する
		xxx
		
		//カウントダウン後、音声ファイルをランダムで選択し再生する
		Music sound = new Music();
		sound.playMp3Thread(songFileName[/*0～10の乱数*/]).start(); //songFileName[]のいずれかを再生
		
		//音声ファイル再生後、曲目リストを利用し、正解曲名1曲と不正解曲名1曲をランダムで配置し、表示する
		
	}
	*/
	
	
	//以下コメント化した条件分岐の条件は現在開発中
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(getPressedKey() == /*正解のキー*/){  //CorrectAnswerをインスタンス生成及び表示
			if(super.answerNum == 0)CorrectAnswer correct = new CorrectAnswer();
			correct.display("Correct.txt");
			correct.count(1); //正解数をカウントする
			correct.input();
			correct.selector();
		}else if(getPressedKey() == /*不正解のキー*/){  //InCorrectAnswerをインスタンス生成及び表示
			if(super.answerNum == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("InCorrectAnswer.txt");
			incorrect.count(1); //不正解数をカウントする
			incorrect.input();
			incorrect.selector();
		}
	}
}