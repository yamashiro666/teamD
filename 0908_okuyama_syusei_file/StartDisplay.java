//10�s��13�s��15�s�ڂɏC���L��


package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		if(getPressedKey() == '2'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");
		}else if(getPressedKey() == '1'){  //CouseSelect���C���X�^���X�����y�ѕ\��
			CourseSlect course = new CourseSlect();
			course.display("textfile/CourseSelect.txt"); //�e�L�X�g�t�@�C���C���ς�
			course.input();
			course.selector();
		}
	}
}