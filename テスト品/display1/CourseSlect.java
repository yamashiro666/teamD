package display1;

public class CourseSlect extends Display{

	@Override
	public void selector(){

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == 'b' || getPressedKey() == 'B'){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

			IntroStartBeginner isb = new IntroStartBeginner();
			CountDown cd = new CountDown();
			cd.display("textfile/Countdown1.txt");
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if(getPressedKey() == 'm' || getPressedKey() == 'M'){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if(getPressedKey() == 'x' || getPressedKey() == 'X'){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}

	}
}