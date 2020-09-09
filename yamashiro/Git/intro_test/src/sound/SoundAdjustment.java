package sound;

public interface SoundAdjustment {
	/**
	 * 読み込まれた音声ファイルを長めに再生するメソッド
	 * @param なし
	 */
	public void playLong(String filePath);

	/**
	 * 読み込まれた音声ファイルを中くらいの速度で再生するメソッド
	 * @param なし
	 */
	public void playMiddle(String filePath);

	/**
	 * 読み込まれた音声ファイルを短めに再生するメソッド
	 * @param なし
	 */
	public void playShort(String filePath);
}
