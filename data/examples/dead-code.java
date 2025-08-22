class GameEngine {
    private boolean debugMode;
    private int unusedVariable; // Unused variable
    
    public void startGame() {
        initializeGraphics();
        loadAssets();
        startGameLoop();
    }
    
    // This method is no longer used
    public void oldRenderMethod() {
        // Old rendering logic, replaced by new method
        System.out.println("Old rendering...");
    }
    
    // This method is also no longer used
    public void deprecatedSaveMethod() {
        // Old save logic
        System.out.println("Old save method...");
    }
    
    public void render() {
        // New rendering logic
        System.out.println("New rendering...");
    }
    
    // Code that will never be executed
    public void unreachableCode() {
        return;
        System.out.println("This will never be printed"); // Dead code
    }
    
    /*
    // Commented out old code
    public void oldMethod() {
        // This code should be deleted rather than commented
        System.out.println("Old implementation");
    }
    */
    
    private void initializeGraphics() { /* ... */ }
    private void loadAssets() { /* ... */ }
    private void startGameLoop() { /* ... */ }
    
    // Unused private method
    private void unusedPrivateMethod() {
        System.out.println("This method is never called");
    }
}
