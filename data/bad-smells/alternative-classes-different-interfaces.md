---
slug: "alternative-classes-different-interfaces"
nameCn: "不同接口的相似类"
nameEn: "Alternative Classes with Different Interfaces"
category: "Object-Orientation Abusers"
description: "两个类功能相似但接口不同。"
exampleFile: "alternative-classes-different-interfaces.cpp"
---

# 简介

当两个类做相同的事情但有不同的方法名时，就出现了这种坏味道。这增加了学习成本和维护难度，也违反了一致性原则。

## 识别要点

- 两个类提供相似的功能
- 方法名不同但功能相同
- 参数类型或顺序不一致
- 增加了使用者的学习成本

## 重构建议

1. **统一接口**：让相似的类实现相同的接口
2. **重命名方法**：使用一致的命名约定
3. **提取超类**：为共同行为创建基类
4. **合并类**：如果功能完全相同，考虑合并

## 说明

这两个类做相同的事情但接口不同，应该统一接口或合并类。这样可以减少学习成本，提高代码的一致性。
\`\`\`

```cpp file="data/examples/alternative-classes-different-interfaces.cpp"
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
