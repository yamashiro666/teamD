package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display("Result.txt");

		System.out.println(Answer.answerNum);
		//正解数と不正解数を表示する
		System.out.println("結果発表");
		System.out.println("あなたの成績は 正解 " +  Answer.correctNum + " 不正解 " + Answer.inCorrectNum + " です");


		// おまけ: 正解数に応じて評価画面を出す
		if(Answer.correctNum == 5) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			System.out.println("マツコ「上出来だわ」");
		}else if(Answer.correctNum == 4) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			System.out.println("マツコ「なかなかやるわね」");
		}else if(Answer.correctNum == 3) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			System.out.println("マツコ「もっとがんばりなさい」");
		}else if(Answer.correctNum < 3) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			System.out.println("マツコ「くぁｆえｊんｎねｆっｄｄ！」");
		}

	}

	@Override
	public void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //exit.txtを表示

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if(getPressedKey() == 'a' || getPressedKey() == 'A'){  //endingをインスタンス生成及び表示

			Ending end = new Ending();
			end.display("Ending.txt");
			end.input();
			end.selector();

		}
	}
}