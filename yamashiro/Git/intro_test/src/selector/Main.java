package selector;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class Main {

    private static final String PACKAGE_SEPARATOR = ".";

    private static final String CLASS_SUFFIX = ".txt";

    public static void main(String[] args) throws IOException, URISyntaxException {
        // クラスローダを利用して、パッケージ配下のリソースを取得する。
        String rootPackageName = ".".replace(PACKAGE_SEPARATOR, File.separator);
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Enumeration<java.net.URL> rootUrls = classLoader.getResources(rootPackageName);

        // ディレクトリを再帰的に探索して、".class"で終わるファイルを見つけた場合は
        // 文字列を整形したのちにリストへ格納しておく。
        PriorityQueue<String> classNames = new PriorityQueue();
        while (rootUrls.hasMoreElements()) {
            java.net.URL rootUrl = rootUrls.nextElement();
            Path rootPath = Paths.get(rootUrl.toURI());

            Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
                    String pathName = path.toString();
                    if (pathName.endsWith(CLASS_SUFFIX)) {
                        int beginIndex = pathName.lastIndexOf(rootPackageName);
                        int endIndex = pathName.lastIndexOf(CLASS_SUFFIX);
                        String className = pathName.substring(beginIndex, endIndex)
                                                   .replace(File.separator, PACKAGE_SEPARATOR);

                        classNames.add(className);
                    }

                    return super.visitFile(path, attrs);
                }
            });
        }

        List<String> array = new ArrayList<>();

        String regrex = "Sentakushi";

        // 見つけ出したクラス名の一覧を出力する。
        for (String className : classNames) {
        	if(Pattern.matches(regrex, className)) {

        	}
            System.out.println(className);
        }

    }
}