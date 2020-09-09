// 42行目44行目46行目50行目52行目56行目58～63行目を修正

package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display("Result.txt");

		System.out.println(Answer.answerNum);
		// 正解数と不正解数を表示する
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
		
		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し
		
			super.input();
			
			if(getPressedKey() == '2'){  //exit.txtを表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //endingをインスタンス生成及び表示

				Ending end = new Ending();
				end.display("Ending.txt");
				// end.input();
				end.selector();
				flag = false;

			}else{  // 入力した数値が正しくない場合ループする
				System.out.println("正しい値を入力してください");
			}
		}
	}
}