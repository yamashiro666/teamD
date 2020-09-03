package display;

public class StartDisplay extends Display{
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exitをインスタンス生成及び表示
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(getPressedKey() == 'S' || getPressedKey() == 's'){  //CouseSelectをインスタンス生成及び表示
			CouseSelect couse = new CouseSelect();
			course.display("CouseSelect.txt");
			corse.waiting();
			corse.selector();
		}
	}
}