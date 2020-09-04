package display1;

class Result extends Display{

//	@Override
//	public void display("textfile/Result.txt"){
//		//正解数と不正解数を表示する
//	}

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