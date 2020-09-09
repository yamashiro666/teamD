package display1;

class Ending extends Display{

	@Override
	public void selector(){

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し

			super.input();

			if(getPressedKey() == 2){  //Exit.txtを表示

				Exit exit = new Exit();
				exit.display("Exit.txt");

			}else if(getPressedKey() == 1){  //StartDisplayをインスタンス生成及び表示

				StartDisplay start = new StartDisplay();

				start.display("StartDisplay.txt");
				start.input();
				start.selector();

			}else{  //入力した数値が正しくない場合ループする

				System.out.println("正しい値を入力してください");

			}
		}
	}
}