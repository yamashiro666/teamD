package display1;

abstract class Answer extends Display implements CorrectAnswer, InCorrectAnswer{

	// 正解数カウント用のリスト
	int correctCount;

	// 不正解数カウント用のリスト
	int inCorrectCount;

	// 正解数をカウントするメソッド
	public void correctCount(){
		this.correctCount += 1;
	}

	// 不解数をカウントするメソッド
	public void inCorrectCount(){
		this.inCorrectCount += 1;
	}

	@Override
	public void selector(){

		/*
		 * 以下の処理をif文で条件分岐する
		 *
		 * 押されたキーが
		 * １．0 の時 --> Exit画面を表示する
		 * ２．1 の時 --> 次の問題画面に進む
		 */
		if(getPressedKey() == 0){ // 押されたキーが 0 の時 -> // Exit.txtを表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		/*
		 *  １．押されたキーが 0 の時 かつ 正解数と不正解数の合計が 5 の時
		 *  Resultをインスタンス生成及び表示
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) == 5){

			Result rst = new Result();
			rst.display("textfile/Result.txt");
			rst.input();
			rst.selector();

		/*
		 *  ２．押されたキーが 0 の時 かつ 正解数と不正解数の合計が 5 以下
		 *  かつ このメソッドを呼び出したインスタンスが IntroStartBignner のとき
		 *  ↓
		 *  Resultをインスタンス生成及び表示
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartBeginner)){ // 押されたキーが 0 の時 かつ // IntroStartBeginnerをインスタンス生成及び表示

			IntroStartBeginner isb = new IntroStartBeginner();
			isb.display("textfile/IntroStartBeginner.txt");
			isb.input();
			isb.selector();

		/*
		 *  ２．押されたキーが 0 の時 かつ 正解数と不正解数の合計が 5 以下
		 *  かつ このメソッドを呼び出したインスタンスが IntroStartMedium のとき
		 *  ↓
		 *  Resultをインスタンス生成及び表示
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartMedium)){  // IntroStartMediumをインスタンス生成及び表示

			IntroStartMedium ism = new IntroStartMedium();
			ism.display("textfile/IntroStartMedium.txt");
			ism.input();
			ism.selector();

		/*
		 *  ２．押されたキーが 0 の時 かつ 正解数と不正解数の合計が 5 以下
		 *  かつ このメソッドを呼び出したインスタンスが IntroStartExpart のとき
		 *  ↓
		 *  Resultをインスタンス生成及び表示
		 */
		}else if(getPressedKey() == 1 && (this.correctCount + this.inCorrectCount) < 5 && (this instanceof IntroStartExpert)){  // IntroStartExpertをインスタンス生成及び表示

			IntroStartExpert ise = new IntroStartExpert();
			ise.display("textfile/IntroStartExpert.txt");
			ise.input();
			ise.selector();

		}else{
			System.out.println("適切な数値を入力してください。");
		}
	}

}