package display1;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		if(getPressedKey() == '4'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if(getPressedKey() == '1'){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

			Answer isb = new IntroStartBeginner();
			isb.display("IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '2'){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

			Answer ism = new IntroStartMedium();
			ism.display("IntroStartMedium.txt");
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '3'){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

			Answer ise = new IntroStartExpert();
			ise.display("IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}

	}
}