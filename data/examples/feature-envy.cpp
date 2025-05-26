class Customer {
private:
    std::string name;
    Address address;
    
public:
    std::string getName() const { return name; }
    Address getAddress() const { return address; }
    void setName(const std::string& name) { this->name = name; }
    void setAddress(const Address& address) { this->address = address; }
};

class Address {
private:
    std::string street;
    std::string city;
    std::string zipCode;
    std::string country;
    
public:
    std::string getStreet() const { return street; }
    std::string getCity() const { return city; }
    std::string getZipCode() const { return zipCode; }
    std::string getCountry() const { return country; }
};

class Invoice {
private:
    Customer customer;
    double amount;
    
public:
    // 这个方法对Address类的数据更感兴趣
    std::string getCustomerAddressInfo() {
        Address addr = customer.getAddress();
        return addr.getStreet() + ", " + 
               addr.getCity() + " " + 
               addr.getZipCode() + ", " +
               addr.getCountry();
    }
    
    // 这个方法也主要使用Customer的数据
    std::string getCustomerSummary() {
        Address addr = customer.getAddress();
        return "Customer: " + customer.getName() + 
               " from " + addr.getCity() + ", " + addr.getCountry();
    }
    
    double getAmount() const { return amount; }
};
