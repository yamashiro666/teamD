class Result extends Display{
	
	@override
	void display(){
		//���𐔂ƕs���𐔂�\������
	}
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txt��\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //ending���C���X�^���X�����y�ѕ\��
			Ending end = new Ending();
			end.display("ending.txt");
			end.input();
			end.selector();
		}
	}
}