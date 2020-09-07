package display1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

// スーパークラス
public class Display{

	// プレイヤーが押したキーを保持するフィールド
	private char pressedKey;

	private BufferedReader bufferedReader;
	private Reader reader;

	// pressedKey を取得する為のメソッド
	public char getPressedKey() {
		return this.pressedKey;
	}

	/**
	 *  ■displayメソッドの処理内容
	 *  1. FileReader でリーダー作成
	 *  2. 1で作成したオブジェクトを BufferedReader でラップする
	 *  3. BufferedReader の readLineメソッドで 1行単位で読み込み
	 *  4. コマンドプロンプトへ出力
	 *
	 *  @param filePath テキストファイルのパス
	 */
	public void display(String filePath) {


		String tmp = null;
		StringBuffer strBuffer = new StringBuffer();

		// システムリソースからファイルのパスを読み込む
		InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);
		// System.out.println(ClassLoader.getSystemResource(filePath)); // TEST

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

			while ((tmp = br.readLine()) != null) {
				strBuffer.append(tmp + "\n");
	         }

		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		// クラスパスを指定して読み込むパターン
		// InputStream input = getClass().getResourceAsStream(filePath);


//		try {

//			BufferedInputStream bis =
//				     new BufferedInputStream(getClass().getResourceAsStream(filePath));

			// 通常のFileInputStreamを使用して読み込むパターン
			// FileInputStream is = new FileInputStream(filePath);

            // InputStreamReader in = new InputStreamReader(ips1, "SJIS");
			/**
			*  1. FileReader でリーダー作成
			*  FileReader fileReader = new FileReader(filePath);
			* System.out.println(in.getEncoding());
			* 2. 1で作成したオブジェクトを BufferedReader でラップする
			*/
            // bufferedReader = new BufferedReader(in);
            // String data;

            // 3. BufferedReader の readLineメソッドで 1行単位で読み込み
            // while ((data = bufferedReader.readLine()) != null) {
            // 	strBuffer.append(data + "\n");
            // }

//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// 4. コマンドプロンプトへ出力
		System.out.println(strBuffer);
	}

	/**
	 *  ■input()メソッドの処理内容
	 *  1. InputStreamReaderを使い、入力待ち状態を作る。
	 *  2. 押されたキーをフィールド pressedKey に代入する。
	 */
	public void input(){
		// 1. InputStreamReaderを使い、入力待ち状態を作る。
		reader = new InputStreamReader(System.in);

		try {

			// 2. 押されたキーをフィールド pressedKey に代入する。
				this.pressedKey = (char)reader.read();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * ■selectorメソッドの処理内容
	 * 1. waitingメソッドで代入された pressedKey フィールドを使い
	 * 処理を振り分ける
	 */
	public void selector(){}

	// ゲーム終了時(Exit画面表示時)にストリームを閉じる
	public void streamClose() {
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

