import java.io.*;
import java.nio.file.*;

class FileReader {
    public String readFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    
    public boolean fileExists(String filename) {
        return Files.exists(Paths.get(filename));
    }
    
    public long getFileSize(String filename) throws IOException {
        return Files.size(Paths.get(filename));
    }
}

class DocumentLoader {
    // Same functionality but different method names
    public String loadDocument(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    
    public boolean documentExists(String path) {
        return Files.exists(Paths.get(path));
    }
    
    // Different parameter order and return type
    public int getDocumentSize(String path) throws IOException {
        return (int) Files.size(Paths.get(path));
    }
}
