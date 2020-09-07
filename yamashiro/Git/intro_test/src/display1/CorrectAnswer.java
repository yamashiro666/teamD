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
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum == 5){  //Resultをインスタンス生成及び表示

			System.out.println("TEST");
			Result rst = new Result();
			rst.display("Result.txt");
			rst.input();
			rst.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 1){  //IntroStartBeginnerをインスタンス生成及び表示

			Answer isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 2){  //IntroStartMediumをインスタンス生成及び表示

			Answer ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.display("SelectAnswer.txt");
			ism.input();
			ism.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 3){  //IntroStartExpertをインスタンス生成及び表示

			Answer ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.display("SelectAnswer.txt");
			ise.input();
			ise.selector();

		}
	}
}