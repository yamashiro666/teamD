package display1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import random.RandomUniqueNumberGenerator;

class Answer extends Display{

	//回答数のフィールド
	public static int answerNum;

	//コースレベルのフィールド
	public static int courseLevel;

	//正解数のフィールド
	public static int correctNum;

	//不正解数のフィールド
	public static int inCorrectNum;

	//上記の4フィールドを格納するメソッド
	public void count(){}

	// 問題で流すmp3のファイル名を格納するフィールド
	String answerMp3;

	/*
	 * 4択を格納するフィールド
	 * A.〇〇〇〇   B.〇〇〇〇
	 * C.〇〇〇〇   D.〇〇〇〇
	 * 「〇〇〇〇」の部分を格納する
	 */
	String[] answers;

	/*
	 * 4択を格納するフィールド
	 * A.〇〇〇〇   B.〇〇〇〇
	 * C.〇〇〇〇   D.〇〇〇〇
	 * 「A, B, C, D」の部分を格納する
	 */
	char charCorrectAnswer;

	// 0〜10の乱数。songFileName[]とsongsTitleName[][]からクイズに必要な音声ファイルと曲名リストをランダムで取得する時に使用
	int randomNum;

	// answerMp3 (mp3ファイルの名前) と songsTitleName の 正解曲名 を紐付けるためのフィールド
	// Map< answerMp3 , 正解曲名 >で管理
	Map<String, String> linkedMp3;

	// charCorrectAnswer (選択肢の A, B, C, D 部分)と answers(選択肢の 文字列部分) を紐付けるためのフィールド
	Map<String, Character> tmpAnswer;

	//音声ファイルの一次元配列15種類の音声ファイルリストを準備する
	String songsFileName[] = {

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
	String songsTitleName[][] = {

		/*
		 *  以下の配列はテキストファイルで別途保存も可能
		 */
		{"正解曲名1-1", "不正解曲名1-2", "不正解曲名1-3", "不正解曲名1-4", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名", "不正解曲名"},
		{"正解曲名2-1", "不正解曲名2-2", "不正解曲名2-3", "不正解曲名2-4", "不正解曲名2-5", "不正解曲名2-6", "不正解曲名2-7", "不正解曲名2-8", "不正解曲名2-9", "不正解曲名2-10"},
		{"正解曲名3-1", "不正解曲名3-2", "不正解曲名3-3", "不正解曲名3-4", "不正解曲名3-5", "不正解曲名3-6", "不正解曲名3-7", "不正解曲名3-8", "不正解曲名3-9", "不正解曲名3-10"},
		{"正解曲名4-1", "不正解曲名4-2", "不正解曲名4-3", "不正解曲名4-4", "不正解曲名4-5", "不正解曲名4-6", "不正解曲名4-7", "不正解曲名4-8", "不正解曲名4-9", "不正解曲名4-10"},
		{"正解曲名5-1", "不正解曲名5-2", "不正解曲名5-3", "不正解曲名5-4", "不正解曲名5-5", "不正解曲名5-6", "不正解曲名5-7", "不正解曲名5-8", "不正解曲名5-9", "不正解曲名5-10"},
		{"正解曲名6-1", "不正解曲名6-2", "不正解曲名6-3", "不正解曲名6-4", "不正解曲名6-5", "不正解曲名6-6", "不正解曲名6-7", "不正解曲名6-8", "不正解曲名6-9", "不正解曲名6-10"},
		{"正解曲名7-1", "不正解曲名7-2", "不正解曲名7-3", "不正解曲名7-4", "不正解曲名7-5", "不正解曲名7-6", "不正解曲名7-7", "不正解曲名7-8", "不正解曲名7-9", "不正解曲名7-10"},
		{"正解曲名8-1", "不正解曲名8-2", "不正解曲名8-3", "不正解曲名8-4", "不正解曲名8-5", "不正解曲名8-6", "不正解曲名8-7", "不正解曲名8-8", "不正解曲名8-9", "不正解曲名8-10"},
		{"正解曲名9-1", "不正解曲名9-2", "不正解曲名9-3", "不正解曲名9-4", "不正解曲名9-5", "不正解曲名9-6", "不正解曲名9-7", "不正解曲名9-8", "不正解曲名9-9", "不正解曲名9-10"},
		{"正解曲名10-1", "不正解曲名10-2", "不正解曲名10-3", "不正解曲名10-4", "不正解曲名10-5", "不正解曲名10-6", "不正解曲名10-7", "不正解曲名10-8", "不正解曲名10-9", "不正解曲名10-10"},
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


	// answers[] をシャッフルして charCorrectAnswer(選択肢 A, B, C, D) にランダムで配置するメソッド
	public void shuffle4Taku(){
		// linkMp3toText()メソッドで mp3のファイル名と 曲目リストの正解の文字列 を紐付ける
		linkMp3toText();

		// Romdomクラスで1から10の乱数生成
		Random random = new Random();
		randomNum = random.nextInt(9);

//		// カウントダウン画面を表示する & 音声ファイルの再生中に♪を表示する
//		CountDown cd = new CountDown();
//		cd.display("textfile/Countdown1.txt");

//		answerMp3 = songsFileName[randomNum];

//		// カウントダウン後、音声ファイルをランダムで選択し再生する
//		// playMp3メソッドはstaticメソッドにしました。
//		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]のいずれかを再生

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
			 *  1.  linkedMp3.get()メソッドで answerMp3(mp3ファイルのファイル名) に紐付けてある songsTitleName[i][0] (正解曲名) を取得
			 *  2.  if文で songsTitleName[i][0] (正解曲名) と 上で取得した文字列比較
			 *  3.  trueならその配列の中に入る
			 *  4.  songsTitleName[i][0] (正解曲名) を answers[](選択肢) のどれか1つに代入する。
			 *  5.  songsTitleName[i][1から3] (不正解曲名) をランダムで選び、残りの3択に代入
			 */
			if(songsTitleName[i][0].equals(linkedMp3.get(answerMp3))){
				answers[randomN1[0]] = songsTitleName[i][0];
				answers[randomN1[1]] = songsTitleName[i][randomN2[1]+1];
				answers[randomN1[2]] = songsTitleName[i][randomN2[2]+1];
				answers[randomN1[3]] = songsTitleName[i][randomN2[3]+1];
			}

		}

		// Sysoutで表示。answer[]のうちどれか一つに答えの文字列が入っている。
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
	} // shuffle4Taku() 終わり

	@Override
	public void selector(){

		// mp3のファイル名 をキーに 曲目リスト から 正解の文字列 を取得
		String linkedTextToMp3 = linkedMp3.get(answerMp3);

		// 4択の配列の数分for文を回し、選択肢の中から答えを検索してcharCorrectAnswerに代入
		for(int i = 0; i < answers.length; i++) {
			if(linkedTextToMp3.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == charCorrectAnswer){  //CorrectAnswerをインスタンス生成及び表示

			//if(answerNum == 0) {
				CorrectAnswer correct = new CorrectAnswer();
				correct.display("textfile/CorrectAnswer.txt");
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