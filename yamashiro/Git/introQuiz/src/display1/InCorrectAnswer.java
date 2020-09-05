package display1;

class InCorrectAnswer extends Answer{

	void count(int level){
		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			inCorrectNum++;
	}


	@Override
	public void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum == 5){  //Result���C���X�^���X�����y�ѕ\��

			Result rst = new Result();
			rst.display("textfile/Result.txt");
			rst.input();
			rst.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 1){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 2){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("Itextfile/ntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 3){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}
	}
}