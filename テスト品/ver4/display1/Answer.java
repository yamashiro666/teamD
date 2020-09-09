//167�s��169�s��175�s��187�s��189�s��201�s��203�`208�s�ڂ��C��

package display1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.InputStreamReader;

import random.RandomUniqueNumberGenerator;
import selector.NameSelector;
import sound.Music;
import sound.Sounds;

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

		// 4�� A, B, C, D�Ɋi�[���镶����z���������
		answers = new String[4];

		/*
		 *  0 ���� 3 �܂ł� ���Ԃ�Ȃ����� �� ����
		 *  ���̗�����answers�z���index�ɓ��Ă�
		 */
		int[] randomN1 = RandomUniqueNumberGenerator.randomNoGenerator(4);
		// ��������������Ă��邩�̊m�F�p��sysout
//		for(int i = 0; i < randomN1.length; i++) {
//			System.out.println(randomN1[i]);
//		}


		// SentakushiXX.txt ���i�[����Ă���t�H���_���� �����_����Sentakushi�t�@�C������I��
		NameSelector s = new NameSelector();

		String dirName;

		// Sentakushi01.txt ���������Ă���t�H���_���̃p�X���擾
		dirName = s.setDirName("Sentakushi01.txt");

		// System.out.println("Answer�N���X��Sysout: �ϐ�dirName: " + dirName);

		// SentakushiXX.txt �̕����񃊃X�g���擾
		s.setTxtFileNameList(dirName);
		// System.out.println(s.setTxtFileNameList(dirName));

		// fileNameList �t�B�[���h(Sentakushi.txt�̃��X�g)���V���b�t������
		Collections.shuffle(s.textFileNameList);

		// System.out.println("randomCollectedAnswer : " + randomCollectedAnswer);
		// fileNameList�t�B�[���h(Sentakushi??.txt�̃��X�g) �̐���for������
		for(int i = 0; i < s.textFileNameList.size(); i++) {

			// Windows �̏ꍇ
			String tmp = s.textFileNameList.get(i).replaceAll(".*\\\\", "");
			// Mac�̏ꍇ
			// String tmp = s.textFileNameList.get(i).replaceAll(".*\\/", "");

			List<String> tmp2 = s.readTextFile(tmp);

			// fileNameList�t�B�[���h(Sentakushi??.txt�̃��X�g) �̒����g��for���łЂƂÂ��X�g�A�b�v���Ă䂭
			 for(int j = 0; j < tmp2.size(); j++) {

				 String tmp3 = tmp2.get(j);

				 // System.out.println(tmp3);
				 if(randomCollectedAnswer.equals(tmp3)){

						// Sentakushi??.txt �t�@�C���ɋL�q����Ă���Ȗ����̗v�f�������Ԃ�Ȃ��悤�ɁA�����_���Ŏ擾
						int[] randomN2 = RandomUniqueNumberGenerator.randomNoGenerator(tmp2.size());
						// 4���̕�����z��ɑ�����Ă䂭
						answers[randomN1[0]] = randomCollectedAnswer; // ��������
						answers[randomN1[1]] = tmp2.get(randomN2[1]); // �c��͕s�����̋Ȗ�����
						answers[randomN1[2]] = tmp2.get(randomN2[2]); // +1 ���Ă���̂͐擪�̐����̋Ȗ����I�΂�Ȃ��悤�ɂ��邽��
						answers[randomN1[3]] = tmp2.get(randomN2[3]);
				}
			 }
		}

		super.display("SelectAnswer.txt");

		// Sysout�ŕ\���Banswer[]�̂����ǂꂩ��ɓ����̕����񂪓����Ă���B
		System.out.println("������I��ł�");
		System.out.println("A . " + String.format("%20s",  answers[0] ) + "   B . " +  String.format("%20s",  answers[1]));
		System.out.println("C . " + String.format("%20s",  answers[2] ) + "   D . " +  String.format("%20s",  answers[3]));

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

		// 4���̕�����z���randomCollectedAnswer���r���č��v�����Ƃ��� charCorrectAnswer �� 4���̒��ɂ���A,B,C,D�̓�������
		for(int i = 0; i < answers.length; i++) {
			if(randomCollectedAnswer.equals(answers[i])) {
				charCorrectAnswer = tmpAnswer.get(answers[i]);
				System.out.println(answers[i]);
			}
		}

		
		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��
			
			super.input();
			
			if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == charCorrectAnswer){  // CorrectAnswer���C���X�^���X�����y�ѕ\��

				// ����p���ʉ��̗p�ӂ��K�v
				Sounds sound = new Music();
				sound.playMp3("Quiz-Buzzer02-1.mp3");

				CorrectAnswer correct = new CorrectAnswer();
				correct.display("CorrectAnswer.txt");
				System.out.println("Test_Display_Correct");
				correct.count(1); // ���𐔂��J�E���g����
				// correct.input();
				correct.selector();
				flag = false;

			}else if(getPressedKey() != charCorrectAnswer && (getPressedKey() == 'A' || getPressedKey() == 'B' || getPressedKey() == 'C' || getPressedKey() == 'D')){  //InCorrectAnswer���C���X�^���X�����y�ѕ\��

				// �s������
				Sounds sound = new Music();
				sound.playMp3("Quiz-Wrong_Buzzer02-2.mp3");

				InCorrectAnswer incorrect = new InCorrectAnswer();
				incorrect.display("InCorrectAnswer.txt");
				System.out.println("Test_Display_InCorrect");
				incorrect.count(1); // �s���𐔂��J�E���g����
				// incorrect.input();
				incorrect.selector();
				flag = false;
				
			}else{  // ���͂������l���������Ȃ��ꍇ���[�v����
					System.out.println("�������l����͂��Ă�������");
			}
		}
	}

}