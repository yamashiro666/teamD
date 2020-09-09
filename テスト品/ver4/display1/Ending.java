// 13行目15行目17行目20行目22行目26行目28～33行目を修正

package display1;

class Ending extends Display{

	@Override
	public void selector(){

		// System.out.println("仮表示: 0 でExit画面へ"); // テスト表示
		// System.out.println("仮表示: 1 でStartDisplay画面へ"); // テスト表示

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し
		
			super.input();
			
			if(getPressedKey() == '2'){  //Exit.txtを表示
				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //StartDisplayをインスタンス生成及び表示
				
				super.answerNum = 0;
				super.courseLevel = 0;
				super.correctNum = 0;
				super.inCorrectNum = 0;

				StartDisplay start = new StartDisplay();
				start.display("StartDisplay.txt");
				// start.input();
				start.selector();
				flag = false;

			}else{  //入力した数値が正しくない場合ループする
				System.out.println("正しい値を入力してください");
			}
		}
	}
}