package display1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import random.RandomUniqueNumberGenerator;

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

	// ���ŗ���mp3�̃t�@�C�������i�[����t�B�[���h
	String answerMp3;

	/*
	 * 4�����i�[����t�B�[���h
	 * A.�Z�Z�Z�Z   B.�Z�Z�Z�Z
	 * C.�Z�Z�Z�Z   D.�Z�Z�Z�Z
	 * �u�Z�Z�Z�Z�v�̕������i�[����
	 */
	String[] answers;

	/*
	 * 4�����i�[����t�B�[���h
	 * A.�Z�Z�Z�Z   B.�Z�Z�Z�Z
	 * C.�Z�Z�Z�Z   D.�Z�Z�Z�Z
	 * �uA, B, C, D�v�̕������i�[����
	 */
	char charCorrectAnswer;

	// 0�`10�̗����BsongFileName[]��songsTitleName[][]����N�C�Y�ɕK�v�ȉ����t�@�C���ƋȖ����X�g�������_���Ŏ擾���鎞�Ɏg�p
	int randomNum;

	// answerMp3 (mp3�t�@�C���̖��O) �� songsTitleName �� �����Ȗ� ��R�t���邽�߂̃t�B�[���h
	// Map< answerMp3 , �����Ȗ� >�ŊǗ�
	Map<String, String> linkedMp3;

	// charCorrectAnswer (�I������ A, B, C, D ����)�� answers(�I������ �����񕔕�) ��R�t���邽�߂̃t�B�[���h
	Map<String, Character> tmpAnswer;

	//�����t�@�C���̈ꎟ���z��15��ނ̉����t�@�C�����X�g����������
	String songsFileName[] = {

		/*
		 *  �t�H���_�ɂ��鉹������t�@�C�������擾����
		 *  ���̔z��Ɋi�[���邱�Ƃ��\
		 */
		"music1.mp3",
		"music2.mp3",
		"music3.mp3",
		"music4.mp3",
		"music5.mp3",
		"music6.mp3",
		"music7.mp3",
		"music8.mp3",
		"music9.mp3",
		"music10.mp3"
	};

	// �����Ȗ�1��,  �s�����Ȗ�9�Ȃ�2�����z��10��ނ̋Ȗڃ��X�g����������
	String songsTitleName[][] = {

		/*
		 *  �ȉ��̔z��̓e�L�X�g�t�@�C���ŕʓr�ۑ����\
		 */
		{"�����Ȗ�1-1", "�s�����Ȗ�1-2", "�s�����Ȗ�1-3", "�s�����Ȗ�1-4", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�", "�s�����Ȗ�"},
		{"�����Ȗ�2-1", "�s�����Ȗ�2-2", "�s�����Ȗ�2-3", "�s�����Ȗ�2-4", "�s�����Ȗ�2-5", "�s�����Ȗ�2-6", "�s�����Ȗ�2-7", "�s�����Ȗ�2-8", "�s�����Ȗ�2-9", "�s�����Ȗ�2-10"},
		{"�����Ȗ�3-1", "�s�����Ȗ�3-2", "�s�����Ȗ�3-3", "�s�����Ȗ�3-4", "�s�����Ȗ�3-5", "�s�����Ȗ�3-6", "�s�����Ȗ�3-7", "�s�����Ȗ�3-8", "�s�����Ȗ�3-9", "�s�����Ȗ�3-10"},
		{"�����Ȗ�4-1", "�s�����Ȗ�4-2", "�s�����Ȗ�4-3", "�s�����Ȗ�4-4", "�s�����Ȗ�4-5", "�s�����Ȗ�4-6", "�s�����Ȗ�4-7", "�s�����Ȗ�4-8", "�s�����Ȗ�4-9", "�s�����Ȗ�4-10"},
		{"�����Ȗ�5-1", "�s�����Ȗ�5-2", "�s�����Ȗ�5-3", "�s�����Ȗ�5-4", "�s�����Ȗ�5-5", "�s�����Ȗ�5-6", "�s�����Ȗ�5-7", "�s�����Ȗ�5-8", "�s�����Ȗ�5-9", "�s�����Ȗ�5-10"},
		{"�����Ȗ�6-1", "�s�����Ȗ�6-2", "�s�����Ȗ�6-3", "�s�����Ȗ�6-4", "�s�����Ȗ�6-5", "�s�����Ȗ�6-6", "�s�����Ȗ�6-7", "�s�����Ȗ�6-8", "�s�����Ȗ�6-9", "�s�����Ȗ�6-10"},
		{"�����Ȗ�7-1", "�s�����Ȗ�7-2", "�s�����Ȗ�7-3", "�s�����Ȗ�7-4", "�s�����Ȗ�7-5", "�s�����Ȗ�7-6", "�s�����Ȗ�7-7", "�s�����Ȗ�7-8", "�s�����Ȗ�7-9", "�s�����Ȗ�7-10"},
		{"�����Ȗ�8-1", "�s�����Ȗ�8-2", "�s�����Ȗ�8-3", "�s�����Ȗ�8-4", "�s�����Ȗ�8-5", "�s�����Ȗ�8-6", "�s�����Ȗ�8-7", "�s�����Ȗ�8-8", "�s�����Ȗ�8-9", "�s�����Ȗ�8-10"},
		{"�����Ȗ�9-1", "�s�����Ȗ�9-2", "�s�����Ȗ�9-3", "�s�����Ȗ�9-4", "�s�����Ȗ�9-5", "�s�����Ȗ�9-6", "�s�����Ȗ�9-7", "�s�����Ȗ�9-8", "�s�����Ȗ�9-9", "�s�����Ȗ�9-10"},
		{"�����Ȗ�10-1", "�s�����Ȗ�10-2", "�s�����Ȗ�10-3", "�s�����Ȗ�10-4", "�s�����Ȗ�10-5", "�s�����Ȗ�10-6", "�s�����Ȗ�10-7", "�s�����Ȗ�10-8", "�s�����Ȗ�10-9", "�s�����Ȗ�10-10"},
	};


	/*
	 *  linkMp3toText()���\�b�h�̓��e
	 *  mp3�̃t�@�C�����ƋȖڃ��X�g��R�t����
	 *  1.  Map�쐬(HashMap<String, String>)
	 *  2.  �����̃t�@�C������songsTitleName�z��̊e�擪�ɂ��鐳���̕������for���ɂĊi�[���Ă䂭
	 */
	Map<String,String> linkMp3toText() {

		// 1.  Map�쐬(HashMap<String, String>)
		linkedMp3 = new HashMap<String,String>(){
			{
				if(songsFileName.length == songsTitleName.length) {
						for(int i = 0; i  < songsFileName.length; i++) {
							// 2.  �����̃t�@�C������songsTitleName�z��̊e�擪�ɂ��鐳���̕������for���ɂĊi�[���Ă䂭
							put(songsFileName[i], songsTitleName[i][0]);
					}
				}
			}
		};

		// 3.  �i�[���I�������return����
		return linkedMp3;
	}


	// answers[] ���V���b�t������ charCorrectAnswer(�I���� A, B, C, D) �Ƀ����_���Ŕz�u���郁�\�b�h
	public void shuffle4Taku(){
		// linkMp3toText()���\�b�h�� mp3�̃t�@�C������ �Ȗڃ��X�g�̐����̕����� ��R�t����
		linkMp3toText();

		// Romdom�N���X��1����10�̗�������
		Random random = new Random();
		randomNum = random.nextInt(9);

//		// �J�E���g�_�E����ʂ�\������ & �����t�@�C���̍Đ����Ɂ��\������
//		CountDown cd = new CountDown();
//		cd.display("textfile/Countdown1.txt");

//		answerMp3 = songsFileName[randomNum];

//		// �J�E���g�_�E����A�����t�@�C���������_���őI�����Đ�����
//		// playMp3���\�b�h��static���\�b�h�ɂ��܂����B
//		Music.playMp3Thread("ongen/" + answerMp3).start();  //songFileName[]�̂����ꂩ���Đ�

		// �I�����ɕ\�����镶������i�[���镶����
		answers = new String[4];

		// 0 ���� 4 �܂ł� ���Ԃ�Ȃ����� �� ����
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(4);
		// ��������������Ă��邩�̊m�F�p��sysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		// 0 ���� 8 �܂ł� ���Ԃ�Ȃ����� �� ����
		int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(8);
		// ��������������Ă��邩�̊m�F�p��sysout
//		for(int i = 0; i < randomN2.length; i++) {
//
//			System.out.println(randomN2[i]);
//		}

		// �����t�@�C���Đ���A�Ȗڃ��X�g�𗘗p���A�����Ȗ�1�Ȃƕs�����Ȗ�1�Ȃ������_���Ŕz�u���A�\������
		for(int i = 0; i < songsTitleName.length; i++) {

			/*
			 *  1.  linkedMp3.get()���\�b�h�� answerMp3(mp3�t�@�C���̃t�@�C����) �ɕR�t���Ă��� songsTitleName[i][0] (�����Ȗ�) ���擾
			 *  2.  if���� songsTitleName[i][0] (�����Ȗ�) �� ��Ŏ擾�����������r
			 *  3.  true�Ȃ炻�̔z��̒��ɓ���
			 *  4.  songsTitleName[i][0] (�����Ȗ�) �� answers[](�I����) �̂ǂꂩ1�ɑ������B
			 *  5.  songsTitleName[i][1����3] (�s�����Ȗ�) �������_���őI�сA�c���3���ɑ��
			 */
			if(songsTitleName[i][0].equals(linkedMp3.get(answerMp3))){
				answers[randomN1[0]] = songsTitleName[i][0];
				answers[randomN1[1]] = songsTitleName[i][randomN2[1]+1];
				answers[randomN1[2]] = songsTitleName[i][randomN2[2]+1];
				answers[randomN1[3]] = songsTitleName[i][randomN2[3]+1];
			}

		}

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

		// mp3�̃t�@�C���� ���L�[�� �Ȗڃ��X�g ���� �����̕����� ���擾
		String linkedTextToMp3 = linkedMp3.get(answerMp3);

		// 4���̔z��̐���for�����񂵁A�I�����̒����瓚������������charCorrectAnswer�ɑ��
		for(int i = 0; i < answers.length; i++) {
			if(linkedTextToMp3.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == charCorrectAnswer){  //CorrectAnswer���C���X�^���X�����y�ѕ\��

			//if(answerNum == 0) {
				CorrectAnswer correct = new CorrectAnswer();
				correct.display("textfile/CorrectAnswer.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); //���𐔂��J�E���g����
				correct.input();
				correct.selector();
			//}


		}else if(getPressedKey() != charCorrectAnswer){  //InCorrectAnswer���C���X�^���X�����y�ѕ\��

			//if(answerNum == 0) {
				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("textfile/InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); //�s���𐔂��J�E���g����
				incorrect.input();
				incorrect.selector();
			//}

		}
	}

}