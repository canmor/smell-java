class User {
private:
    std::string firstName;
    std::string lastName;
    std::string email;
    std::string phone;
    std::string address;
    std::string city;
    std::string zipCode;
    
public:
    // 只有getter和setter方法
    std::string getFirstName() const { return firstName; }
    void setFirstName(const std::string& name) { firstName = name; }
    std::string getEmail() const { return email; }
    void setEmail(const std::string& e) { email = e; }
    // ... 更多getter/setter
};
