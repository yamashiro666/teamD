package display1;

abstract class Answer extends Display implements CorrectAnswer, InCorrectAnswer{

	// ���𐔃J�E���g�p�̃��X�g
	int correctCount;

	// �s���𐔃J�E���g�p�̃��X�g
	int inCorrectCount;

	// ���𐔂��J�E���g���郁�\�b�h
	public void correctCount(){
		this.correctCount += 1;
	}

	// �s�𐔂��J�E���g���郁�\�b�h
	public void inCorrectCount(){
		this.inCorrectCount += 1;
	}

	@Override
	public void selector(){

		/*
		 * �ȉ��̏�����if���ŏ������򂷂�
		 *
		 * �����ꂽ�L�[��
		 * �P�D0 �̎� --> Exit��ʂ�\������
		 * �Q�D1 �̎� --> ���̖���ʂɐi��
		 */
		if(getPressedKey() == 0){ // �����ꂽ�L�[�� 0 �̎� -> // Exit.txt��\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		/*
		 *  �P�D�����ꂽ�L�[�� 0 �̎� ���� ���𐔂ƕs���𐔂̍��v�� 5 �̎�
		 *  Result���C���X�^���X�����y�ѕ\��
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) == 5){

			Result rst = new Result();
			rst.display("textfile/Result.txt");
			rst.input();
			rst.selector();

		/*
		 *  �Q�D�����ꂽ�L�[�� 0 �̎� ���� ���𐔂ƕs���𐔂̍��v�� 5 �ȉ�
		 *  ���� ���̃��\�b�h���Ăяo�����C���X�^���X�� IntroStartBignner �̂Ƃ�
		 *  ��
		 *  Result���C���X�^���X�����y�ѕ\��
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartBeginner)){ // �����ꂽ�L�[�� 0 �̎� ���� // IntroStartBeginner���C���X�^���X�����y�ѕ\��

			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		/*
		 *  �Q�D�����ꂽ�L�[�� 0 �̎� ���� ���𐔂ƕs���𐔂̍��v�� 5 �ȉ�
		 *  ���� ���̃��\�b�h���Ăяo�����C���X�^���X�� IntroStartMedium �̂Ƃ�
		 *  ��
		 *  Result���C���X�^���X�����y�ѕ\��
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartMedium)){  // IntroStartMedium���C���X�^���X�����y�ѕ\��

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("textfile/IntroStartMedium.txt");
			ism.input();
			ism.selector();

		/*
		 *  �Q�D�����ꂽ�L�[�� 0 �̎� ���� ���𐔂ƕs���𐔂̍��v�� 5 �ȉ�
		 *  ���� ���̃��\�b�h���Ăяo�����C���X�^���X�� IntroStartExpart �̂Ƃ�
		 *  ��
		 *  Result���C���X�^���X�����y�ѕ\��
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartExpert)){  // IntroStartExpert���C���X�^���X�����y�ѕ\��

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}else{
			System.out.println("�K�؂Ȑ��l����͂��Ă��������B");
		}
	}

}