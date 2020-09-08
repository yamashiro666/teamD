//11行目16行目18行目21行目25行目27行目30行目34行目36行目39行目に修正有り


package display1;

import sound.Music;

class CourseSlect extends  Display{

	@Override
	public void selector(){

		if(getPressedKey() == '4'){  //Exitをインスタンス生成及び表示

			Exit exit = new Exit();
			exit.display("textfile/Exit.txt");

		}else if(getPressedKey() == '1'){  //IntroStartBeginnerをインスタンス生成及び表示
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //カウントダウン用効果音の用意が必要

			Answer isb = new IntroStartBeginner();
			isb.display("textfile/IntroStart.txt"); //テキストファイル修正済み
			isb.input();
			isb.selector();

		}else if(getPressedKey() == '2'){  //IntroStartMediumをインスタンス生成及び表示
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //カウントダウン用効果音の用意が必要

			Answer ism = new IntroStartMedium();
			ism.display("textfile/IntroStart.txt"); //テキストファイル修正済み
			ism.input();
			ism.selector();

		}else if(getPressedKey() == '3'){  //IntroStartExpertをインスタンス生成及び表示
			
			Music.playMp3Thread("ongen/sample2.mp3").start(); //カウントダウン用効果音の用意が必要

			Answer ise = new IntroStartExpert();
			ise.display("textfile/IntroStart.txt"); //テキストファイル修正済み
			ise.input();
			ise.selector();

		}

	}
}