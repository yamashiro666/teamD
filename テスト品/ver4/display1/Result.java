// 10�`45�s��52�s��54�s��60�s��66�s��68�`73�s�ڂ��C��

package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display(path);

		// ���𐔂ɉ����ĕ]����ʂ��o��
		if(Answer.correctNum == 5) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			super.display("Result1.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
			System.out.println("�}�c�R�u��o������v");

		}else if(Answer.correctNum == 4) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			super.display("Result2.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
			System.out.println("�}�c�R�u�Ȃ��Ȃ�����ˁv");

		}else if(Answer.correctNum == 3) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			super.display("Result3.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
			System.out.println("�}�c�R�u�����Ƃ���΂�Ȃ����v");

		}else if(Answer.correctNum < 3) {

			// �]����ʂ̃N���X�������display���\�b�h�ŌĂяo��
			super.display("Result4.txt"); //�e�L�X�g�t�@�C���̍쐬���K�v
			System.out.println("�}�c�R�u�����������񂎂˂��������I�v");
		}

		
		// ���𐔂ƕs���𐔂�\������
		System.out.println();
		System.out.println("���Ȃ��̐��т� ���� " +  Answer.correctNum + " �s���� " + Answer.inCorrectNum + " �ł�");
		System.out.println();
		System.out.println("�@�@�@�@�@1�F�G���f�B���O");
		System.out.println("�@�@�@�@�@2�F�I��");
		System.out.println();

	}

	@Override
	public void selector(){
		
		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��
		
			super.input();
			
			if(getPressedKey() == '2'){  //exit.txt��\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //ending���C���X�^���X�����y�ѕ\��

				Ending end = new Ending();
				end.display("Ending.txt");
				// end.input();
				end.selector();
				flag = false;

			}else{  // ���͂������l���������Ȃ��ꍇ���[�v����
				System.out.println("�������l����͂��Ă�������");
			}
		}
	}
}