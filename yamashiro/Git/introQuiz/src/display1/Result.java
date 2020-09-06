package display1;

class Result extends Display{

	@Override
	public void display(String path){

		System.out.println("結果発表");
		System.out.println("正解数 : " + Answer.correctNum);
		System.out.println("不正解数 : " + Answer.inCorrectNum);

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
			System.out.println("マツコ「くぁｆえｊんｎねｆっｄｄ！！！」");
		}

	}

	@Override
	public void selector(){
		if(getPressedKey() == 0){  //exit.txtを表示

			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == 1){  //endingをインスタンス生成及び表示

			Ending end = new Ending();
			end.display("texfile/Ending.txt");
			end.input();
			end.selector();

		}
	}
}