/*
 * 112行目 Windows とMac かでどちらかのコメントを外して使用する
 */
package selector;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import random.RandomUniqueNumberGenerator;

public class NameSelector {

	/**
	 *  フォルダにあるファイル名一覧を格納するリスト
	 */
	public List<String> textFileNameList;

	/**
	 * Sentakushi??.txt内の曲名を格納するリスト
	 */
	List<String> musicTitleNameList;

	/**
	 *  Sentakushi??.txtがあるフォルダのパス名を表すフィールド
	 */
	String dirName;




	/**
	 * 引数にファイル名を入れると「そのファイルが所属しているフォルダのパス名」を取得できる
	 * 1. システムリソースから Sentakushi01.txt のパスを取得
	 * 2. フォルダ名に日本語が含まれている場合のためにURLをデコードする
	 *
	 * @param filePath ファイル名
	 * @return String フォルダのパス名
	 */
	public String setDirName(String filePath){
		// 1. システムリソースから Sentakushi01.txt のパスを取得する
				URI pathToTextFile = null;
				try {
					pathToTextFile = ClassLoader.getSystemResource(filePath).toURI();
					System.out.println("pathToTextFile : " + pathToTextFile.toString());
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				try {
					/*
					 *  2. フォルダ名に日本語が含まれている場合のためにURLをデコードする。 System.getProperty("file.encoding") がうまくいかなかったので
					 *  直接指定する。自分が使ってるMacの場合、UTF-8でデコードするとうまく行った。
					 */
					String encodedResult = URLDecoder.decode(pathToTextFile.toString(), "UTF-8");

					// 3. このファイルが所属しているディレクトリ名をgetParent()メソッドで取得
					dirName = new File(encodedResult).getParent();

					System.out.println("setDirNameメソッド内: 変数dirName" + dirName);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		return dirName;
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
	public List<String> setTxtFileNameList(String dirName) {

		// 1. Fileクラスのオブジェクトを生成し対象のディレクトリを指定
		// 返ってくる文字列は先頭に「file:」がつくのでreplaceで削除
		String tmp1 = dirName.replace("jar:", "");
		String tmp2 = tmp1.replace("file:","");
		File dir = new File(tmp2);

//		System.out.println(dir.isFile()); // TEST
//		System.out.println(dir.toString()); // TEST
//		System.out.println("NameSelectorクラス内: 変数dir :" + dir);

		 // 2. listFilesを使用してファイル一覧を取得
		File[] textFileList = dir.listFiles();

		// 3. ファイル名一覧を格納するArrayList作成
		this.textFileNameList = new ArrayList<String>();

		// 正規表現で検索するための文字列を作成
		String regex = "^.*(Sentakushi)(.{1,})";

//		System.out.println(textFileList.length);

		// 4. 拡張for文でtextFileListからtextFileオブジェクトをひとつづつ取り出してゆく
		for(int i = 0; i < textFileList.length; i++) {
			if(Pattern.matches(regex, textFileList[i].toString())){
				String tmpString = textFileList[i].toString().replace(regex, textFileList[i].toString());
				textFileNameList.add(tmpString);
			}
		}
	    return textFileNameList;
	}


	/**
	 * SentakushiXX.txt が格納されているフォルダから
	 * ランダムでSentakushiファイルを一つ選びそのファイル名を返すメソッド
	 * 以下処理の流れ
	 * 1. setDirNameメソッドでSentakushi01.txtが格納されているディレクトリのパスの文字列をdirNameフィールドにセット
	 * 2. Sentakushiフォルダにあるファイル名の一覧を取得
	 * 3. Sentakushiフォルダにあるファイル群の内、一つのファイルをランダムで選択
	 *
	 * @param filePath SentakushiXX.txt (XXは、存在するなら何でもいいです)
	 * @return String textFileNameList からランダムで一つ選ばれた要素
	 */
	public String getRomdomTextFileName(String filePath) {

		// 1. setDirNameメソッドでSentakushi01.txtが格納されているディレクトリのパスの文字列をdirNameフィールドにセット
		setDirName(filePath);

		// 2. 3. Sentakushiが格納されているファイル群の内、一つのファイルをランダムで選択
		int[] randomNum = RandomUniqueNumberGenerator.randomNoGenerator(setTxtFileNameList(dirName).size());
		String returnValue = setTxtFileNameList(dirName).get(randomNum[0]);

		return returnValue;
	}

	/**
	 * Sentakushi??.txt の 中身を読み込んで musicTitleNameList フィールドに代入するメソッド
	 * @param filePath Sentakushi??.txt ファイルのパス名
	 * @return List<String> musicTitleNameList フィールド
	 */
	public List<String> readTextFile(String filePath) {
		// BufferedReaderで使用するための 変数 tmp
		String tmp = null;
		// 正規表現をつかいフィルターをかける
		// Windows の場合
		// String regex = "\\\\t|\\\\n|\\\\r|\\\\r\\\\n";
		// Mac の場合
		String regex = "\\t|\\n|\\r|\\r\\n";
		Pattern p = Pattern.compile(regex);
		musicTitleNameList = new ArrayList<>();

		// システムリソースからファイルのパスを読み込む
		InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

			while ((tmp = br.readLine()) != null) {
				if(tmp.equals(" ")) { // 1. 正規表現で以下の文字列に合致する場合は continuie する
					continue;
				}else{
					// tmp.replaceAll("\\s", " ");
					musicTitleNameList.add(tmp);
				}
	         }

		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
		return musicTitleNameList;
	}

	/**
	 * Sentakushi.txt の 中の曲名からランダムで 3 つ選ぶメソッド
	 */
	public String[] getRandomTltleName() {

		int[] random = RandomUniqueNumberGenerator.randomNoGenerator(2);
		String[] randomTltleName = new String[2];
		randomTltleName[0] = musicTitleNameList.get(random[0]);
		randomTltleName[1] = musicTitleNameList.get(random[1]);
		randomTltleName[2] = musicTitleNameList.get(random[2]);
		return randomTltleName;
	}


}
