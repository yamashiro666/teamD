//23�s��25�s��31�s��35�`39�s��45�s��47�s��53�s��55�s��61�s��63�`68�s�ڂ��C��

/*
 * 9��9���ǋL
 * �E�J�E���g�_�E���̉��Đ���CountDown�N���X���ł܂Ƃ߂ď����ł���悤�ɕύX
 */
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
		
		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��
			
			super.input();
			
			if(getPressedKey() == '2'){  // Exit���C���X�^���X�����y�ѕ\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1' && answerNum == 5){  // Result���C���X�^���X�����y�ѕ\��

				Result rst = new Result();
				rst.display("Result.txt");
				// rst.input();
				rst.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  // IntroStartBeginner���C���X�^���X�����y�ѕ\��

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  // IntroStartMedium���C���X�^���X�����y�ѕ\��

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  // IntroStartExpert���C���X�^���X�����y�ѕ\��

				Answer ise = new IntroStartExpert();
				ise.display("IntroStartExpert.txt");
				// ise.input();
				ise.selector();
				flag = false;

			}else{  // ���͂������l���������Ȃ��ꍇ���[�v����
					System.out.println("�������l����͂��Ă�������");
			}
		}
	}
}