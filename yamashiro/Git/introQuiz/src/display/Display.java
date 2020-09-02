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

	public void display(String filePath) {

		StringBuffer strBuffer = new StringBuffer();

		try {
			FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;

            while ((data = bufferedReader.readLine()) != null) {
            	strBuffer.append(data);
            }
            fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(strBuffer);
	}

	/*
	 * waiting()メソッドの処理内容
	 *  1. InputStreamReaderを使い、入力待ち状態を作る。
	 *  2. 押されたキーをフィールド pressedKey に代入する。
	 *  3. 代入された pressedKey を使いselector()メソッド内で処理を振り分けてゆく
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

	public void selector(){}

}
