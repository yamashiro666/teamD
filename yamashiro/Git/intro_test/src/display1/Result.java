package display1;

class Result extends Display{

	@Override
	public void selector(){

		flag = true;

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

			this.input();

			if(getPressedKey() == '2'){  //exit.txt��\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //�R���e�j���[���(StartDisplay)���C���X�^���X�����y�ѕ\��

				Display start = new StartDisplay();
				start.display("StartDisplay.txt");
				start.selector();
				flag = true;

			}else{  // ���͂������l���������Ȃ��ꍇ���[�v����

				System.out.println("�������l����͂��Ă�������");

			}
		}
	}
}