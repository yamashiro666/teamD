package display1;

class Result extends Display{

	@Override
	public void display(String path){


		//���𐔂ƕs���𐔂�\������
		System.out.println("���ʔ��\");
		System.out.println("���Ȃ��̐��т� ���� " +  Answer.correctNum + " �s���� " + Answer.inCorrectNum + " �ł�");


		// ���܂�: ���𐔂ɉ����ĕ]����ʂ��o��
		if(Answer.correctNum == 5) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			System.out.println("�}�c�R�u��o������v");
		}else if(Answer.correctNum == 4) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			System.out.println("�}�c�R�u�Ȃ��Ȃ�����ˁv");
		}else if(Answer.correctNum == 3) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			System.out.println("�}�c�R�u�����Ƃ���΂�Ȃ����v");
		}else if(Answer.correctNum < 3) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			System.out.println("�}�c�R�u�����������񂎂˂��������I�v");
		}

	}

	@Override
	public void selector(){
		if(getPressedKey() == 0){  //exit.txt��\��

			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == 1){  //ending���C���X�^���X�����y�ѕ\��

			Ending end = new Ending();
			end.display("texfile/Ending.txt");
			end.input();
			end.selector();

		}
	}
}