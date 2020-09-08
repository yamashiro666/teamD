package selector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class LinkFileNameToMp3 {

	/**
	 *  music_tiile.txtの内容をMap管理するフィールド
	 *  Map<"曲名" , "mp3ファイル名"> で管理
	 */
	public Map<String, String> linkedList;

	/**
	 * コンストラクタでmusic_tiile.txt 内の 文字列を Map<String,String>に格納する
	 * 1.  「曲名」と「mp3ファイルへのパスの文字列」をペアで管理するコレクションHashMapを作成
	 * 2.  for文で格納してゆくのでイテレーター作成
	 * 3.  BufferedReaderで1行ずつ読み込んでゆく
	 * 4.  用意したイテレーターでHashMapに格納してゆく
	 *
	 *  @param filePath 曲名とmp3がペアで記述されたテキストファイル(music_title.txt)
	 */
	public LinkFileNameToMp3(String filePath) {

		//  1.  linkedListフィールドをインスタンス化
		this.linkedList = new HashMap<>();
		List<String> arrayList = new ArrayList<>();
		//  2.  for文で格納してゆくのでイテレーター作成
		Iterator<String> iterator = arrayList.iterator();

		BufferedReader bf = null;
		String data = null;
		InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);


		try {
			bf = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

			// 3.  BufferedReaderで1行ずつ読み込んでゆく
			while ((data = bf.readLine()) != null) {
				// data.replaceAll(p.toString(), "\\s");
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
			this.linkedList.put(arrayList.get(i), arrayList.get(i+1));
		}
	} // LinkFileNameToMp3 コンストラクタブロック終わり

	/**
	 * linkedList のゲッターメソッド
	 */
	public Map<String, String> getLinkedList() {
		return linkedList;
	}

	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
	    Set<T> keys = new HashSet<T>();
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
}
