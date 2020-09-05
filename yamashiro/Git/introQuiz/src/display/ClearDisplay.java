package display;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClearDisplay {
	public ClearDisplay(){
//		// ProcessBuilderの生成
//		// helloworld.batのstdinとstderrを親プロセスのstdinとstderrにつなぐ。
//		ProcessBuilder processBuilder = new ProcessBuilder("test.command");
//		processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
//		processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);
//
//		// Processの生成
//		// helloworld.batを子プロセスとして実行し、プロセス実行が終わるまで親スレッドを停止する。
//		Process process;
//		try {
//			process = processBuilder.start();
//			process.waitFor();
//		} catch (IOException | InterruptedException e) {
//			// TODO 自動生成された catch ブロック
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
