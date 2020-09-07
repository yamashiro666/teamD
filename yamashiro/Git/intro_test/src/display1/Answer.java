package display1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import random.RandomUniqueNumberGenerator;
import selector.LinkFileNameToMp3;
import selector.NameSelector;

class Answer extends Display{

	//�񓚐��̃t�B�[���h
	public static int answerNum;

	//�R�[�X���x���̃t�B�[���h
	public static int courseLevel;

	//���𐔂̃t�B�[���h
	public static int correctNum;

	//�s���𐔂̃t�B�[���h
	public static int inCorrectNum;

	//��L��4�t�B�[���h���i�[���郁�\�b�h
	public void count(){}

	/**
	 *  ���ŗ���mp3�̃t�@�C�����ɑΉ�����Ȗ����i�[����t�B�[���h
	 */
	String randomCollectedAnswer;

	/**
	 *  ���ŗ���mp3�̃t�@�C�������i�[����t�B�[���h
	 */
	String randomCollectedMp3;

	/**
	 * 4�����i�[����t�B�[���h
	 * A.�Z�Z�Z�Z   B.�Z�Z�Z�Z
	 * C.�Z�Z�Z�Z   D.�Z�Z�Z�Z
	 * �u�Z�Z�Z�Z�v�̕������i�[����
	 */
	String[] answers;

	/**
	 * 4�����i�[����t�B�[���h
	 * A.�Z�Z�Z�Z   B.�Z�Z�Z�Z
	 * C.�Z�Z�Z�Z   D.�Z�Z�Z�Z
	 * �uA, B, C, D�v�̕������i�[����
	 */
	char charCorrectAnswer;

	// 0�`10�̗����BsongFileName[]��songsTitleName[][]����N�C�Y�ɕK�v�ȉ����t�@�C���ƋȖ����X�g�������_���Ŏ擾���鎞�Ɏg�p
	int randomNum;

	// charCorrectAnswer (�I������ A, B, C, D ����)�� answers(�I������ �����񕔕�) ��R�t���邽�߂̃t�B�[���h
	Map<String, Character> tmpAnswer;



	/**
	 *  answers[] ���V���b�t������ charCorrectAnswer(�I���� A, B, C, D) �Ƀ����_���Ŕz�u���郁�\�b�h
	 */
	public void shuffle4Taku(){

		// Romdom�N���X��1����10�̗�������
		Random random = new Random();
		randomNum = random.nextInt(9);
		List<String> kyokumeiList;

		// 4�� A, B, C, D�Ɋi�[���镶����z���������
		answers = new String[3];

		/*
		 *  0 ���� 3 �܂ł� ���Ԃ�Ȃ����� �� ����
		 *  ���̗�����answers�z���index�ɓ��Ă�
		 */
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(3);
		// ��������������Ă��邩�̊m�F�p��sysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		/*
		 *  0 ���� 8 �܂ł� ���Ԃ�Ȃ����� �� ����
		 *  ���̗�����answers�z���index�ɓ��Ă�
		 */
		int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(8);
		// ��������������Ă��邩�̊m�F�p��sysout
//		for(int i = 0; i < randomN2.length; i++) {
//
//			System.out.println(randomN2[i]);
//		}

		// SentakushiXX.txt ���i�[����Ă���t�H���_���� �����_����Sentakushi�t�@�C������I��
		NameSelector s = new NameSelector();

		s.getFileNameList().forEach(e -> {
			List<String> fileNameList = s.getFileNameList();

		});

		String sentakushiFileName = s.getRomdomTextFileName("Sentakushi01.txt");
		kyokumeiList = s.readTextFile(sentakushiFileName);
		 Collections.shuffle(kyokumeiList);


		// �擾����mp3���X�g�̒��ł���answerMp3�ƍ��v�������̂������
		// �I����(answers[])�̒��ɕ�����������_���ő�����Ă䂭
		if(link.linkedList.containsKey(randomCollectedAnswer)) {
			for(int i = 0; i <  kyokumeiList.size(); i++) {
				answers[randomN1[0]] = randomCollectedAnswer;
				answers[randomN1[1]] = s.getRandomTltleName()[0];
				answers[randomN1[2]] = s.getRandomTltleName()[1];
				answers[randomN1[3]] = s.getRandomTltleName()[2];
			}
		}


		super.display("SelectAnswer.txt");

		// Sysout�ŕ\���Banswer[]�̂����ǂꂩ��ɓ����̕����񂪓����Ă���B
		System.out.println("������I��ł�");
		System.out.println("A . " + answers[0] + "   B . " +  answers[1]);
		System.out.println("C . " + answers[2] + "   D . " +  answers[3]);

		// �I����(A, B, C, D) �� �I�����ɑΉ�����Ȗ� ��R�t���鏈�����s��
		tmpAnswer = new HashMap<String, Character>(){
			{
				put(answers[0], 'A');
				put(answers[1], 'B');
				put(answers[2], 'C');
				put(answers[3], 'D');
			}
		};
	} // shuffle4Taku() �I���

	@Override
	public void selector(){
		LinkFileNameToMp3 link = new LinkFileNameToMp3("music_title.txt");
		int random = new Random().nextInt(link.linkedList.size());
		// �����_���ɓ����̕������I�� randomCorrectedAnswers �ɑ��
		String randomCorrectedMp3 = link.linkedList.get(random);
		String randomCorrectedAnswer = LinkFileNameToMp3.getKeysByValue(link.linkedList, randomCorrectedMp3).toString();


		// mp3�̃t�@�C���� ���L�[�� �Ȗڃ��X�g ���� �����̕����� ���擾


		// 4���̔z��̐���for�����񂵁A�I�����̒����瓚������������charCorrectAnswer�ɑ��
		for(int i = 0; i < answers.length; i++) {
			if(linkedTextToMp3.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("Exit.txt");

		}else if(getPressedKey() == charCorrectAnswer){  //CorrectAnswer���C���X�^���X�����y�ѕ\��

			//if(answerNum == 0) {
				CorrectAnswer correct = new CorrectAnswer();
				correct.display("CorrectAnswer.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); //���𐔂��J�E���g����
				correct.input();
				correct.selector();
			//}


		}else if(getPressedKey() != charCorrectAnswer){  //InCorrectAnswer���C���X�^���X�����y�ѕ\��

			//if(answerNum == 0) {
				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); //�s���𐔂��J�E���g����
				incorrect.input();
				incorrect.selector();
			//}

		}
	}

}