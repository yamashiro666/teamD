//167行目169行目175行目187行目189行目201行目203～208行目を修正

package display1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.InputStreamReader;

import random.RandomUniqueNumberGenerator;
import selector.NameSelector;
import sound.Music;
import sound.Sounds;

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

	/**
	 *  問題で流すmp3のファイル名に対応する曲名を格納するフィールド
	 */
	String randomCollectedAnswer;

	/**
	 *  問題で流すmp3のファイル名を格納するフィールド
	 */
	String randomCollectedMp3;

	/**
	 * 4択を格納するフィールド
	 * A.〇〇〇〇   B.〇〇〇〇
	 * C.〇〇〇〇   D.〇〇〇〇
	 * 「〇〇〇〇」の部分を格納する
	 */
	String[] answers;

	/**
	 * 4択を格納するフィールド
	 * A.〇〇〇〇   B.〇〇〇〇
	 * C.〇〇〇〇   D.〇〇〇〇
	 * 「A, B, C, D」の部分を格納する
	 */
	char charCorrectAnswer;

	// 0～10の乱数。songFileName[]とsongsTitleName[][]からクイズに必要な音声ファイルと曲名リストをランダムで取得する時に使用
	int randomNum;

	// charCorrectAnswer (選択肢の A, B, C, D 部分)と answers(選択肢の 文字列部分) を紐付けるためのフィールド
	Map<String, Character> tmpAnswer;



	/**
	 *  answers[] をシャッフルして charCorrectAnswer(選択肢 A, B, C, D) にランダムで配置するメソッド
	 */
	public void shuffle4Taku(){

		// Romdomクラスで1から10の乱数生成
		Random random = new Random();
		randomNum = random.nextInt(9);

		// 4択 A, B, C, Dに格納する文字列配列を初期化
		answers = new String[4];

		/*
		 *  0 から 3 までの かぶらない乱数 を 生成
		 *  この乱数をanswers配列のindexに当てる
		 */
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(4);
		// 乱数が生成されているかの確認用のsysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		// SentakushiXX.txt が格納されているフォルダから ランダムでSentakushiファイルを一つ選ぶ
		NameSelector s = new NameSelector();

		String dirName;

		// Sentakushi01.txt が所属しているフォルダ名のパスを取得
		dirName = s.setDirName("Sentakushi01.txt");

		// System.out.println("Answerクラス内Sysout: 変数dirName: " + dirName);

		// SentakushiXX.txt の文字列リストを取得
		s.setTxtFileNameList(dirName);
		// System.out.println(s.setTxtFileNameList(dirName));

		// fileNameList フィールド(Sentakushi.txtのリスト)をシャッフルする
		Collections.shuffle(s.textFileNameList);

		// System.out.println("randomCollectedAnswer : " + randomCollectedAnswer);
		// fileNameListフィールド(Sentakushi??.txtのリスト) の数分for分を回す
		for(int i = 0; i < s.textFileNameList.size(); i++) {

			// Windows の場合
			String tmp = s.textFileNameList.get(i).replaceAll(".*\\\\", "");
			// Macの場合
			// String tmp = s.textFileNameList.get(i).replaceAll(".*\\/", "");

			List<String> tmp2 = s.readTextFile(tmp);

			// fileNameListフィールド(Sentakushi??.txtのリスト) の中を拡張for文でひとつづつリストアップしてゆく
			 for(int j = 0; j < tmp2.size(); j++) {

				 String tmp3 = tmp2.get(j);

				 // System.out.println(tmp3);
				 if(randomCollectedAnswer.equals(tmp3)){

						// Sentakushi??.txt ファイルに記述されている曲名分の要素数をかぶらないように、ランダムで取得
						int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(tmp2.size());
						// 4択の文字列配列に代入してゆく
						answers[randomN1[0]] = randomCollectedAnswer; // 答えを代入
						answers[randomN1[1]] = tmp2.get(randomN2[1]); // 残りは不正解の曲名を代入
						answers[randomN1[2]] = tmp2.get(randomN2[2]); // +1 しているのは先頭の正解の曲名が選ばれないようにするため
						answers[randomN1[3]] = tmp2.get(randomN2[3]);
				}
			 }
		}

		super.display("SelectAnswer.txt");

		// Sysoutで表示。answer[]のうちどれか一つに答えの文字列が入っている。
		System.out.println("答えを選んでね");
		System.out.println("A . " + String.format("%20s",  answers[0] ) + "   B . " +  String.format("%20s",  answers[1]));
		System.out.println("C . " + String.format("%20s",  answers[2] ) + "   D . " +  String.format("%20s",  answers[3]));

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

		// 4択の文字列配列とrandomCollectedAnswerを比較して合致したときに charCorrectAnswer に 4択の中にあるA,B,C,Dの答えを代入
		for(int i = 0; i < answers.length; i++) {
			if(randomCollectedAnswer.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		
		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し
			
			super.input();
			
			if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == charCorrectAnswer){  // CorrectAnswerをインスタンス生成及び表示

				// 正解用効果音の用意が必要
				Sounds sound = new Music();
				sound.playMp3("Quiz-Buzzer02-1.mp3");

				CorrectAnswer correct = new CorrectAnswer();
				correct.display("CorrectAnswer.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); // 正解数をカウントする
				// correct.input();
				correct.selector();
				flag = false;

			}else if(getPressedKey() != charCorrectAnswer && (getPressedKey() == 'A' || getPressedKey() == 'B' || getPressedKey() == 'C' || getPressedKey() == 'D')){  //InCorrectAnswerをインスタンス生成及び表示

				// 不正解音
				Sounds sound = new Music();
				sound.playMp3("Quiz-Wrong_Buzzer02-2.mp3");

				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); // 不正解数をカウントする
				// incorrect.input();
				incorrect.selector();
				flag = false;
				
			}else{  // 入力した数値が正しくない場合ループする
					System.out.println("正しい値を入力してください");
			}
		}
	}

}