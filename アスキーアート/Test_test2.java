import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Thread;


class Test_test2{
	public static void main(String[] args){
		StringBuffer strBuffer = new StringBuffer();
		BufferedReader in = null;
		FileReader fr = null;
		
		try{
			fr = new FileReader("pic.txt");
			in = new BufferedReader(fr);
			
			int count = 1;
			String str;
			while(in.ready() == true){
				strBuffer.append(in.readLine()+'\n');
				if(count % 64 == 0){
					try{
					Thread.sleep(1000);
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
				System.out.println("����");
				e.printStackTrace();
			}finally{
				try{
					if(in != null){
						in.close();}
				}catch(IOException ie){
					System.out.println("a");
					ie.printStackTrace();
				}
			}
			
			
		}
	}

