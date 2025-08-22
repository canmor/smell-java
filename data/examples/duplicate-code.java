class UserService {
    private Database database;
    
    public void createUser(String name, String email) {
        // Input validation (duplicate code starts)
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name too short");
        }
        // Input validation (duplicate code ends)
        
        User user = new User(name, email);
        database.save(user);
    }
    
    public void updateUser(int id, String name, String email) {
        // Input validation (duplicate code starts)
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name too short");
        }
        // Input validation (duplicate code ends)
        
        User user = database.findById(id);
        user.setName(name);
        user.setEmail(email);
        database.update(user);
    }
}

// Supporting classes for demonstration
class User {
    private String name;
    private String email;
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Database {
    public void save(User user) { /* implementation */ }
    public void update(User user) { /* implementation */ }
    public User findById(int id) { return new User("", ""); }
}
