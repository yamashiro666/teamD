/*
 *  �R�}���h�v�����v�g�Ŏ��s����ۂ� import display1.*; �̃R�����g�A�E�g���͂����A
 *  package display1; ���R�����g�A�E�g����B
 */
package display1;

import sound.Music;

// import display1.*;

public class Main {
	public static void main(String[] args) {

		// DtartDisplay���C���X�^���X��
		StartDisplay startDisplay = new StartDisplay();

		Music.playMp3Thread("ongen/sample2.mp3").start();
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
