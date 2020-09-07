package display1;

import java.util.Random;

import selector.LinkFileNameToMp3;
import sound.Music;

class IntroStartBeginner extends Answer{

	@Override
	public void display(String path) {


		// �J�E���g�_�E����ʂ�\������ & �����t�@�C���̍Đ����Ɂ��\������
		CountDown cd = new CountDown();
		cd.display("Countdown1.txt");


		// ��LinkFileNameToMp3 �N���X�ňȉ��̏������s��
		// 1. music_title.txt ���烉���_���� mp3 �t�@�C�������擾����mp3�Đ�
		// 2. �Đ�����mp3�t�@�C�����̋Ȗ����擾
		// 3. 2�Ŏ擾�����Ȗ���answer�ɑ��
		LinkFileNameToMp3 linkFileNameList = new LinkFileNameToMp3("music_title.txt");
		// �������쐬
		int random = new Random().nextInt(linkFileNameList.linkedList.size());
		// �����_���ɓ�����mp3��I�� randomCorrectedMp3 �ɑ��
		randomCollectedMp3 = linkFileNameList.linkedList.get(random);
		// randomCorrectedMp3 �ɑΉ����� �Ȗ��� randomCorrectedAnswer �ɑ��
		randomCollectedAnswer = LinkFileNameToMp3.getKeysByValue(linkFileNameList.linkedList, randomCollectedMp3).toString();


		// �J�E���g�_�E����ArandomCollectedMp3�t�B�[���h���g���A�����t�@�C���������_���őI�����Đ�����
		// playMp3���\�b�h��static���\�b�h�ɂ��܂����B
		Music.playMp3Thread(randomCollectedMp3).start();  //songFileName[]�̂����ꂩ���Đ�

		super.shuffle4Taku();

	}

}