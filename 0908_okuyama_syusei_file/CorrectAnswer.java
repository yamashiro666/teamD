//20�s��25�`65�s��67�s��69�s��71�s��73�s��77�s��79�s��82�s��86�s��88�s��91�s�ڂɏC���L��


package display1;

class CorrectAnswer extends Answer{

	void count(int level){

		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			correctNum++;
	}


	@Override
	public void selector(){
		if(getPressedKey() == '2'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == '1' && answerNum == 5){  //Result���C���X�^���X�����y�ѕ\��

			Result rst = new Result();


			// ���𐔂ɉ����ĕ]����ʂ��o��
			if(Answer.correctNum == 5) {

				// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
				rst.display("textfile/Result1.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
				System.out.println("�}�c�R�u��o������v");

			}else if(Answer.correctNum == 4) {

				// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
				rst.display("textfile/Result2.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
				System.out.println("�}�c�R�u�Ȃ��Ȃ�����ˁv");

			}else if(Answer.correctNum == 3) {

				// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
				rst.display("textfile/Result3.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
				System.out.println("�}�c�R�u�����Ƃ���΂�Ȃ����v");

			}else if(Answer.correctNum < 3) {

				// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
				rst.display("textfile/Result4.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
				System.out.println("�}�c�R�u�����������񂎂˂��������I�v");
			}


			//���𐔂ƕs���𐔂�\������
			System.out.println("���ʔ��\");
			System.out.println("���Ȃ��̐��т� ���� " +  Answer.correctNum + " �s���� " + Answer.inCorrectNum + " �ł�");
			System.out.println();
			System.out.println("1�F�m�d�w�s");
			System.out.println("2�F�d�w�h�s");

			rst.input();
			rst.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

			//�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			//System.out.println("TEST");
			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStart.txt");  //�e�L�X�g�t�@�C���C���ς�
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

			//�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("textfile/IntroStart.txt"); //�e�L�X�g�t�@�C���C���ς�
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

			//�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStart.txt"); //�e�L�X�g�t�@�C���C���ς�
			ise.input();
			ise.selector();

		}
	}
}