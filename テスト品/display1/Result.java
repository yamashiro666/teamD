package display1;

class Result extends Display{

//	@Override
//	public void display("textfile/Result.txt"){
//		//���𐔂ƕs���𐔂�\������
//	}

	@Override
	public void selector(){
		if(getPressedKey() == 0){  //exit.txt��\��

			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == 1){  //ending���C���X�^���X�����y�ѕ\��

			Ending end = new Ending();
			end.display("texfile/Ending.txt");
			end.input();
			end.selector();

		}
	}
}