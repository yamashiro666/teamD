package sound;

public interface SoundAdjustment {
	/**
	 * �ǂݍ��܂ꂽ�����t�@�C���𒷂߂ɍĐ����郁�\�b�h
	 * @param �Ȃ�
	 */
	public void playLong(String filePath);

	/**
	 * �ǂݍ��܂ꂽ�����t�@�C���𒆂��炢�̑��x�ōĐ����郁�\�b�h
	 * @param �Ȃ�
	 */
	public void playMiddle(String filePath);

	/**
	 * �ǂݍ��܂ꂽ�����t�@�C����Z�߂ɍĐ����郁�\�b�h
	 * @param �Ȃ�
	 */
	public void playShort(String filePath);
}
