package display1;

import java.util.Random;
import java.util.Set;

import selector.LinkFileNameToMp3;
import sound.Music;

class IntroStartExpert extends Answer{

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

		Set<String> mapToSet = linkFileNameList.linkedList.keySet();
		String musicTitleName = null;

		// Map<>からSetに変換し、その中からランダムで要素を一つ選ぶ
		int size = linkFileNameList.linkedList.keySet().size();
		int item = new Random().nextInt(size);
		int i = 0;
		for(String tmpMusicTitleName : mapToSet)
		{
		    if (i == item)
		    	// ここでランダムでMap<String, String> linkedList の mp3ファイルのパスをランダムで選ぶ
		    	// それを musicTitleName に入れる
		        musicTitleName = tmpMusicTitleName;
		    i++;
		}

		// ランダムに答えのmp3を選び randomCorrectedMp3 に代入
		randomCollectedMp3 = linkFileNameList.linkedList.get(musicTitleName);

		// randomCorrectedMp3 に対応する 曲名を randomCorrectedAnswer に代入
		randomCollectedAnswer = LinkFileNameToMp3.getKeysByValue(linkFileNameList.linkedList, randomCollectedMp3).stream().findFirst().get();

		// カウントダウン後、randomCollectedMp3フィールドを使い、音声ファイルをランダムで選択し再生する

		Music music = new Music();
		music.playMp3Thread(randomCollectedMp3).start();

		super.shuffle4Taku();

	}
}