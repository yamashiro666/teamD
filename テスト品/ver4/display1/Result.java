// 10～45行目52行目54行目60行目66行目68～73行目を修正

package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display(path);

		// 正解数に応じて評価画面を出す
		if(Answer.correctNum == 5) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			super.display("Result1.txt"); //テキストファイルの作成が必要
			System.out.println("マツコ「上出来だわ」");

		}else if(Answer.correctNum == 4) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			super.display("Result2.txt"); //テキストファイルの作成が必要
			System.out.println("マツコ「なかなかやるわね」");

		}else if(Answer.correctNum == 3) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			super.display("Result3.txt"); //テキストファイルの作成が必要
			System.out.println("マツコ「もっとがんばりなさい」");

		}else if(Answer.correctNum < 3) {

			// 評価画面のクラスを作ってdisplayメソッドで呼び出し
			super.display("Result4.txt"); //テキストファイルの作成が必要
			System.out.println("マツコ「くぁｆえｊんｎねｆっｄｄ！」");
		}

		
		// 正解数と不正解数を表示する
		System.out.println();
		System.out.println("あなたの成績は 正解 " +  Answer.correctNum + " 不正解 " + Answer.inCorrectNum + " です");
		System.out.println();
		System.out.println("　　　　　1：エンディング");
		System.out.println("　　　　　2：終了");
		System.out.println();

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