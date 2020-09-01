class StartDisplay extends Display{
	
	@override
	void selector(){
		if(args[0] == 0){  //exit.txtを表示
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(args[0] == 1){  //couseSelectをインスタンス生成及び表示
			CouseSelect couse = new CouseSelect();
			course.display("couseSelect.txt");
			corse.input();
			corse.selector();
		}else{
			System.out.println("1 or 2 の数値を入力してください。");
		}
	}
}