//10行目13行目15行目に修正有り


package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		if(getPressedKey() == '2'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");
		}else if(getPressedKey() == '1'){  //CouseSelectをインスタンス生成及び表示
			CourseSlect course = new CourseSlect();
			course.display("textfile/CourseSelect.txt"); //テキストファイル修正済み
			course.input();
			course.selector();
		}
	}
}