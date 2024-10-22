package fileIO;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BinaryFileEditor {
    private RandomAccessFile file;

    public BinaryFileEditor(String filePath) throws IOException {
        file = new RandomAccessFile(filePath, "rw");
    }

    public void writeRecord(long position, byte[] data) throws IOException {
        file.seek(position);
        file.write(data);
    }

    public byte[] readRecord(long position, int length) throws IOException {
        file.seek(position);
        byte[] data = new byte[length];
        file.readFully(data);
        return data;
    }

    public void close() throws IOException {
        file.close();
    }
}