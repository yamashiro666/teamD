package display;

class IntroStartMedium extends Answer{
	
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
		//�����t�@�C���Đ���A�Ȗڃ��X�g�𗘗p���A�����Ȗ�1�Ȃƕs�����Ȗ�3�Ȃ������_���Ŕz�u���A�\������
	}
	*/
	
	
	//�ȉ��R�����g��������������̏����͌��݊J����
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(getPressedKey() == /*�����̃L�[*/){  //CorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.answerNum == 0)CorrectAnswer correct = new CorrectAnswer();
			correct.display("correct.txt");
			correct.count(2);
			correct.input();
			correct.selector();
		}else if(getPressedKey() == /*�s�����̃L�[*/){  //InCorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.answerNum == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("InCorrectAnswer.txt");
			incorrect.count(2);
			incorrect.input();
			incorrect.selector();
		}
	}
}