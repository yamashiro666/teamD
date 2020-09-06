package selector;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LinkFileNameToMp3 {
	Map<String,String> list;

	/**
	 * コンストラクタでmusic_tiile.txt 内の 文字列を Map<String,String>に格納する
	 * 1.  「曲名」と「mp3ファイルへのパスの文字列」をペアで管理するコレクションHashMapを作成
	 * 2.  for文で格納してゆくのでイテレーター作成
	 * 3.  BufferedReaderで1行ずつ読み込んでゆく
	 * 4.  用意したイテレーターでHashMapに格納してゆく
	 *
	 *  @param filePath music.title.txtへの相対パス
	 */
	public LinkFileNameToMp3(String filePath) {

		//  1.  「曲名」と「mp3ファイルへのパスの文字列」をペアで管理するコレクションHashMapを作成
		this.list = new HashMap<>();
		List<String> arrayList = new ArrayList<>();
		//  2.  for文で格納してゆくのでイテレーター作成
		Iterator<String> iterator = arrayList.iterator();

		Reader fileReader = null;
		BufferedReader bf = null;
		String data = null;

		try {

			fileReader = new FileReader(new File(filePath));

			bf = new BufferedReader(fileReader);

			// 3.  BufferedReaderで1行ずつ読み込んでゆく
			while ((data = bf.readLine()) != null) {
            	arrayList.add(data);
            }
			bf.close();
			// System.out.println(bf.ready());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {


		}

		// 4.  用意したイテレーターでHashMapに格納してゆく
		for(int i = 0; i < arrayList.size()-1; i+=2) {

			if(!iterator.hasNext()) {
				break;
			}
			list.put(arrayList.get(i), arrayList.get(i+1));
		}
	} // LinkFileNameToMp3 コンストラクタブロック終わり
}
