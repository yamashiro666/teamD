import display1.*;

public class Main {
	public static void main(String[] args) {

		// DtartDisplay���C���X�^���X��
		StartDisplay startDisplay = new StartDisplay();
		// ���y���Đ�����ׂ̃N���X Music �N���X�C���X�^���X��
		//Music sound = new Music();

		//sound.playLong("sample2.mp3");
		//sound.playMp3Thread("sample2.mp3").start();
		startDisplay.display("textfile/StartDisplay.txt");

		
		
		startDisplay.input();

		// ProcessBuilder�N���X���g���R�}���h�v�����v�g�̉�ʂ��N���A����R�}���h�����s
		// ����\�肾���ǁA�܂����܂������ĂȂ�...
		// new ClearDisplay();
		startDisplay.selector();


		// sound.playShort("sample2.mp3");
		// sound.playMiddle("sample2.mp3");
		// sound.playLong("sample2.mp3");

	}
}
