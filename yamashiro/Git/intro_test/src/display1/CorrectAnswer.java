package display1;

class CorrectAnswer extends Answer{

	void count(int level){

		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			correctNum++;
	}


	@Override
	public void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum == 5){  //Result���C���X�^���X�����y�ѕ\��

			System.out.println("TEST");
			Result rst = new Result();
			rst.display("Result.txt");
			rst.input();
			rst.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 1){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

			Answer isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 2){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

			Answer ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.display("SelectAnswer.txt");
			ism.input();
			ism.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 3){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

			Answer ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.display("SelectAnswer.txt");
			ise.input();
			ise.selector();

		}
	}
}