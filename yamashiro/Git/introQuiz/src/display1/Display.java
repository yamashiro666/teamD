package display1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

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

		StringBuffer strBuffer = new StringBuffer();

		try {

			FileInputStream is = new FileInputStream(filePath);
            InputStreamReader in = new InputStreamReader(is, "SJIS");
			// 1. FileReader �Ń��[�_�[�쐬
			// FileReader fileReader = new FileReader(filePath);
			// System.out.println(in.getEncoding());
			// 2. 1�ō쐬�����I�u�W�F�N�g�� BufferedReader �Ń��b�v����
            bufferedReader = new BufferedReader(in);
            String data;

            // 3. BufferedReader �� readLine���\�b�h�� 1�s�P�ʂœǂݍ���
            while ((data = bufferedReader.readLine()) != null) {
            	strBuffer.append(data + "\n");
            }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

