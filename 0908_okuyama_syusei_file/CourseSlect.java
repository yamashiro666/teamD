//11�s��16�s��18�s��21�s��25�s��27�s��30�s��34�s��36�s��39�s�ڂɏC���L��


package display1;

import sound.Music;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		if(getPressedKey() == '4'){  //Exit���C���X�^���X�����y�ѕ\��

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == '1'){  //IntroStartBeginner���C���X�^���X�����y�ѕ\��
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			Answer isb = new IntroStartBeginner();
			isb.display("textfile/IntroStart.txt"); //�e�L�X�g�t�@�C���C���ς�
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '2'){  //IntroStartMedium���C���X�^���X�����y�ѕ\��
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			Answer ism = new IntroStartMedium();
			ism.display("textfile/IntroStart.txt"); //�e�L�X�g�t�@�C���C���ς�
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '3'){  //IntroStartExpert���C���X�^���X�����y�ѕ\��
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //�J�E���g�_�E���p���ʉ��̗p�ӂ��K�v

			Answer ise = new IntroStartExpert();
			ise.display("textfile/IntroStart.txt"); //�e�L�X�g�t�@�C���C���ς�
			ise.input();
			ise.selector();

		}

	}
}