package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");
		}else if(getPressedKey() == 'S' || getPressedKey() == 's'){  //CouseSelectをインスタンス生成及び表示
			CourseSlect course = new CourseSlect();
			course.display("textfile/CourseSelect.txt");
			course.input();
			course.selector();
		}
	}
}