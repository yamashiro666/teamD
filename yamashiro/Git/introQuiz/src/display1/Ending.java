package display1;

class Ending extends Display{

	@Override
	public void selector(){

		// System.out.println("仮表示: 0 でExit画面へ"); // テスト表示
		// System.out.println("仮表示: 1 でStartDisplay画面へ"); // テスト表示

		if(getPressedKey() == 0){  //Exit.txtを表示
			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == 1){  //StartDisplayをインスタンス生成及び表示

			StartDisplay start = new StartDisplay();

			start.display("StartDisplay.txt");
			start.input();
			start.selector();

		}
	}
}