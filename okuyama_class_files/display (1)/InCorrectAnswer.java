package display;

class InCorrectAnswer extends Answer{
	
	void count(int level){
		if(super.courseLevel == 0)super.courseLevel = level;
		super.answerNum++;
		super.inCorrectNum++;
	}
	
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum == 5){  //Resultをインスタンス生成及び表示
			Result rst = new Result();
			rst.display("Result.txt");
			rst.input();
			rst.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 1){  //IntroStartBeginnerをインスタンス生成及び表示
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 2){  //IntroStartMediumをインスタンス生成及び表示
			IntroStartMedium ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();
		}else if((getPressedKey() == 'n' || getPressedKey() == 'N') && super.answerNum < 5 && super.courseLevel == 3){  //IntroStartExpertをインスタンス生成及び表示
			IntroStartExpert ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();
		}
	}
}