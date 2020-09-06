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
import java.util.Random;

public class Selector {


	// フォルダにあるファイル名一覧を格納するリスト
	private List<String> fileNameList;


	List<String> getFileNameList(){
		return fileNameList;
	}

	/**
	 * getFileNames(String dirName)
	 * 引数にディレクトリの名前を入れるとそのディレクトリにある
	 * ファイル名の一覧を返してくれる。以下、処理の流れ
	 * 1. Fileクラスのオブジェクトを生成し対象のディレクトリを指定
	 * 2. listFilesを使用してファイル一覧を取得
	 * 3. ファイル名一覧を格納するArrayList作成
	 * 4. 拡張for文でListに追加してゆく
	 *
	 * @param dirName ディレクトリの名前
	 * @return List<String> ディレクトリにあるファイル名一覧
	 */
	List<String> getTxtFileNameList(String dirName) {

		// 1. Fileクラスのオブジェクトを生成し対象のディレクトリを指定
		File dir = new File(dirName);
//		System.out.println(dir.isFile());
//		System.out.println(dir.toString());

		 // 2. listFilesを使用してファイル一覧を取得
		File[] list = dir.listFiles();

		// 3. ファイル名一覧を格納するArrayList作成
		this.fileNameList = new ArrayList<String>();

		// 4. 拡張for文でListに追加してゆく
		for(File file: list) {
			fileNameList.add(file.getName());
		}

	    return fileNameList;
	}

	/*
	 * fileRomdomSelector()メソッド
	 * getTxtFileNameListメソッドで取得したフォルダにあるファイル名の一覧をランダムで
	 * ひとつ選択するメソッド
	 */
	String fileRomdomSelector() {
		Random random = new Random();
		int rondomNum = random.nextInt(this.getFileNameList().size());

		return getFileNameList().get(rondomNum);
	}


	/*
	 *
	 */
	Map<String, String> fileOpen() {

		Map<String, String> list = new HashMap<>();
		List<String> arrayList = new ArrayList<>();
		Iterator<String> iterator = arrayList.iterator();

		Reader fileReader = null;
		BufferedReader bf = null;
		String data = null;
		try {

			fileReader = new FileReader(new File("sentakusi/" + this.fileRomdomSelector()));

			bf = new BufferedReader(fileReader);

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
		for(int i = 0; i < arrayList.size()-1; i+=2) {

			if(!iterator.hasNext()) {
				break;
			}
			list.put(arrayList.get(i), arrayList.get(i+1));

		}
		return list;
	}

	String getKey() {
		this.fileOpen();
		return null;
	}

	/*
	 * fileOpen()メソッドを使いMap<K,V>の中のKeyから
	 * ランダムで一つ選びその文字列表現を返すメソッド
	 * 以下処理の流れ
	 *  1. sentakusiフォルダにあるファイル名の一覧を取得
	 *  2. sentakusiフォルダにあるファイル群の内、一つのファイルをランダムで選択
	 *  3.
	 */
	String getRomdomFileName() {

		// 1.sentakusiフォルダにあるファイル名の一覧を取得
		this.getTxtFileNameList("sentakusi/");

		// 2.sentakusiフォルダにあるファイル群の内、一つのファイルをランダムで選択
		this.fileRomdomSelector();

		String returnStr = null;
		int item = new Random().nextInt(this.getFileNameList().size());
		int i = 0;
		for(String str : this.fileOpen().keySet()){
		    if (i == item)
		    	returnStr = str.toString();
		    i++;
		}
		return returnStr;

	}



	public static void main(String[] args) {
		Selector s = new Selector();

		s.getTxtFileNameList("sentakusi/");
		s.fileOpen();
		s.getRomdomFileName();
		int item = new Random().nextInt(s.getFileNameList().size());
		int i = 0;
		for(Object obj : s.fileOpen().keySet()){
		    if (i == item)
		        System.out.println(obj.toString());
		    i++;
		}
		System.out.println(s.fileOpen().keySet());

	}
}
