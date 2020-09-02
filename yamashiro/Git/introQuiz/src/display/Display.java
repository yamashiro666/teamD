package display;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// スーパークラス
public abstract class Display{

	// プレイヤーが押したキーを保持するフィールド
	private char pressedKey;

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

		StringBuffer strBuffer = new StringBuffer();

		try {
			// 1. FileReader でリーダー作成
			FileReader fileReader = new FileReader(filePath);
			// 2. 1で作成したオブジェクトを BufferedReader でラップする
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;

            // 3. BufferedReader の readLineメソッドで 1行単位で読み込み
            while ((data = bufferedReader.readLine()) != null) {
            	strBuffer.append(data);
            }
            fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4. コマンドプロンプトへ出力
		System.out.println(strBuffer);
	}

	/**
	 *  ■waiting()メソッドの処理内容
	 *  1. InputStreamReaderを使い、入力待ち状態を作る。
	 *  2. 押されたキーをフィールド pressedKey に代入する。
	 */
	public void waiting(){
		// 1. InputStreamReaderを使い、入力待ち状態を作る。
		Reader reader = new InputStreamReader(System.in);

		try {
			// 2. 押されたキーをフィールド pressedKey に代入する。
			this.pressedKey = (char)reader.read();
			reader.close();
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

}
