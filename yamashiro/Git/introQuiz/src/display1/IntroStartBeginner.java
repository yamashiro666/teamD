package display1;

import java.util.HashMap;
import java.util.Map;

class IntroStartBeginner extends Answer{

	//�����t�@�C���̈ꎟ���z��15��ނ̉����t�@�C�����X�g����������

	//{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�}��2�����z��15��ނ̋Ȗڃ��X�g����������
	String[][] songs = {
		{"�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�"},
		{"�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�"},
		// �`15���
	};

	void test() {
		Map<Character,String> map = new HashMap<Character,String>();
	}

	@Override
	public void display(String textFilePath){
		super.display(textFilePath);
		//�J�E���g�_�E����ʂ�\������
		//�J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
		//�����t�@�C���̍Đ����Ɂ��\������
		//�����t�@�C���Đ���A�Ȗڃ��X�g�𗘗p���A�����Ȗ�1�Ȃƕs�����Ȗ�1�Ȃ������_���Ŕz�u���A�\������
	}

	@Override
	public void selector(){

		if(getPressedKey() == 0){  //Exit.txt��\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == songs[i][0]){  //CorrectAnswer���C���X�^���X�����y�ѕ\��

			if(super.correctCount == 0) {

				Answer correct = new IntroStartBeginner();

				correct.display("textfile/Correct.txt");
				correct.correctCount(); // ���𐔂��J�E���g����
				correct.input();
				correct.selector();

			}
		}else if(getPressedKey() == songs[i][1] || getPressedKey() == songs[i][2] || getPressedKey() == songs[i][3]){  //inCorrectAnswer���C���X�^���X�����y�ѕ\��

			if(super.inCorrectCount == 0){

				Answer incorrect = new IntroStartBeginner();

				incorrect.display("textfile/InCorrectAnswer.txt");
				incorrect.inCorrectCount(); // �s���𐔂��J�E���g����
				incorrect.input();
				incorrect.selector();

			}

		}else{

			System.out.println("�K�؂Ȑ��l����͂��Ă��������B");

		}
	}
}