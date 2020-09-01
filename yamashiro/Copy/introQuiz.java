class IntroQuiz{
	public static void main(String[] args){
		
		StartDisplay start = new StartDisplay();
		start.display(startDisplay.txt);  //startDisplay.txtを表示
		start.input();  //キーボード入力待ち
		start.selector()  //入力した値を元に条件分岐し、各ファイルをインスタンス生成及び表示
		
	}
}