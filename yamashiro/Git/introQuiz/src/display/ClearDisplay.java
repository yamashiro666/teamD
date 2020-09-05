package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClearDisplay {
	public ClearDisplay(){
//		// ProcessBuilder�̐���
//		// helloworld.bat��stdin��stderr��e�v���Z�X��stdin��stderr�ɂȂ��B
//		ProcessBuilder processBuilder = new ProcessBuilder("test.command");
//		processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
//		processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
//
//		// Process�̐���
//		// helloworld.bat���q�v���Z�X�Ƃ��Ď��s���A�v���Z�X���s���I���܂Őe�X���b�h���~����B
//		Process process;
//		try {
//			process = processBuilder.start();
//			process.waitFor();
//		} catch (IOException | InterruptedException e) {
//			// TODO �����������ꂽ catch �u���b�N
//			e.printStackTrace();
//		}
		try {
            Process process = new ProcessBuilder("clear").start();
            InputStreamReader isr = new InputStreamReader(process.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char)c);
            }
//            System.out.println("result:\n" + builder.toString());
//            System.out.println("Command return code: " + process.waitFor());
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}
}
