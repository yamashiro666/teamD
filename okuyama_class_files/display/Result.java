class Result extends Display{
	
	@override
	void display(){
		//正解数と不正解数を表示する
	}
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txtを表示
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //endingをインスタンス生成及び表示
			Ending end = new Ending();
			end.display("ending.txt");
			end.input();
			end.selector();
		}
	}
}