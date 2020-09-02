package display;

public class StartDisplay extends Display{

	@Override
	public void selector() {
		/*
		 * if文で以下の条件分岐を行う
		 * １．Enterが押されたら
		 *   CourseSelectクラスをインスタンス化
		 *   インスタンス化したオブジェクトでdisplayメソッドを呼び出し、コースセレクト画面を表示する
		 *
		 * ２．Eもしくはeキーが押されたら
		 *   Exitクラスインスタンス化
		 *   インスタンス化したオブジェクトでdisplayメソッドを呼び出し、Exit画面を表示する
		 */
		if(getPressedKey() == 'S' || getPressedKey() == 's') { // -> １．Sまたはsキーが押されたら
			// CourseSelectクラスをインスタンス化
			Display course = new CourseSlect();
			// インスタンス化したオブジェクトでdisplayメソッドを呼び出し、コースセレクト画面を表示する
			course.display("CourseSelect.txt");

		}else if(getPressedKey() == 'e' || getPressedKey() == 'E') { // -> ２．Eもしくはeキーが押されたら
			System.out.println("Exit"); // -> テスト表示
			// Exitクラスインスタンス化

			// インスタンス化したオブジェクトでdisplayメソッドを呼び出し、Exit画面を表示する

		}
	}
}
