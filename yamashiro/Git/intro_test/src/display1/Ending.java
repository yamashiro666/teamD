package display1;

class Ending extends Display{

	@Override
	public void selector(){

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

			super.input();

			if(getPressedKey() == 2){  //Exit.txt��\��

				Exit exit = new Exit();
				exit.display("Exit.txt");

			}else if(getPressedKey() == 1){  //StartDisplay���C���X�^���X�����y�ѕ\��

				StartDisplay start = new StartDisplay();

				start.display("StartDisplay.txt");
				start.input();
				start.selector();

			}else{  //���͂������l���������Ȃ��ꍇ���[�v����

				System.out.println("�������l����͂��Ă�������");

			}
		}
	}
}