package fpij.chapter5;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    private final FileWriter writer;

    public FileWriterExample(final String fileName) throws IOException {
        this.writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void finalize() throws IOException {
        writer.close();
    }

    public void close() throws IOException {
        System.out.println("close() invoked.");
        writer.close();
    }
}
