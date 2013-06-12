package fpij.chapter5;

import java.io.IOException;

public class FileWriting {
    public static void main(String[] args) throws IOException {
        preJdk7Fail();
        preJdk7Lame();
        preJdk7Better();
        jdk7();
        jdk8();
    }

    public static void preJdk7Fail() throws IOException {
        final FileWriterExample writerExample = new FileWriterExample("fail.txt");
        writerExample.writeStuff("fail");
    }

    public static void preJdk7Lame() throws IOException {
        final FileWriterExample writerExample = new FileWriterExample("lame.txt");
        writerExample.writeStuff("lame");
        writerExample.close();
    }

    public static void preJdk7Better() throws IOException {
        final FileWriterExample writerExample = new FileWriterExample("better.txt");
        try {
            writerExample.writeStuff("better");
        } finally {
            writerExample.close();
        }
    }

    private static void jdk7() throws IOException {
        // Note no smelly finally block, and no explicit call to close().
        try (final FileWriterARM writerARM = new FileWriterARM("ok.txt")) {
            writerARM.writeStuff("ok");
        }
    }

    private static void jdk8() throws IOException {
        FileWriterEAM.use("sweet.txt", writerEAM -> writerEAM.writeStuff("sweet"));
    }
}
