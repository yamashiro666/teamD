package teamD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// スーパークラス
public class Display implements Runnable{

	void display(String filePath) {

		StringBuffer strBuffer = new StringBuffer();

		try {
			FileReader fileReader = new FileReader("CourseSelect.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String data;

            int count = 0;

            while ((data = bufferedReader.readLine()) != null) {
            	try {

            		if(count % 18 == 0)
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
                System.out.println(data);
                count++;
            }

            fileReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		System.out.println(strBuffer);

	}

	 void waiting() {

	}
}
