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
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum == 5){  //Resultをインスタンス生成及び表示

			Result rst = new Result();
			rst.display("textfile/Result.txt");
			rst.input();
			rst.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 1){  //IntroStartBeginnerをインスタンス生成及び表示

			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 2){  //IntroStartMediumをインスタンス生成及び表示

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("Itextfile/ntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && answerNum < 5 && courseLevel == 3){  //IntroStartExpertをインスタンス生成及び表示

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}
	}
}