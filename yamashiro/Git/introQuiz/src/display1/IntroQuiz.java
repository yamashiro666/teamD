package display;

import sound.Music;

public class IntroQuiz{
	public static void main(String[] args) throws InterruptedException {

		StartDisplay start = new StartDisplay();
		Music sound = new Music();

		Music.playMp3Thread("sample2.mp3").start(); //sample2.mp3���Đ�

		start.display(StartDisplay.txt);  //StartDisplay.txt��\��
		start.waiting();  //�L�[�{�[�h���͑҂�
		start.selector()  //���͂����l�����ɏ������򂵁A�e�t�@�C�����C���X�^���X�����y�ѕ\��

	}
}