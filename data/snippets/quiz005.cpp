class CustomerService {
public:
    bool registerCustomer(std::string name, std::string email, std::string phone,
                        std::string street, std::string city, std::string zipCode, 
                        std::string country, std::string creditCardNumber) {
        // 验证电子邮件
        if (email.find('@') == std::string::npos || email.find('.') == std::string::npos) {
            return false;
        }
        
        // 验证电话号码
        if (phone.length() < 10 || !std::all_of(phone.begin(), phone.end(), ::isdigit)) {
            return false;
        }
        
        // 验证邮政编码
        if (zipCode.length() != 5 || !std::all_of(zipCode.begin(), zipCode.end(), ::isdigit)) {
            return false;
        }
        
        // 验证信用卡号
        if (creditCardNumber.length() != 16 || !std::all_of(creditCardNumber.begin(), creditCardNumber.end(), ::isdigit)) {
            return false;
        }
        
        // 保存客户信息到数据库
        std::string fullAddress = street + ", " + city + " " + zipCode + ", " + country;
        saveCustomer(name, email, phone, fullAddress, creditCardNumber);
        return true;
    }
    
private:
    void saveCustomer(std::string name, std::string email, std::string phone, 
                    std::string address, std::string creditCardNumber) {
        // 保存到数据库的代码...
    }
};
