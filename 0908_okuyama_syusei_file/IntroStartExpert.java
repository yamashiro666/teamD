//51�s��58�s�ڂɏC���L��


package display1;

import sound.Music;

class IntroStartExpert extends Answer{
//
//	//�����t�@�C���̈ꎟ���z��15��ނ̉����t�@�C�����X�g����������
//
//	//{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�}��2�����z��15��ނ̋Ȗڃ��X�g����������
//	String songs[] = {
//		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
//		{�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�, �s�����Ȗ�},
//		�`15���
//	}
//
//	@override
//	void display(){
//		//�J�E���g�_�E����ʂ�\������
//		//�J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
//		//�����t�@�C���̍Đ����Ɂ��\������
//		//�����t�@�C���Đ���A���͑҂��̏�Ԃ����A�u��������͂��Ă��������v�ƕ\������
//	}


	@Override
	public void display(String path){

		// �J�E���g�_�E����ʂ�\������ & �����t�@�C���̍Đ����Ɂ��\������
		CountDown cd = new CountDown();
		cd.display("textfile/Countdown1.txt");

		answerMp3 = songsFileName[randomNum];

		// �J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
		// playMp3���\�b�h��static���\�b�h�ɂ��܂����B
		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]�̂����ꂩ���Đ�

		super.shuffle4Taku();
	}

//
//	@override
//	void selector(){
//		if(args[0] == 0){  //exit.txt��\��
//			Exit exit = new Exit();
//			exit.display(exit.txt);
//		}else if(args[0] == songs[i][0]){  //correctAnswer���C���X�^���X�����y�ѕ\��
			//����p���ʉ��̗p�ӂ��K�v
//			if(super.correctCount.length == 0)CorrectAnswer correct = new CorrectAnswer();
//			correct.display("correct.txt");
//			correct.count();
//			correct.input();
//			correct.selector();
//		}else{  //inCorrectAnswer���C���X�^���X�����y�ѕ\��
			//�s����p���ʉ��̗p�ӂ��K�v
//			if(super.inCorrectCount.length == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
//			incorrect.display("inCorrectAnswer.txt");
//			incorrect.count();
//			incorrect.input();
//			incorrect.selector();
//		}
//	}
}