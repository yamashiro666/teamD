package selector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Selector2 {

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
}
