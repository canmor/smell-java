#include <fstream>
#include <string>
#include <streambuf>

class FileReader {
public:
    std::string readFile(const std::string& filename) {
        std::ifstream file(filename);
        std::string content((std::istreambuf_iterator<char>(file)),
                           std::istreambuf_iterator<char>());
        return content;
    }
    
    bool fileExists(const std::string& filename) {
        std::ifstream file(filename);
        return file.good();
    }
    
    size_t getFileSize(const std::string& filename) {
        std::ifstream file(filename, std::ios::binary | std::ios::ate);
        return file.tellg();
    }
};

class DocumentLoader {
public:
    // 功能相同但方法名不同
    std::string loadDocument(const std::string& path) {
        std::ifstream file(path);
        std::string content((std::istreambuf_iterator<char>(file)),
                           std::istreambuf_iterator<char>());
        return content;
    }
    
    bool documentExists(const std::string& path) {
        std::ifstream file(path);
        return file.good();
    }
    
    // 参数顺序也不同
    long getDocumentSize(const std::string& path) {
        std::ifstream file(path, std::ios::binary | std::ios::ate);
        return file.tellg();
    }
};