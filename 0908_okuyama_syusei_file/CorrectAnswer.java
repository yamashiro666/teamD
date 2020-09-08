//20行目25～65行目67行目69行目71行目73行目77行目79行目82行目86行目88行目91行目に修正有り


package display1;

class CorrectAnswer extends Answer{

	void count(int level){

		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			correctNum++;
	}


	@Override
	public void selector(){
		if(getPressedKey() == '2'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == '1' && answerNum == 5){  //Resultをインスタンス生成及び表示

			Result rst = new Result();


			// 正解数に応じて評価画面を出す
			if(Answer.correctNum == 5) {

				// 評価画面のクラスを作ってdisplayメソッドで呼び出し
				rst.display("textfile/Result1.txt"); //テキストファイルの作成が必要
				System.out.println("マツコ「上出来だわ」");

			}else if(Answer.correctNum == 4) {

				// 評価画面のクラスを作ってdisplayメソッドで呼び出し
				rst.display("textfile/Result2.txt"); //テキストファイルの作成が必要
				System.out.println("マツコ「なかなかやるわね」");

			}else if(Answer.correctNum == 3) {

				// 評価画面のクラスを作ってdisplayメソッドで呼び出し
				rst.display("textfile/Result3.txt"); //テキストファイルの作成が必要
				System.out.println("マツコ「もっとがんばりなさい」");

			}else if(Answer.correctNum < 3) {

				// 評価画面のクラスを作ってdisplayメソッドで呼び出し
				rst.display("textfile/Result4.txt"); //テキストファイルの作成が必要
				System.out.println("マツコ「くぁｆえｊんｎねｆっｄｄ！」");
			}


			//正解数と不正解数を表示する
			System.out.println("結果発表");
			System.out.println("あなたの成績は 正解 " +  Answer.correctNum + " 不正解 " + Answer.inCorrectNum + " です");
			System.out.println();
			System.out.println("1：ＮＥＸＴ");
			System.out.println("2：ＥＸＩＴ");

			rst.input();
			rst.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  //IntroStartBeginnerをインスタンス生成及び表示

			//カウントダウン用効果音の用意が必要

			//System.out.println("TEST");
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStart.txt");  //テキストファイル修正済み
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  //IntroStartMediumをインスタンス生成及び表示

			//カウントダウン用効果音の用意が必要

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("textfile/IntroStart.txt"); //テキストファイル修正済み
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  //IntroStartExpertをインスタンス生成及び表示

			//カウントダウン用効果音の用意が必要

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStart.txt"); //テキストファイル修正済み
			ise.input();
			ise.selector();

		}
	}
}