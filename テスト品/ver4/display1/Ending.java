// 13�s��15�s��17�s��20�s��22�s��26�s��28�`33�s�ڂ��C��

package display1;

class Ending extends Display{

	@Override
	public void selector(){

		// System.out.println("���\��: 0 ��Exit��ʂ�"); // �e�X�g�\��
		// System.out.println("���\��: 1 ��StartDisplay��ʂ�"); // �e�X�g�\��

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��
		
			super.input();
			
			if(getPressedKey() == '2'){  //Exit.txt��\��
				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //StartDisplay���C���X�^���X�����y�ѕ\��
				
				super.answerNum = 0;
				super.courseLevel = 0;
				super.correctNum = 0;
				super.inCorrectNum = 0;

				StartDisplay start = new StartDisplay();
				start.display("StartDisplay.txt");
				// start.input();
				start.selector();
				flag = false;

			}else{  //���͂������l���������Ȃ��ꍇ���[�v����
				System.out.println("�������l����͂��Ă�������");
			}
		}
	}
}