package selector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Selector2 {

	// �t�H���_�ɂ���t�@�C�����ꗗ���i�[���郊�X�g
	private List<String> fileNameList;


	List<String> getFileNameList(){
		return fileNameList;
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

	List<String> getTxtFileNameList(String dirName) {

		// 1. File�N���X�̃I�u�W�F�N�g�𐶐����Ώۂ̃f�B���N�g�����w��
		File dir = new File(dirName);
//		System.out.println(dir.isFile());
//		System.out.println(dir.toString());

		 // 2. listFiles���g�p���ăt�@�C���ꗗ���擾
		File[] list = dir.listFiles();

		// 3. �t�@�C�����ꗗ���i�[����ArrayList�쐬
		this.fileNameList = new ArrayList<String>();

		// 4. �g��for����List�ɒǉ����Ă䂭
		for(File file: list) {
			fileNameList.add(file.getName());
		}

	    return fileNameList;
	}
}
