class CorrectAnswer extends Answer{
	
	void count(){
			correctCount[] += 1;
	}
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txt��\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) == 5){  //result���C���X�^���X�����y�ѕ\��
			Result rst = new Result();
			rst.display("result.txt");
			rst.input();
			rst.selector();
		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartBeginner�N���X�������ꍇ*/){  //introStartBeginner���C���X�^���X�����y�ѕ\��
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("introStartBeginner.txt");
			isb.input();
			isb.selector();
		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartMedium�N���X�������ꍇ*/){  //introStartMedium���C���X�^���X�����y�ѕ\��
			IntroStartMedium ism = new IntroStartMedium();
			ism.display("introStartMedium.txt");
			ism.input();
			ism.selector();
		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartExpert�N���X�������ꍇ*/){  //introStartExpert���C���X�^���X�����y�ѕ\��
			IntroStartExpert ise = new IntroStartExpert();
			ise.display("introStartExpert.txt");
			ise.input();
			ise.selector();
		}else{
			System.out.println("�K�؂Ȑ��l����͂��Ă��������B");
		}
	}
}