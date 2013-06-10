package fpij.chapter3;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListSelectedFiles {
    private static final String CHAPTER_THREE_SOURCE_PATH = "./src/fpij/chapter3";

    public static void main(String[] args) throws Exception {
        preJdk8();
        jdk8();
    }

    private static void preJdk8() {
        System.out.println("Filtering .java files before JDK8...");
        final String[] javaFileNames =
                new File(CHAPTER_THREE_SOURCE_PATH).list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".java");
                    }
                });
        for (String fileName : Arrays.asList(javaFileNames)) {
            System.out.println(fileName);
        }
    }

    private static void jdk8() throws Exception {
        System.out.println("Filtering .java files in JDK8...");
        Files.newDirectoryStream(Paths.get(CHAPTER_THREE_SOURCE_PATH))
                .stream()
                .filter(path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }
}
