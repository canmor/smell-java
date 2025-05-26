class UserService {
public:
    void createUser(const std::string& name, const std::string& email) {
        // 验证输入（重复代码开始）
        if (name.empty()) {
            throw std::invalid_argument("Name cannot be empty");
        }
        if (email.empty()) {
            throw std::invalid_argument("Email cannot be empty");
        }
        if (email.find('@') == std::string::npos) {
            throw std::invalid_argument("Invalid email format");
        }
        if (name.length() < 2) {
            throw std::invalid_argument("Name too short");
        }
        // 验证输入（重复代码结束）
        
        User user(name, email);
        database.save(user);
    }
    
    void updateUser(int id, const std::string& name, const std::string& email) {
        // 验证输入（重复代码开始）
        if (name.empty()) {
            throw std::invalid_argument("Name cannot be empty");
        }
        if (email.empty()) {
            throw std::invalid_argument("Email cannot be empty");
        }
        if (email.find('@') == std::string::npos) {
            throw std::invalid_argument("Invalid email format");
        }
        if (name.length() < 2) {
            throw std::invalid_argument("Name too short");
        }
        // 验证输入（重复代码结束）
        
        User user = database.findById(id);
        user.setName(name);
        user.setEmail(email);
        database.update(user);
    }
    
private:
    Database database;
};
