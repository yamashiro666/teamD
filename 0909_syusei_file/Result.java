// 42�s��44�s��46�s��50�s��52�s��56�s��58�`63�s�ڂ��C��

package display1;

class Result extends Display{

	@Override
	public void display(String path){

		super.display("Result.txt");

		System.out.println(Answer.answerNum);
		// ���𐔂ƕs���𐔂�\������
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