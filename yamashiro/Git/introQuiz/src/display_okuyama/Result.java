package display_okuyama;
class Result extends Answer{
	
	@override
	void display(){
		//���𐔂ƕs���𐔂�\������
		System.out.println("���Ȃ��̐��т� ���� " + super.correctNum + " �s���� " + super.inCorrectNum + " �ł�");
	}
	
	@override
	void selector(){
		if(getPressedKey() == 'e' || getPressedKey() == 'E'){  //Exit���C���X�^���X�����y�ѕ\��
			Exit exit = new Exit();
			exit.display(Exit.txt);
		}else if(getPressedKey() == 'n' || getPressedKey() == 'N'){  //Ending���C���X�^���X�����y�ѕ\��
			Ending end = new Ending();
			end.display("Ending.txt");
			end.input();
			end.selector();
		}
	}
}