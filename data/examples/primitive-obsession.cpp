class User {
private:
    std::string firstName;
    std::string lastName;
    std::string email;
    std::string phone;
    std::string address;
    std::string city;
    std::string zipCode;
    std::string country;
    
public:
    bool isValidEmail(const std::string& email) {
        return email.find('@') != std::string::npos;
    }
    
    bool isValidPhone(const std::string& phone) {
        return phone.length() >= 10;
    }
    
    std::string getFullAddress() {
        return address + ", " + city + " " + zipCode + ", " + country;
    }
    
    // 验证逻辑分散，缺乏类型安全
    void updateEmail(const std::string& newEmail) {
        if (isValidEmail(newEmail)) {
            email = newEmail;
        }
    }
};
