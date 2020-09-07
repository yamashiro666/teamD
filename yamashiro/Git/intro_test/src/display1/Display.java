package display1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

// �X�[�p�[�N���X
public class Display{

	// �v���C���[���������L�[��ێ�����t�B�[���h
	private char pressedKey;

	private BufferedReader bufferedReader;
	private Reader reader;

	// pressedKey ���擾����ׂ̃��\�b�h
	public char getPressedKey() {
		return this.pressedKey;
	}

	/**
	 *  ��display���\�b�h�̏������e
	 *  1. FileReader �Ń��[�_�[�쐬
	 *  2. 1�ō쐬�����I�u�W�F�N�g�� BufferedReader �Ń��b�v����
	 *  3. BufferedReader �� readLine���\�b�h�� 1�s�P�ʂœǂݍ���
	 *  4. �R�}���h�v�����v�g�֏o��
	 *
	 *  @param filePath �e�L�X�g�t�@�C���̃p�X
	 */
	public void display(String filePath) {


		String tmp = null;
		StringBuffer strBuffer = new StringBuffer();

		// �V�X�e�����\�[�X����t�@�C���̃p�X��ǂݍ���
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

		// �N���X�p�X���w�肵�ēǂݍ��ރp�^�[��
		// InputStream input = getClass().getResourceAsStream(filePath);


//		try {

//			BufferedInputStream bis =
//				     new BufferedInputStream(getClass().getResourceAsStream(filePath));

			// �ʏ��FileInputStream���g�p���ēǂݍ��ރp�^�[��
			// FileInputStream is = new FileInputStream(filePath);

            // InputStreamReader in = new InputStreamReader(ips1, "SJIS");
			/**
			*  1. FileReader �Ń��[�_�[�쐬
			*  FileReader fileReader = new FileReader(filePath);
			* System.out.println(in.getEncoding());
			* 2. 1�ō쐬�����I�u�W�F�N�g�� BufferedReader �Ń��b�v����
			*/
            // bufferedReader = new BufferedReader(in);
            // String data;

            // 3. BufferedReader �� readLine���\�b�h�� 1�s�P�ʂœǂݍ���
            // while ((data = bufferedReader.readLine()) != null) {
            // 	strBuffer.append(data + "\n");
            // }

//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		// 4. �R�}���h�v�����v�g�֏o��
		System.out.println(strBuffer);
	}

	/**
	 *  ��input()���\�b�h�̏������e
	 *  1. InputStreamReader���g���A���͑҂���Ԃ����B
	 *  2. �����ꂽ�L�[���t�B�[���h pressedKey �ɑ������B
	 */
	public void input(){
		// 1. InputStreamReader���g���A���͑҂���Ԃ����B
		reader = new InputStreamReader(System.in);

		try {

			// 2. �����ꂽ�L�[���t�B�[���h pressedKey �ɑ������B
				this.pressedKey = (char)reader.read();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * ��selector���\�b�h�̏������e
	 * 1. waiting���\�b�h�ő�����ꂽ pressedKey �t�B�[���h���g��
	 * ������U�蕪����
	 */
	public void selector(){}

	// �Q�[���I����(Exit��ʕ\����)�ɃX�g���[�������
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

