package display1;

import sound.Music;

public class StartDisplay extends Display{


	@Override
	public void selector(){

		System.out.println("TEST");
		Music sound = new Music();
		sound.playMp3("sample2.mp3");

		while(flag == true){ // �K�؂Ȓl����͂�����ɓ��삵����false�ŏI���B�s�K�؂Ȓl�����͂��ꂽ�ꍇ��true�Ń��[�v���Ă�蒼��

				super.input();

			if(getPressedKey() == '2'){  //Exit���C���X�^���X�����y�ѕ\��

				Exit exit = new Exit();
				exit.display("Exit.txt");
				sound.musicStop();

				flag = false;

			}else if(getPressedKey() == '1'){  //CouseSelect���C���X�^���X�����y�ѕ\��

				CourseSlect course = new CourseSlect();
				course.display("CourseSelect.txt");
				sound.musicStop();
				course.selector();

				flag = false;

			}else{  //���͂������l���������Ȃ��ꍇ���[�v����
				System.out.println("�������l����͂��Ă�������");
			}
		}
	}
}