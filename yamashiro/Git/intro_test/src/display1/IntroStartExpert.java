package display1;

import java.util.Random;
import java.util.Set;

import selector.LinkFileNameToMp3;
import sound.Music;

class IntroStartExpert extends Answer{

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

		Set<String> mapToSet = linkFileNameList.linkedList.keySet();
		String musicTitleName = null;

		// Map<>����Set�ɕϊ����A���̒����烉���_���ŗv�f����I��
		int size = linkFileNameList.linkedList.keySet().size();
		int item = new Random().nextInt(size);
		int i = 0;
		for(String tmpMusicTitleName : mapToSet)
		{
		    if (i == item)
		    	// �����Ń����_����Map<String, String> linkedList �� mp3�t�@�C���̃p�X�������_���őI��
		    	// ����� musicTitleName �ɓ����
		        musicTitleName = tmpMusicTitleName;
		    i++;
		}

		// �����_���ɓ�����mp3��I�� randomCorrectedMp3 �ɑ��
		randomCollectedMp3 = linkFileNameList.linkedList.get(musicTitleName);

		// randomCorrectedMp3 �ɑΉ����� �Ȗ��� randomCorrectedAnswer �ɑ��
		randomCollectedAnswer = LinkFileNameToMp3.getKeysByValue(linkFileNameList.linkedList, randomCollectedMp3).stream().findFirst().get();

		// �J�E���g�_�E����ArandomCollectedMp3�t�B�[���h���g���A�����t�@�C���������_���őI�����Đ�����

		Music music = new Music();
		music.playMp3Thread(randomCollectedMp3).start();

		super.shuffle4Taku();

	}
}