//14�s��18�s��22�s��24�s�ڂɏC���L��


package display1;

class Ending extends Display{

	@Override
	public void selector(){

		

		if(getPressedKey() == '2'){  //Exit.txt��\��
			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == '1'){  //StartDisplay���C���X�^���X�����y�ѕ\��

			StartDisplay start = new StartDisplay();
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //�I�[�v�j���OBGM�̗p�ӂ��K�v

			start.display("StartDisplay.txt"); //UI���l�������e�L�X�g�t�@�C���C�����K�v
			start.input();
			start.selector();

		}
	}
}