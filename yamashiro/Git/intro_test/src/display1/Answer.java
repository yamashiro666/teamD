package display1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import random.RandomUniqueNumberGenerator;
import selector.LinkFileNameToMp3;
import selector.NameSelector;

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
		List<String> kyokumeiList;

		// 4択 A, B, C, Dに格納する文字列配列を初期化
		answers = new String[3];

		/*
		 *  0 から 3 までの かぶらない乱数 を 生成
		 *  この乱数をanswers配列のindexに当てる
		 */
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(3);
		// 乱数が生成されているかの確認用のsysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		/*
		 *  0 から 8 までの かぶらない乱数 を 生成
		 *  この乱数をanswers配列のindexに当てる
		 */
		int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(8);
		// 乱数が生成されているかの確認用のsysout
//		for(int i = 0; i < randomN2.length; i++) {
//
//			System.out.println(randomN2[i]);
//		}

		// SentakushiXX.txt が格納されているフォルダから ランダムでSentakushiファイルを一つ選ぶ
		NameSelector s = new NameSelector();

		s.getFileNameList().forEach(e -> {
			List<String> fileNameList = s.getFileNameList();

		});

		String sentakushiFileName = s.getRomdomTextFileName("Sentakushi01.txt");
		kyokumeiList = s.readTextFile(sentakushiFileName);
		 Collections.shuffle(kyokumeiList);


		// 取得したmp3リストの中でもしanswerMp3と合致したものがあれば
		// 選択肢(answers[])の中に文字列をランダムで代入してゆく
		if(link.linkedList.containsKey(randomCollectedAnswer)) {
			for(int i = 0; i <  kyokumeiList.size(); i++) {
				answers[randomN1[0]] = randomCollectedAnswer;
				answers[randomN1[1]] = s.getRandomTltleName()[0];
				answers[randomN1[2]] = s.getRandomTltleName()[1];
				answers[randomN1[3]] = s.getRandomTltleName()[2];
			}
		}


		super.display("SelectAnswer.txt");

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
		LinkFileNameToMp3 link = new LinkFileNameToMp3("music_title.txt");
		int random = new Random().nextInt(link.linkedList.size());
		// ランダムに答えの文字列を選び randomCorrectedAnswers に代入
		String randomCorrectedMp3 = link.linkedList.get(random);
		String randomCorrectedAnswer = LinkFileNameToMp3.getKeysByValue(link.linkedList, randomCorrectedMp3).toString();


		// mp3のファイル名 をキーに 曲目リスト から 正解の文字列 を取得


		// 4択の配列の数分for文を回し、選択肢の中から答えを検索してcharCorrectAnswerに代入
		for(int i = 0; i < answers.length; i++) {
			if(linkedTextToMp3.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if(getPressedKey() == charCorrectAnswer){  //CorrectAnswerをインスタンス生成及び表示

			//if(answerNum == 0) {
				CorrectAnswer correct = new CorrectAnswer();
				correct.display("CorrectAnswer.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); //正解数をカウントする
				correct.input();
				correct.selector();
			//}


		}else if(getPressedKey() != charCorrectAnswer){  //InCorrectAnswerをインスタンス生成及び表示

			//if(answerNum == 0) {
				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); //不正解数をカウントする
				incorrect.input();
				incorrect.selector();
			//}

		}
	}

}