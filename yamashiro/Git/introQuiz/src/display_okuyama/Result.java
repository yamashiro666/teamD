package display_okuyama;
class Result extends Answer{
	
	@override
	void display(){
		//正解数と不正解数を表示する
		System.out.println("あなたの成績は 正解 " + super.correctNum + " 不正解 " + super.inCorrectNum + " です");
	}
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(getPressedKey() == 'n' || getPressedKey() == 'N'){  //Endingをインスタンス生成及び表示
			Ending end = new Ending();
			end.display("Ending.txt");
			end.input();
			end.selector();
		}
	}
}