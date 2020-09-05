package display1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import random.RandomUniqueNumberGenerator;
import sound.Music;

class IntroStartBeginner extends Answer{

	// 0～10の乱数。songFileName[]とsongsTitleName[][]からクイズに必要な音声ファイルと曲名リストをランダムで取得する時に使用
	int randomNum;

	// 問題で流す mp3ファイルの名前 と 正解の文字列 を紐付けるためのフィールド
	// Map< mp3ファイル名, 正解の文字列 >で管理
	Map<String, String> linkedMp3;

	// 選択肢(A, B, C, D) と 答えの文字列 を紐付けるためのフィールド
	Map<String, Character> tmpAnswer;

	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
	private String songsFileName[] = {

		/*
		 *  フォルダにある音源からファイル名を取得して
		 *  この配列に格納することも可能
		 */
		"music1.mp3",
		"music2.mp3",
		"music3.mp3",
		"music4.mp3",
		"music5.mp3",
		"music6.mp3",
		"music7.mp3",
		"music8.mp3",
		"music9.mp3",
		"music10.mp3"
	};

	// 正解曲名1曲,  不正解曲名9曲の2次元配列10種類の曲目リストを準備する
	private String songsTitleName[][] = {

		/*
		 *  以下の配列はテキストファイルで別途保存も可能
		 */
		{"正解曲名1-1", "不正解曲名1-2", "不正解曲名1-3", "不正解曲名1-4", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名2-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名3-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名4-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名5-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名6-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名7-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名8-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名9-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名10-1", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
	};

	/*
	 *  linkMp3toText()メソッドの内容
	 *  mp3のファイル名と曲目リストを紐付ける
	 *  1.  Map作成(HashMap<String, String>)
	 *  2.  音源のファイル名とsongsTitleName配列の各先頭にある正解の文字列をfor文にて格納してゆく
	 */
	Map<String,String> linkMp3toText() {

		// 1.  Map作成(HashMap<String, String>)
		linkedMp3 = new HashMap<String,String>(){
			{
				if(songsFileName.length == songsTitleName.length) {
						for(int i = 0; i  < songsFileName.length; i++) {
							// 2.  音源のファイル名とsongsTitleName配列の各先頭にある正解の文字列をfor文にて格納してゆく
							put(songsFileName[i], songsTitleName[i][0]);
					}
				}
			}
		};

		// 3.  格納が終わったらreturnする
		return linkedMp3;
	}

	@Override
	public void display(String path){

		// linkMp3toText()メソッドで mp3のファイル名と 曲目リストの正解の文字列 を紐付ける
		linkMp3toText();

		// Romdomクラスで1から10の乱数生成
		Random random = new Random();
		randomNum = random.nextInt(9);

		// カウントダウン画面を表示する & 音声ファイルの再生中に♪を表示する
		CountDown cd = new CountDown();
		cd.display("textfile/Countdown1.txt");

		answerMp3 = songsFileName[randomNum];

		// カウントダウン後、音声ファイルをランダムで選択し再生する
		// playMp3メソッドはstaticメソッドにしました。
		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]のいずれかを再生

		// 選択肢に表示する文字列を格納する文字列
		answers = new String[4];

		// 0 から 4 までの かぶらない乱数 を 生成
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(4);
		// 乱数が生成されているかの確認用のsysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		// 0 から 8 までの かぶらない乱数 を 生成
		int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(8);
		// 乱数が生成されているかの確認用のsysout
//		for(int i = 0; i < randomN2.length; i++) {
//
//			System.out.println(randomN2[i]);
//		}

		// 音声ファイル再生後、曲目リストを利用し、正解曲名1曲と不正解曲名1曲をランダムで配置し、表示する
		for(int i = 0; i < songsTitleName.length; i++) {

			/*
			 *  1.  linkedMp3.get()メソッドで mp3ファイルのファイル名 に紐付けてある 曲名の文字列 を取得
			 *  2.  if文で曲目リストの先頭と 上で取得した文字列比較
			 *  3.  trueならその配列の中に入る
			 *  4.  正解の文字列を選択肢のどれか1つに代入する。
			 *  5.  不正解の曲名をランダムで選び、残りの3択に代入
			 */
			if(songsTitleName[i][0].equals(linkedMp3.get(answerMp3))){
				answers[randomN1[0]] = songsTitleName[i][0];
				answers[randomN1[1]] = songsTitleName[i][randomN2[1]+1];
				answers[randomN1[2]] = songsTitleName[i][randomN2[2]+1];
				answers[randomN1[3]] = songsTitleName[i][randomN2[3]+1];
			}

		}

		// Sysoutで表示。answer配列のうちどれか一つに答えの文字列が入っている。
		System.out.println("答えを選んでね");
		System.out.println("A . " + answers[0] + "   B . " +  answers[1]);
		System.out.println("C . " + answers[2] + "   D . " +  answers[3]);

		// 選択肢(A, B, C, D) と 選択肢に対応する曲名 を紐付ける処理を行う
		tmpAnswer = new HashMap<String, Character>(){
			{
				put(answers[0], 'A');
				put(answers[1], 'B');
				put(answers[2], 'C');
				put(answers[3], 'D');
			}
		};

	}

	@Override
	public void selector(){

		// 選択肢の中から答えを検索してcharCorrectAnswerに代入
		for(int i = 0; i < answers.length; i++) {
			if(answerMp3.equals(answers[i]) ) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
			}
		}

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == charCorrectAnswer){  //CorrectAnswerをインスタンス生成及び表示

			//if(answerNum == 0) {
				CorrectAnswer correct = new CorrectAnswer();
				correct.display("textfile/Correct.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); //正解数をカウントする
				correct.input();
				correct.selector();
			//}


		}else if(getPressedKey() != charCorrectAnswer){  //InCorrectAnswerをインスタンス生成及び表示

			//if(answerNum == 0) {
				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("textfile/InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); //不正解数をカウントする
				incorrect.input();
				incorrect.selector();
			//}

		}
	}
}