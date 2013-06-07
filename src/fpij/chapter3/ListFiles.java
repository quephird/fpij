package fpij.chapter3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {
        listFiles();
        listDirectories();
    }

    private static void listFiles() {
        try {
            System.out.println("Listing all files:");
            // This differs from the text; newDirectoryStream() does not return anything exposing entries().
            Files.newDirectoryStream(Paths.get("."))
                    .stream()
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void listDirectories() {
        try {
            System.out.println("Listing directories only:");
            // This differs from the text; newDirectoryStream() does not return anything exposing entries().
            Files.newDirectoryStream(Paths.get("."))
                    .stream()
                    .filter(Files::isDirectory)
                    .forEach(System.out::println);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
