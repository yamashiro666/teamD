class Ending extends Display{
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txt��\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //startDisplay���C���X�^���X�����y�ѕ\��
			startDisplay start = new startDisplay();
			start.display("startDisplay.txt");
			start.input();
			start.selector();
		}
	}
}