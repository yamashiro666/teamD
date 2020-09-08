package selector;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import random.RandomUniqueNumberGenerator;

public class NameSelector {

	/**
	 *  フォルダにあるファイル名一覧を格納するリスト
	 */
	public List<String> textFileNameList;

	List<String> musicTitleNameList;

	/**
	 *  Sentakushi.txtがあるフォルダのパス名を表すフィールド
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
				URL pathToTextFile = ClassLoader.getSystemResource(filePath);
				try {
					/*
					 *  2. フォルダ名に日本語が含まれている場合のためにURLをデコードする。 System.getProperty("file.encoding") がうまくいかなかったので
					 *  直接指定する。自分が使ってるMacの場合、UTF-8でデコードするとうまく行った。
					 */
					String encodedResult = URLDecoder.decode(pathToTextFile.toString(), "UTF-8");
					// 3. このファイルが所属しているディレクトリ名をgetParent()メソッドで取得
					dirName = new File(encodedResult).getParent();
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
		File dir = new File(dirName.replace("file:", ""));
//		System.out.println(dir.isFile()); // TEST
//		System.out.println(dir.toString()); // TEST

		 // 2. listFilesを使用してファイル一覧を取得
		File[] textFileList = dir.listFiles();

		// System.out.println(Arrays.toString(list));
		// 3. ファイル名一覧を格納するArrayList作成
		this.textFileNameList = new ArrayList<String>();

		// 正規表現で検索するための文字列を作成
		String regex = "^.*(Sentakushi)(.{1,})";

		// 4. 拡張for文でtextFileListからtextFileオブジェクトをひとつづつ取り出してゆく
		for(File textFile: textFileList) {
			// if分で textFile.toString() が "Sentakushi*"
			// に合致するときにその文字列(textFile.toString())を add する
			if(Pattern.matches(regex, textFile.toString())){
				textFileNameList.add(textFile.toString());
			}
		}

	    return textFileNameList;
	}

	/**
	 * fileRomdomSelector()メソッド
	 * getTxtFileNameListメソッドで取得した fileNameList フィールドからRandomクラスを使い
	 * フォルダにあるファイル名の一覧からランダムでひとつ選択するメソッド
	 *
	 * @param なし
	 * @return String フォルダにあるファイル名の一覧からランダムで選ばれたファイル名
	 */
//	String fileRomdomSelector() {
//		// Randomクラス作成
//		Random random = new Random();
//		// RandomクラスのnexiIntメソッドで乱数取得
//		int rondomNum = random.nextInt(this.getFileNameList().size());
//		// ArrayListのget()メソッドの引数に取得した乱数を入れる
//		return getFileNameList().get(rondomNum);
//	}



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

		setDirName(filePath);

		// System.out.println(dirName); // TEST
	/**
	 * ■getTextFileNameList(String dirName)の内容 :
	 * 引数にディレクトリの名前を入れるとそのディレクトリにある ファイル名の一覧を返してくれるメソッド。
	 */
		//getTxtFileNameList(dirName);

		// 2.Sentakushiが格納されているファイル群の内、一つのファイルをランダムで選択
		int[] randomNum = RandomUniqueNumberGenerator.randomNoGenerator(setTxtFileNameList(dirName).size());
		String returnValue = setTxtFileNameList(dirName).get(randomNum[0]);

		return returnValue;
	}

	/**
	 * Sentakushi??.txt の 中身を読み込んで musicTitleNameList フィールドに代入するメソッド
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

	public static void main(String[] args) {
		// displayメソッドを使うためにDisplayクラスをインスタンス化
		// display1.Display display = new display1.Display();
		NameSelector s = new NameSelector();
		LinkFileNameToMp3 link = new LinkFileNameToMp3("music_title.txt");

		Set<String> keys = link.linkedList.keySet();
		for (int i = 0; i < keys.size(); i++) {
		    String key = keys.toArray(new String[0])[i];
		    System.out.println(key + " => " + link.linkedList.get(key));
		}

		System.out.println(s.setDirName("Sentakushi01.txt"));
		List<String> fileNameList = s.setTxtFileNameList(s.setDirName("Sentakushi01.txt"));
		fileNameList.forEach(e -> {
			System.out.println(e);
		});



	}
}
