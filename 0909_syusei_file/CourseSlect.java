//10�s��12�s��18�s��24�s��26�s��32�s��34�s��40�s��42�`47�s�ڂ��C��

package display1;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

			super.input();

			if(getPressedKey() == '4'){  //Exit���C���X�^���X�����y�ѕ\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '2'){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '3'){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

				Answer ise = new IntroStartExpert();
				ise.display("IntroStartExpert.txt");
				// ise.input();
				ise.selector();
				flag = false;

			}else{  //���͂������l���������Ȃ��ꍇ���[�v����
					System.out.println("�������l����͂��Ă�������");
			}
		}

	}
}