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

			if(getPressedKey() == '2'){  //Exit���C���X�^���X�����y�ѕ\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1' && answerNum == 5){  //Result���C���X�^���X�����y�ѕ\��

				Result rst = new Result();

				// ���𐔂ɉ����ĕ]����ʂ��o��
				if(Answer.correctNum == 5) {

					// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
					rst.display("Result1.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
					System.out.println("�}�c�R�u��o������v");

				}else if(Answer.correctNum == 4) {

					// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
					rst.display("Result2.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
					System.out.println("�}�c�R�u�Ȃ��Ȃ�����ˁv");

				}else if(Answer.correctNum == 3) {

					// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
					rst.display("Result3.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
					System.out.println("�}�c�R�u�����Ƃ���΂�Ȃ����v");

				}else if(Answer.correctNum < 3) {

					// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
					rst.display("Result4.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
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
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  //IntroStartMedium���C���X�^���X�����y�ѕ\��

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  //IntroStartExpert���C���X�^���X�����y�ѕ\��

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