package display1;

class Ending extends Display{

	@Override
	public void selector(){

		// System.out.println("���\��: 0 ��Exit��ʂ�"); // �e�X�g�\��
		// System.out.println("���\��: 1 ��StartDisplay��ʂ�"); // �e�X�g�\��

		if(getPressedKey() == 0){  //Exit.txt��\��
			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == 1){  //StartDisplay���C���X�^���X�����y�ѕ\��

			StartDisplay start = new StartDisplay();

			start.display("StartDisplay.txt");
			start.input();
			start.selector();

		}
	}
}