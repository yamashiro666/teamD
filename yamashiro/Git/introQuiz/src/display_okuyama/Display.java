package display_okuyama;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

// スーパ�?�クラス
public abstract class Display{

	// プレイヤーが押したキーを保持するフィール�?
	private char pressedKey;

	// pressedKey を取得する為のメソ�?�?
	public char getPressedKey() {
		return this.pressedKey;
	}

	/**
	 *  �?displayメソ�?ド�?�処�?�?容
	 *  1. FileReader でリー�?ー作�??
	 *  2. 1で作�?�したオブジェクトを BufferedReader でラ�?プす�?
	 *  3. BufferedReader の readLineメソ�?ドで 1行単位で読み込み
	 *  4. コマンド�?�ロンプトへ出�?
	 *
	 *  @param filePath �?キストファイルのパス
	 */
	public void display(String filePath) {

		StringBuffer strBuffer = new StringBuffer();

		try {
			// 1. FileReader でリー�?ー作�??
			FileReader fileReader = new FileReader(filePath);
			// 2. 1で作�?�したオブジェクトを BufferedReader でラ�?プす�?
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;

            // 3. BufferedReader の readLineメソ�?ドで 1行単位で読み込み
            while ((data = bufferedReader.readLine()) != null) {
            	strBuffer.append(data);
            }
            fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 4. コマンド�?�ロンプトへ出�?
		System.out.println(strBuffer);
	}

	/**
	 *  �?waiting()メソ�?ド�?�処�?�?容
	 *  1. InputStreamReaderを使�?、�?�力�?ち状態を作る�?
	 *  2. 押されたキーをフィール�? pressedKey に代入する�?
	 */
	public void waiting(){
		// 1. InputStreamReaderを使�?、�?�力�?ち状態を作る�?
		Reader reader = new InputStreamReader(System.in);

		try {
			// 2. 押されたキーをフィール�? pressedKey に代入する�?
			this.pressedKey = (char)reader.read();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * �?selectorメソ�?ド�?�処�?�?容
	 * 1. waitingメソ�?ドで代入され�? pressedKey フィールドを使�?
	 * 処�?を振り�?ける
	 */
	public void selector(){}

}
