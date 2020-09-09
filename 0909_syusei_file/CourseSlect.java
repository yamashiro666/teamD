//10行目12行目18行目24行目26行目32行目34行目40行目42～47行目を修正

package display1;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し

			super.input();

			if(getPressedKey() == '4'){  //Exitをインスタンス生成及び表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1'){  //IntroStartBeginnerをインスタンス生成及び表示

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '2'){  //IntroStartMediumをインスタンス生成及び表示

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '3'){  //IntroStartExpertをインスタンス生成及び表示

				Answer ise = new IntroStartExpert();
				ise.display("IntroStartExpert.txt");
				// ise.input();
				ise.selector();
				flag = false;

			}else{  //入力した数値が正しくない場合ループする
					System.out.println("正しい値を入力してください");
			}
		}

	}
}