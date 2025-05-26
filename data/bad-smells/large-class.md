---
slug: "large-class"
nameCn: "过大的类"
nameEn: "Large Class"
category: "Bloaters"
description: "类包含过多的字段、方法或代码行，违反了单一职责原则。"
exampleFile: "large-class.cpp"
---

# 简介

当一个类试图做太多事情时，它就会变得过大。大类难以理解和维护，通常表明违反了单一职责原则。

## 识别要点

- 类的代码行数过多
- 包含过多的字段和方法
- 承担多个不相关的职责
- 难以理解类的整体功能

## 重构建议

1. **提取类**：将相关的字段和方法提取到新的类中
2. **委托模式**：使用组合替代继承
3. **单一职责**：确保每个类只有一个变化的原因

## 说明

这个类承担了游戏管理、渲染、音频、网络、文件系统等多个职责，应该拆分为多个专门的类，每个类负责一个特定的领域。
\`\`\`

```cpp file="data/examples/large-class.cpp"
class GameManager {
private:
    // 玩家管理
    std::vector<Player> players;
    Player currentPlayer;
    
    // 游戏状态
    GameState state;
    int currentLevel;
    int score;
    
    // 渲染相关
    Renderer renderer;
    Camera camera;
    std::vector<Sprite> sprites;
    
    // 音频相关
    AudioEngine audioEngine;
    std::vector<Sound> sounds;
    
    // 网络相关
    NetworkManager network;
    std::vector<NetworkMessage> messages;
    
    // 文件系统
    FileManager fileManager;
    SaveData saveData;

public:
    void updateGame();
    void renderGame();
    void handleInput();
    void playSound(int soundId);
    void saveGame();
    void loadGame();
    void sendNetworkMessage();
    void receiveNetworkMessage();
    void addPlayer(Player player);
    void removePlayer(int playerId);
    void updateCamera();
    void loadTextures();
    // ... 还有很多方法
};
