package display1;

import sound.Music;

public class IntroQuiz{
	public static void main(String[] args) throws InterruptedException {

		StartDisplay start = new StartDisplay();
		Music sound = new Music();

		sound.playMp3Thread("music2.mp3").start();

		start.display("StartDisplay.txt");  //StartDisplay.txt��\��
		start.input();  //�L�[�{�[�h���͑҂�
		start.selector();  //���͂����l�����ɏ������򂵁A�e�t�@�C�����C���X�^���X�����y�ѕ\��

	}
}