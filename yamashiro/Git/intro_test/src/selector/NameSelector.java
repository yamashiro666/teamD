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
	 *  �t�H���_�ɂ���t�@�C�����ꗗ���i�[���郊�X�g
	 */
	public List<String> textFileNameList;

	List<String> musicTitleNameList;

	/**
	 *  Sentakushi.txt������t�H���_�̃p�X����\���t�B�[���h
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
				URL pathToTextFile = ClassLoader.getSystemResource(filePath);
				try {
					/*
					 *  2. �t�H���_���ɓ��{�ꂪ�܂܂�Ă���ꍇ�̂��߂�URL���f�R�[�h����B System.getProperty("file.encoding") �����܂������Ȃ������̂�
					 *  ���ڎw�肷��B�������g���Ă�Mac�̏ꍇ�AUTF-8�Ńf�R�[�h����Ƃ��܂��s�����B
					 */
					String encodedResult = URLDecoder.decode(pathToTextFile.toString(), "UTF-8");
					// 3. ���̃t�@�C�����������Ă���f�B���N�g������getParent()���\�b�h�Ŏ擾
					dirName = new File(encodedResult).getParent();
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
		File dir = new File(dirName.replace("file:", ""));
//		System.out.println(dir.isFile()); // TEST
//		System.out.println(dir.toString()); // TEST

		 // 2. listFiles���g�p���ăt�@�C���ꗗ���擾
		File[] textFileList = dir.listFiles();

		// System.out.println(Arrays.toString(list));
		// 3. �t�@�C�����ꗗ���i�[����ArrayList�쐬
		this.textFileNameList = new ArrayList<String>();

		// ���K�\���Ō������邽�߂̕�������쐬
		String regex = "^.*(Sentakushi)(.{1,})";

		// 4. �g��for����textFileList����textFile�I�u�W�F�N�g���ЂƂÂ��o���Ă䂭
		for(File textFile: textFileList) {
			// if���� textFile.toString() �� "Sentakushi*"
			// �ɍ��v����Ƃ��ɂ��̕�����(textFile.toString())�� add ����
			if(Pattern.matches(regex, textFile.toString())){
				textFileNameList.add(textFile.toString());
			}
		}

	    return textFileNameList;
	}

	/**
	 * fileRomdomSelector()���\�b�h
	 * getTxtFileNameList���\�b�h�Ŏ擾���� fileNameList �t�B�[���h����Random�N���X���g��
	 * �t�H���_�ɂ���t�@�C�����̈ꗗ���烉���_���łЂƂI�����郁�\�b�h
	 *
	 * @param �Ȃ�
	 * @return String �t�H���_�ɂ���t�@�C�����̈ꗗ���烉���_���őI�΂ꂽ�t�@�C����
	 */
//	String fileRomdomSelector() {
//		// Random�N���X�쐬
//		Random random = new Random();
//		// Random�N���X��nexiInt���\�b�h�ŗ����擾
//		int rondomNum = random.nextInt(this.getFileNameList().size());
//		// ArrayList��get()���\�b�h�̈����Ɏ擾��������������
//		return getFileNameList().get(rondomNum);
//	}



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

		setDirName(filePath);

		// System.out.println(dirName); // TEST
	/**
	 * ��getTextFileNameList(String dirName)�̓��e :
	 * �����Ƀf�B���N�g���̖��O������Ƃ��̃f�B���N�g���ɂ��� �t�@�C�����̈ꗗ��Ԃ��Ă���郁�\�b�h�B
	 */
		//getTxtFileNameList(dirName);

		// 2.Sentakushi���i�[����Ă���t�@�C���Q�̓��A��̃t�@�C���������_���őI��
		int[] randomNum = RandomUniqueNumberGenerator.randomNoGenerator(setTxtFileNameList(dirName).size());
		String returnValue = setTxtFileNameList(dirName).get(randomNum[0]);

		return returnValue;
	}

	/**
	 * Sentakushi??.txt �� ���g��ǂݍ���� musicTitleNameList �t�B�[���h�ɑ�����郁�\�b�h
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

	public static void main(String[] args) {
		// display���\�b�h���g�����߂�Display�N���X���C���X�^���X��
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