class StartDisplay extends Display{
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txt��\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //couseSelect���C���X�^���X�����y�ѕ\��
			CouseSelect couse = new CouseSelect();
			course.display("couseSelect.txt");
			corse.input();
			corse.selector();
		}else{
			System.out.println("1 or 2 �̐��l����͂��Ă��������B");
		}
	}
}