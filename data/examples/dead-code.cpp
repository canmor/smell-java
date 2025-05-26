class GameEngine {
private:
    bool debugMode;
    int unusedVariable; // 未使用的变量
    
public:
    void startGame() {
        initializeGraphics();
        loadAssets();
        startGameLoop();
    }
    
    // 这个方法不再被使用
    void oldRenderMethod() {
        // 旧的渲染逻辑，已被新方法替代
        std::cout << "Old rendering..." << std::endl;
    }
    
    // 这个方法也不再被使用
    void deprecatedSaveMethod() {
        // 旧的保存逻辑
        std::cout << "Old save method..." << std::endl;
    }
    
    void render() {
        // 新的渲染逻辑
        std::cout << "New rendering..." << std::endl;
    }
    
    // 永远不会被执行的代码
    void unreachableCode() {
        return;
        std::cout << "This will never be printed" << std::endl; // 死代码
    }
    
    /*
    // 被注释掉的旧代码
    void oldMethod() {
        // 这些代码应该被删除而不是注释
        std::cout << "Old implementation" << std::endl;
    }
    */
    
private:
    void initializeGraphics() { /* ... */ }
    void loadAssets() { /* ... */ }
    void startGameLoop() { /* ... */ }
    
    // 未使用的私有方法
    void unusedPrivateMethod() {
        std::cout << "This method is never called" << std::endl;
    }
};
