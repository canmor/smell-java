class Customer {
private:
    std::string name;
    std::string email;
    std::string address;
    double creditLimit;
    
public:
    // 只有getter和setter，没有其他行为
    std::string getName() const { return name; }
    void setName(const std::string& name) { this->name = name; }
    
    std::string getEmail() const { return email; }
    void setEmail(const std::string& email) { this->email = email; }
    
    std::string getAddress() const { return address; }
    void setAddress(const std::string& address) { this->address = address; }
    
    double getCreditLimit() const { return creditLimit; }
    void setCreditLimit(double limit) { this->creditLimit = limit; }
};

// 行为被放在了其他类中
class CustomerService {
public:
    bool canPurchase(const Customer& customer, double amount) {
        return customer.getCreditLimit() >= amount;
    }
    
    void updateCreditLimit(Customer& customer, double newLimit) {
        customer.setCreditLimit(newLimit);
    }
};
