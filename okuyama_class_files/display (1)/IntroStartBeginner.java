package display;

import sound.Music;

class IntroStartBeginner extends Answer{
	
	/*
	//�ȉ��R�����g���������Ɖ����̃����_���o��͌��݊J����
	
	
	//�����t�@�C���̈ꎟ���z��15��ނ̉����t�@�C�����X�g����������
	String songsFileName[] = {
		"1.mp3",
		"2.mp3",
		"3.mp3",
		"4.mp3",
		"5.mp3",
		"6.mp3",
		"7.mp3",
		"8.mp3",
		"9.mp3",
		"10.mp3"
	}
	
	//�����Ȗ�1��, �s�����Ȗ�9�Ȃ�2�����z��10��ނ̋Ȗڃ��X�g����������
	String songsTitleName[][] = {
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
	}
	
	//0�`10�̗����BsongFileName[]��songsTitleName[][]����N�C�Y�ɕK�v�ȉ����t�@�C���ƋȖ����X�g�������_���Ŏ擾���鎞�Ɏg�p
	int 
	;
	
	@override
	void display(){
		//�J�E���g�_�E����ʂ�\������
		xxx
		
		//�����t�@�C���̍Đ����Ɂ��\������
		xxx
		
		//�J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
		Music sound = new Music();
		sound.playMp3Thread(songFileName[/*0�`10�̗���*/]).start(); //songFileName[]�̂����ꂩ���Đ�
		
		//�����t�@�C���Đ���A�Ȗڃ��X�g�𗘗p���A�����Ȗ�1�Ȃƕs�����Ȗ�1�Ȃ������_���Ŕz�u���A�\������
		
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
			correct.display("Correct.txt");
			correct.count(1); //���𐔂��J�E���g����
			correct.input();
			correct.selector();
		}else if(getPressedKey() == /*�s�����̃L�[*/){  //InCorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.answerNum == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("InCorrectAnswer.txt");
			incorrect.count(1); //�s���𐔂��J�E���g����
			incorrect.input();
			incorrect.selector();
		}
	}
}