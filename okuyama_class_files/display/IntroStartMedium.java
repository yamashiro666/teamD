class IntroStartMedium extends Answer{
	
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
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txt��\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == songs[i][0]){  //correctAnswer���C���X�^���X�����y�ѕ\��
			if(super.correctCount.length == 0)CorrectAnswer correct = new CorrectAnswer();
			correct.display("correct.txt");
			correct.count();
			correct.input();
			correct.selector();
		}else if(args[0] == songs[i][1] || args[0] == songs[i][2] || args[0] == songs[i][3]){  //inCorrectAnswer���C���X�^���X�����y�ѕ\��
			if(super.inCorrectCount.length == 0)InCorrectAnswer incorrect = new InCorrectAnswer();
			incorrect.display("inCorrectAnswer.txt");
			incorrect.count();
			incorrect.input();
			incorrect.selector();
		}else{
			System.out.println("�K�؂Ȑ��l����͂��Ă��������B");
		}
	}
}