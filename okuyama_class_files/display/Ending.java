class Ending extends Display{
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txtを表示
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //startDisplayをインスタンス生成及び表示
			startDisplay start = new startDisplay();
			start.display("startDisplay.txt");
			start.input();
			start.selector();
		}
	}
}