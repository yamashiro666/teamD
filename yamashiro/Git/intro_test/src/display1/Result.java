package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display("Result.txt");

		//正解数と不正解数を表示する
		System.out.println("結果発表");
		System.out.println("あなたの成績は 正解 " +  Answer.correctNum + " 不正解 " + Answer.inCorrectNum + " です");


	}

	@Override
	public void selector(){

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し

			super.input();

			if(getPressedKey() == 2){  //exit.txtを表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == 1){  //endingをインスタンス生成及び表示

				Display start = new StartDisplay();
				start.display("StartDisplay.txt");
				// end.input();
				start.selector();
				flag = false;

			}else{  // 入力した数値が正しくない場合ループする

				System.out.println("正しい値を入力してください");

			}
		}
	}
}