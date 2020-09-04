package display1;

public class CourseSlect extends Display{

	@Override
	public void selector(){

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == 'b' || getPressedKey() == 'B'){  //IntroStartBeginnerをインスタンス生成及び表示

			IntroStartBeginner isb = new IntroStartBeginner();
			CountDown cd = new CountDown();
			cd.display("textfile/Countdown1.txt");
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if(getPressedKey() == 'm' || getPressedKey() == 'M'){  //IntroStartMediumをインスタンス生成及び表示

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if(getPressedKey() == 'x' || getPressedKey() == 'X'){  //IntroStartExpertをインスタンス生成及び表示

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}

	}
}