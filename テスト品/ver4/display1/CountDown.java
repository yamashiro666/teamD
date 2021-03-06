package display1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import sound.Music;
import sound.Sounds;


class CountDown extends Display{

		StringBuffer strBuffer = new StringBuffer();
		BufferedReader in = null;
		FileReader fr = null;

	@Override
	public void display(String filePath){

		Sounds sound = new Music();
		sound.playMp3("Countdown06-2.mp3");
		try{

			InputStream ips1 = ClassLoader.getSystemResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(ips1, "SJIS"));

//			fr = new FileReader(filePath);
//			in = new BufferedReader(fr);

			int count = 1;
			String str;
			while(br.ready() == true){
				strBuffer.append(br.readLine()+'\n');
				if(count % 64 == 0){
					try{
					Thread.sleep(1090);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}

				str = strBuffer.toString();
				System.out.print(str);
				strBuffer = strBuffer.delete(0, strBuffer.length());

				count++;


			}

		}catch(IOException e){

			System.out.println("Test");
			e.printStackTrace();

		}finally{

			try{
				if(in != null){

					in.close();
				}

			}catch(IOException ie){
				System.out.println("a");
				ie.printStackTrace();
			}

		}
	}
}

