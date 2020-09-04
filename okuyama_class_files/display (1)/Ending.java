class Ending extends Answer{
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(args[0] == 1){  //StartDisplayをインスタンス生成及び表示
			super.answerNum = 0;
			super.courseLevel = 0;
			super.correctNum = 0;
			super.inCorrectNum = 0;
			StartDisplay start = new StartDisplay();
			start.display("StartDisplay.txt");
			start.input();
			start.selector();
		}
	}
}