package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");
		}else if(getPressedKey() == 'S' || getPressedKey() == 's'){  //CouseSelect���C���X�^���X�����y�ѕ\��
			CourseSlect course = new CourseSlect();
			course.display("textfile/CourseSelect.txt");
			course.input();
			course.selector();
		}
	}
}