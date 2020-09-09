package display1;

class Result extends Display{

	@Override
	public void selector(){

		flag = true;

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し

			this.input();

			if(getPressedKey() == '2'){  //exit.txtを表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //コンテニュー画面(StartDisplay)をインスタンス生成及び表示

				Display start = new StartDisplay();
				start.display("StartDisplay.txt");
				start.selector();
				flag = true;

			}else{  // 入力した数値が正しくない場合ループする

				System.out.println("正しい値を入力してください");

			}
		}
	}
}