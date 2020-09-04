package display;

class InCorrectAnswer extends Answer{
	
	void count(int level){
		if(super.courseLevel == 0)super.courseLevel = level;
		super.answerNum++;
		super.inCorrectNum++;
	}
	
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum == 5){  //Result���C���X�^���X�����y�ѕ\��
			Result rst = new Result();
			rst.display("Result.txt");
			rst.input();
			rst.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 1){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 2){  //IntroStartMedium���C���X�^���X�����y�ѕ\��
			IntroStartMedium ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 3){  //IntroStartExpert���C���X�^���X�����y�ѕ\��
			IntroStartExpert ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();
		}
	}
}