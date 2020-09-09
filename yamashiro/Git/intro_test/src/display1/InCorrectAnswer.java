/*
 * 9月9日追記
 * ・カウントダウンの音再生はCountDownクラス内でまとめて処理できるように変更
 */
package display1;

class InCorrectAnswer extends Answer{

	void count(int level){

		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			inCorrectNum++;
	}


	@Override
	public void selector(){

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し

			super.input();

			if(getPressedKey() == '2'){  //Exitをインスタンス生成及び表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1' && answerNum == 5){  //Resultをインスタンス生成及び表示

				Result rst = new Result();

				// 正解数に応じて評価画面を出す
				if(Answer.correctNum == 5) {

					// 評価画面のクラスを作ってdisplayメソッドで呼び出し
					rst.display("Result1.txt"); //テキストファイルの作成が必要
					System.out.println("マツコ「上出来だわ」");

				}else if(Answer.correctNum == 4) {

					// 評価画面のクラスを作ってdisplayメソッドで呼び出し
					rst.display("Result2.txt"); //テキストファイルの作成が必要
					System.out.println("マツコ「なかなかやるわね」");

				}else if(Answer.correctNum == 3) {

					// 評価画面のクラスを作ってdisplayメソッドで呼び出し
					rst.display("Result3.txt"); //テキストファイルの作成が必要
					System.out.println("マツコ「もっとがんばりなさい」");

				}else if(Answer.correctNum < 3) {

					// 評価画面のクラスを作ってdisplayメソッドで呼び出し
					rst.display("Result4.txt"); //テキストファイルの作成が必要
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
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  //IntroStartBeginnerをインスタンス生成及び表示

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  //IntroStartMediumをインスタンス生成及び表示

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  //IntroStartExpertをインスタンス生成及び表示

				Answer ise = new IntroStartExpert();
				ise.display("IntroStartExpert.txt");
				// ise.input();
				ise.selector();
				flag = false;

			}else{  // 入力した数値が正しくない場合ループする

				System.out.println("正しい値を入力してください");
			}
		}
	}
}