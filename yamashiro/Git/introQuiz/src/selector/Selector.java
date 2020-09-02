package selector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Selector {

	File file;

	void fileSelector(String junle) {
		try {
			FileReader fileReader = new FileReader(new File("sentakusi/" + junle + ".txt"));

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
