package display;

public class StartDisplay extends Display{
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(exit.txt);
		}else if(getPressedKey() == 'S' || getPressedKey() == 's'){  //CouseSelect���C���X�^���X�����y�ѕ\��
			CouseSelect couse = new CouseSelect();
			course.display("CouseSelect.txt");
			corse.waiting();
			corse.selector();
		}
	}
}