package display1;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		if(getPressedKey() == '4'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if(getPressedKey() == '1'){  //IntroStartBeginnerをインスタンス生成及び表示

			Answer isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '2'){  //IntroStartMediumをインスタンス生成及び表示

			Answer ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '3'){  //IntroStartExpertをインスタンス生成及び表示

			Answer ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}

	}
}