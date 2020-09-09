//23行目25行目31行目35～39行目45行目47行目53行目55行目61行目63～68行目を修正

/*
 * 9月9日追記
 * ・カウントダウンの音再生はCountDownクラス内でまとめて処理できるように変更
 */
package display1;

class InCorrectAnswer extends Answer{

	void count(int level){
		if(courseLevel == 0) {
			courseLevel = level;
		}
			answerNum++;
			inCorrectNum++;
	}


	@Override
	public void selector(){
		
		while(flag == true){ // 適切な値を入力し正常に動作したらfalseで終了。不適切な値が入力された場合はtrueでループしてやり直し
			
			super.input();
			
			if(getPressedKey() == '2'){  // Exitをインスタンス生成及び表示

				Exit exit = new Exit();
				exit.display("Exit.txt");
				flag = false;

			}else if(getPressedKey() == '1' && answerNum == 5){  // Resultをインスタンス生成及び表示

				Result rst = new Result();
				rst.display("Result.txt");
				// rst.input();
				rst.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 1){  // IntroStartBeginnerをインスタンス生成及び表示

				Answer isb = new IntroStartBeginner();
				isb.display("IntroStartBeginner.txt");
				// isb.input();
				isb.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 2){  // IntroStartMediumをインスタンス生成及び表示

				Answer ism = new IntroStartMedium();
				ism.display("IntroStartMedium.txt");
				// ism.input();
				ism.selector();
				flag = false;

			}else if(getPressedKey() == '1' && answerNum < 5 && courseLevel == 3){  // IntroStartExpertをインスタンス生成及び表示

				Answer ise = new IntroStartExpert();
				ise.display("IntroStartExpert.txt");
				// ise.input();
				ise.selector();
				flag = false;

			}else{  // 入力した数値が正しくない場合ループする
					System.out.println("正しい値を入力してください");
			}
		}
	}
}