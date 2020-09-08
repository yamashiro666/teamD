//9～39行目43行目に修正有り


package display1;

class Result extends Display{

	
	/*
	@Override
	public void display(String path){


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
	*/

	@Override
	public void selector(){
		if(getPressedKey() == '2'){  //Exit.txtを表示

			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == '1'){  //Endingをインスタンス生成及び表示

			Ending end = new Ending();
			end.display("texfile/Ending.txt"); //UIを考慮したテキストファイル修正が必要
			end.input();
			end.selector();

		}
	}
}