class Answer extends Display{
	
	//正解数カウント用のリスト
	int correctCount[] = int[5];
	
	//不正解数カウント用のリスト
	int inCorrectCount[] = int[5];
	
	//正解数と不正解数をカウントする抽象メソッド
	void count();
}