package display;

class IntroStartExpert extends Answer{
	
	//�ȉ��R�����g���������Ɖ����̃����_���o��͌��݊J����
	
	/*
	//�����t�@�C���̈ꎟ���z��15��ނ̉����t�@�C�����X�g����������
	
	//{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�}��2�����z��15��ނ̋Ȗڃ��X�g����������
	String songs[] = {
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		�`15���
	}
	
	@override
	void display(){
		//�J�E���g�_�E����ʂ�\������
		//�J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
		//�����t�@�C���̍Đ����Ɂ��\������
		//�����t�@�C���Đ���A���͑҂��̏�Ԃ����A�u��������͂��Ă��������v�ƕ\������
	}
	*/
	
	
	//�ȉ��R�����g��������������̏����͌��݊J����
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(/*���͂���������*/ == /*�����̕�����*/){  //CorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.answerNum == 0)CorrectAnswer correct = new CorrectAnswer();
			correct.display("Correct.txt");
			correct.count(3);
			correct.input();
			correct.selector();
		}else{  //InCorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.answerNum == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("InCorrectAnswer.txt");
			incorrect.count(3);
			incorrect.input();
			incorrect.selector();
		}
	}
}