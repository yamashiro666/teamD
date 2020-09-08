//14行目18行目22行目24行目に修正有り


package display1;

class Ending extends Display{

	@Override
	public void selector(){

		

		if(getPressedKey() == '2'){  //Exit.txtを表示
			Exit exit = new Exit();
			exit.display("texfile/Exit.txt");

		}else if(getPressedKey() == '1'){  //StartDisplayをインスタンス生成及び表示

			StartDisplay start = new StartDisplay();
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //オープニングBGMの用意が必要

			start.display("StartDisplay.txt"); //UIを考慮したテキストファイル修正が必要
			start.input();
			start.selector();

		}
	}
}