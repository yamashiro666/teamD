package display1;

interface InCorrectAnswer{

	/*
	 * 問題を回答するたびにinCorrectCountフィールドを
	 * 1カウントするメソッド
	 */
	void inCorrectCount();

//	@Override
//	public void selector(){
//		if(args[0] == 0){  //exit.txtを表示
//			Exit exit = new Exit();
//			exit.display(exit.txt);
//		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) == 5){  //resultをインスタンス生成及び表示
//			Result rst = new Result();
//			rst.display("result.txt");
//			rst.input();
//			rst.selector();
//		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartBeginnerクラスだった場合*/){  //introStartBeginnerをインスタンス生成及び表示
//			IntroStartBeginner isb = new IntroStartBeginner();
//			isb.display("introStartBeginner.txt");
//			isb.input();
//			isb.selector();
//		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartMediumクラスだった場合*/){  //introStartMediumをインスタンス生成及び表示
//			IntroStartMedium ism = new IntroStartMedium();
//			ism.display("introStartMedium.txt");
//			ism.input();
//			ism.selector();
//		}else if(args[0] == 1 && (super.correctCount.length + super.inCorrectCount.length) < 5 && /*introStartExpertクラスだった場合*/){  //introStartExpertをインスタンス生成及び表示
//			IntroStartExpert ise = new IntroStartExpert();
//			ise.display("introStartExpert.txt");
//			ise.input();
//			ise.selector();
//		}else{
//			System.out.println("適切な数値を入力してください。");
//		}
//	}
}