package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display("Result.txt");

		//���𐔂ƕs���𐔂�\������
		System.out.println("���ʔ��\");
		System.out.println("���Ȃ��̐��т� ���� " +  Answer.correctNum + " �s���� " + Answer.inCorrectNum + " �ł�");


	}

	@Override
	public void selector(){

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

			super.input();

			if(getPressedKey() == 2){  //exit.txt��\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == 1){  //ending���C���X�^���X�����y�ѕ\��

				Display start = new StartDisplay();
				start.display("StartDisplay.txt");
				// end.input();
				start.selector();
				flag = false;

			}else{  // ���͂������l���������Ȃ��ꍇ���[�v����

				System.out.println("�������l����͂��Ă�������");

			}
		}
	}
}