package display1;

class Ending extends Display{

	@Override
	public void selector(){

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

			super.input();

			if(getPressedKey() == 2){  //Exit.txt��\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == 1){  //StartDisplay���C���X�^���X�����y�ѕ\��

				StartDisplay start = new StartDisplay();

				start.display("StartDisplay.txt");
				flag = true;

				// �����E�s���񐔃t�B�[���h�����Z�b�g����
				Answer.answerNum = 0;
				Answer.courseLevel = 0;
				Answer.correctNum = 0;
				Answer.inCorrectNum = 0;


			}else{  //���͂������l���������Ȃ��ꍇ���[�v����

				System.out.println("�������l����͂��Ă�������");

			}
		}
	}
}