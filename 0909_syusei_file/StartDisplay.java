// 10行目12行目18行目24行目26～31行目を修正

package display1;

public class StartDisplay extends Display{

	@Override
	public void selector(){
		
		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し
		
			super.input();
			
			if(getPressedKey() == '2'){  //Exitをインスタンス生成及び表示
				
				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;
				
			}else if(getPressedKey() == '1'){  //CouseSelectをインスタンス生成及び表示
				
				CourseSlect course = new CourseSlect();
				course.display("CourseSelect.txt");
				// course.input();
				course.selector();
				flag = false;
				
			}else{  //入力した数値が正しくない場合ループする
				System.out.println("正しい値を入力してください");
			}
		}
	}
}