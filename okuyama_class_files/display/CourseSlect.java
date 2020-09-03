class CourseSlect extends  Display{
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(getPressedKey() == 'b' || getPressedKey() == 'B'){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.waiting();
			isb.selector();
		}else if(getPressedKey() == 'm' || getPressedKey() == 'M'){  //IntroStartMedium���C���X�^���X�����y�ѕ\��
			IntroStartMedium ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.waiting();
			ism.selector();
		}else if(getPressedKey() == 'x' || getPressedKey() == 'X'){  //IntroStartExpert���C���X�^���X�����y�ѕ\��
			IntroStartExpert ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.waiting();
			ise.selector();
		}
	}
}