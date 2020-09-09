package selector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class LinkFileNameToMp3 {

	/**
	 *  music_tiile.txt�̓��e��Map�Ǘ�����t�B�[���h
	 *  Map<"�Ȗ�" , "mp3�t�@�C����"> �ŊǗ�
	 */
	public Map<String, String> linkedList;

	/**
	 * �R���X�g���N�^��music_tiile.txt ���� ������� Map<String,String>�Ɋi�[����
	 * 1.  �u�Ȗ��v�Ɓump3�t�@�C���ւ̃p�X�̕�����v���y�A�ŊǗ�����R���N�V����HashMap���쐬
	 * 2.  for���Ŋi�[���Ă䂭�̂ŃC�e���[�^�[�쐬
	 * 3.  BufferedReader��1�s���ǂݍ���ł䂭
	 * 4.  �p�ӂ����C�e���[�^�[��HashMap�Ɋi�[���Ă䂭
	 *
	 *  @param filePath �Ȗ���mp3���y�A�ŋL�q���ꂽ�e�L�X�g�t�@�C��(music_title.txt)
	 */
	public LinkFileNameToMp3(String filePath) {

		//  1.  linkedList�t�B�[���h���C���X�^���X��
		this.linkedList = new HashMap<>();
		List<String> arrayList = new ArrayList<>();
		//  2.  for���Ŋi�[���Ă䂭�̂ŃC�e���[�^�[�쐬
		Iterator<String> iterator = arrayList.iterator();

		BufferedReader bf = null;
		String data = null;
		InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);


		try {
			bf = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

			// 3.  BufferedReader��1�s���ǂݍ���ł䂭
			while ((data = bf.readLine()) != null) {
				// data.replaceAll(p.toString(), "\\s");
            	arrayList.add(data);
            }
			bf.close();
			// System.out.println(bf.ready());

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {


		}

		// 4.  �p�ӂ����C�e���[�^�[��HashMap�Ɋi�[���Ă䂭
		for(int i = 0; i < arrayList.size()-1; i+=2) {

			if(!iterator.hasNext()) {
				break;
			}
			this.linkedList.put(arrayList.get(i), arrayList.get(i+1));
		}
	} // LinkFileNameToMp3 �R���X�g���N�^�u���b�N�I���

	/**
	 * linkedList �̃Q�b�^�[���\�b�h
	 */
	public Map<String, String> getLinkedList() {
		return linkedList;
	}

	public static <T, E> Set<T> getKeysByValue(Map<T, E> map, E value) {
	    Set<T> keys = new HashSet<T>();
	    for (Entry<T, E> entry : map.entrySet()) {
	        if (Objects.equals(value, entry.getValue())) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}
}
