/*
 * 112�s�� Windows ��Mac ���łǂ��炩�̃R�����g���O���Ďg�p����
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
	 *  �t�H���_�ɂ���t�@�C�����ꗗ���i�[���郊�X�g
	 */
	public List<String> textFileNameList;

	/**
	 * Sentakushi??.txt���̋Ȗ����i�[���郊�X�g
	 */
	List<String> musicTitleNameList;

	/**
	 *  Sentakushi??.txt������t�H���_�̃p�X����\���t�B�[���h
	 */
	String dirName;




	/**
	 * �����Ƀt�@�C����������Ɓu���̃t�@�C�����������Ă���t�H���_�̃p�X���v���擾�ł���
	 * 1. �V�X�e�����\�[�X���� Sentakushi01.txt �̃p�X���擾
	 * 2. �t�H���_���ɓ��{�ꂪ�܂܂�Ă���ꍇ�̂��߂�URL���f�R�[�h����
	 *
	 * @param filePath �t�@�C����
	 * @return String �t�H���_�̃p�X��
	 */
	public String setDirName(String filePath){
		// 1. �V�X�e�����\�[�X���� Sentakushi01.txt �̃p�X���擾����
				URI pathToTextFile = null;
				try {
					pathToTextFile = ClassLoader.getSystemResource(filePath).toURI();
					System.out.println("pathToTextFile : " + pathToTextFile.toString());
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				}
				try {
					/*
					 *  2. �t�H���_���ɓ��{�ꂪ�܂܂�Ă���ꍇ�̂��߂�URL���f�R�[�h����B System.getProperty("file.encoding") �����܂������Ȃ������̂�
					 *  ���ڎw�肷��B�������g���Ă�Mac�̏ꍇ�AUTF-8�Ńf�R�[�h����Ƃ��܂��s�����B
					 */
					String encodedResult = URLDecoder.decode(pathToTextFile.toString(), "UTF-8");

					// 3. ���̃t�@�C�����������Ă���f�B���N�g������getParent()���\�b�h�Ŏ擾
					dirName = new File(encodedResult).getParent();

					System.out.println("setDirName���\�b�h��: �ϐ�dirName" + dirName);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		return dirName;
	}

	/**
	 * getFileNames(String dirName)
	 * �����Ƀf�B���N�g���̖��O������Ƃ��̃f�B���N�g���ɂ���
	 * �t�@�C�����̈ꗗ��Ԃ��Ă����B�ȉ��A�����̗���
	 * 1. File�N���X�̃I�u�W�F�N�g�𐶐����Ώۂ̃f�B���N�g�����w��
	 * 2. listFiles���g�p���ăt�@�C���ꗗ���擾
	 * 3. �t�@�C�����ꗗ���i�[����ArrayList�쐬
	 * 4. �g��for����List�ɒǉ����Ă䂭
	 *
	 * @param dirName �f�B���N�g���̖��O
	 * @return List<String> �f�B���N�g���ɂ���t�@�C�����ꗗ
	 */
	public List<String> setTxtFileNameList(String dirName) {

		// 1. File�N���X�̃I�u�W�F�N�g�𐶐����Ώۂ̃f�B���N�g�����w��
		// �Ԃ��Ă��镶����͐擪�Ɂufile:�v�����̂�replace�ō폜
		String tmp1 = dirName.replace("jar:", "");
		String tmp2 = tmp1.replace("file:","");
		File dir = new File(tmp2);

//		System.out.println(dir.isFile()); // TEST
//		System.out.println(dir.toString()); // TEST
//		System.out.println("NameSelector�N���X��: �ϐ�dir :" + dir);

		 // 2. listFiles���g�p���ăt�@�C���ꗗ���擾
		File[] textFileList = dir.listFiles();

		// 3. �t�@�C�����ꗗ���i�[����ArrayList�쐬
		this.textFileNameList = new ArrayList<String>();

		// ���K�\���Ō������邽�߂̕�������쐬
		String regex = "^.*(Sentakushi)(.{1,})";

//		System.out.println(textFileList.length);

		// 4. �g��for����textFileList����textFile�I�u�W�F�N�g���ЂƂÂ��o���Ă䂭
		for(int i = 0; i < textFileList.length; i++) {
			if(Pattern.matches(regex, textFileList[i].toString())){
				String tmpString = textFileList[i].toString().replace(regex, textFileList[i].toString());
				textFileNameList.add(tmpString);
			}
		}
	    return textFileNameList;
	}


	/**
	 * SentakushiXX.txt ���i�[����Ă���t�H���_����
	 * �����_����Sentakushi�t�@�C������I�т��̃t�@�C������Ԃ����\�b�h
	 * �ȉ������̗���
	 * 1. setDirName���\�b�h��Sentakushi01.txt���i�[����Ă���f�B���N�g���̃p�X�̕������dirName�t�B�[���h�ɃZ�b�g
	 * 2. Sentakushi�t�H���_�ɂ���t�@�C�����̈ꗗ���擾
	 * 3. Sentakushi�t�H���_�ɂ���t�@�C���Q�̓��A��̃t�@�C���������_���őI��
	 *
	 * @param filePath SentakushiXX.txt (XX�́A���݂���Ȃ牽�ł������ł�)
	 * @return String textFileNameList ���烉���_���ň�I�΂ꂽ�v�f
	 */
	public String getRomdomTextFileName(String filePath) {

		// 1. setDirName���\�b�h��Sentakushi01.txt���i�[����Ă���f�B���N�g���̃p�X�̕������dirName�t�B�[���h�ɃZ�b�g
		setDirName(filePath);

		// 2. 3. Sentakushi���i�[����Ă���t�@�C���Q�̓��A��̃t�@�C���������_���őI��
		int[] randomNum = RandomUniqueNumberGenerator.randomNoGenerator(setTxtFileNameList(dirName).size());
		String returnValue = setTxtFileNameList(dirName).get(randomNum[0]);

		return returnValue;
	}

	/**
	 * Sentakushi??.txt �� ���g��ǂݍ���� musicTitleNameList �t�B�[���h�ɑ�����郁�\�b�h
	 * @param filePath Sentakushi??.txt �t�@�C���̃p�X��
	 * @return List<String> musicTitleNameList �t�B�[���h
	 */
	public List<String> readTextFile(String filePath) {
		// BufferedReader�Ŏg�p���邽�߂� �ϐ� tmp
		String tmp = null;
		// ���K�\���������t�B���^�[��������
		// Windows �̏ꍇ
		// String regex = "\\\\t|\\\\n|\\\\r|\\\\r\\\\n";
		// Mac �̏ꍇ
		String regex = "\\t|\\n|\\r|\\r\\n";
		Pattern p = Pattern.compile(regex);
		musicTitleNameList = new ArrayList<>();

		// �V�X�e�����\�[�X����t�@�C���̃p�X��ǂݍ���
		InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

			while ((tmp = br.readLine()) != null) {
				if(tmp.equals(" ")) { // 1. ���K�\���ňȉ��̕�����ɍ��v����ꍇ�� continuie ����
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
	 * Sentakushi.txt �� ���̋Ȗ����烉���_���� 3 �I�ԃ��\�b�h
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
