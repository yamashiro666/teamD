class Ending extends Answer{
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(args[0] == 1){  //StartDisplay���C���X�^���X�����y�ѕ\��
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