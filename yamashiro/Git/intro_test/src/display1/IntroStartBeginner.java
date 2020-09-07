package display1;

import java.util.Random;

import selector.LinkFileNameToMp3;
import sound.Music;

class IntroStartBeginner extends Answer{

	@Override
	public void display(String path) {


		// カウントダウン画面を表示する & 音声ファイルの再生中に♪を表示する
		CountDown cd = new CountDown();
		cd.display("Countdown1.txt");


		// ■LinkFileNameToMp3 クラスで以下の処理を行う
		// 1. music_title.txt からランダムで mp3 ファイル名を取得してmp3再生
		// 2. 再生したmp3ファイル名の曲名を取得
		// 3. 2で取得した曲名をanswerに代入
		LinkFileNameToMp3 linkFileNameList = new LinkFileNameToMp3("music_title.txt");
		// 乱数を作成
		int random = new Random().nextInt(linkFileNameList.linkedList.size());
		// ランダムに答えのmp3を選び randomCorrectedMp3 に代入
		randomCollectedMp3 = linkFileNameList.linkedList.get(random);
		// randomCorrectedMp3 に対応する 曲名を randomCorrectedAnswer に代入
		randomCollectedAnswer = LinkFileNameToMp3.getKeysByValue(linkFileNameList.linkedList, randomCollectedMp3).toString();


		// カウントダウン後、randomCollectedMp3フィールドを使い、音声ファイルをランダムで選択し再生する
		// playMp3メソッドはstaticメソッドにしました。
		Music.playMp3Thread(randomCollectedMp3).start();  //songFileName[]のいずれかを再生

		super.shuffle4Taku();

	}

}