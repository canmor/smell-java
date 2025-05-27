class Address {
private:
    std::string street;
    std::string city;
    std::string postalCode;
    std::string country;
    
public:
    Address(std::string str, std::string c, std::string pc, std::string cntry) 
        : street(str), city(c), postalCode(pc), country(cntry) {}
        
    std::string getStreet() const { return street; }
    std::string getCity() const { return city; }
    std::string getPostalCode() const { return postalCode; }
    std::string getCountry() const { return country; }
};

class Supplier {
private:
    std::string name;
    Address address;
    ContactInfo contactInfo;
    
public:
    Supplier(std::string n, Address a, ContactInfo ci) 
        : name(n), address(a), contactInfo(ci) {}
        
    std::string getName() const { return name; }
    Address getAddress() const { return address; }
    ContactInfo getContactInfo() const { return contactInfo; }
};

class ContactInfo {
private:
    std::string email;
    PhoneNumber phoneNumber;
    std::string website;
    
public:
    ContactInfo(std::string e, PhoneNumber pn, std::string web) 
        : email(e), phoneNumber(pn), website(web) {}
        
    std::string getEmail() const { return email; }
    PhoneNumber getPhoneNumber() const { return phoneNumber; }
    std::string getWebsite() const { return website; }
};

class PhoneNumber {
private:
    std::string countryCode;
    std::string areaCode;
    std::string number;
    
public:
    PhoneNumber(std::string cc, std::string ac, std::string num) 
        : countryCode(cc), areaCode(ac), number(num) {}
        
    std::string getCountryCode() const { return countryCode; }
    std::string getAreaCode() const { return areaCode; }
    std::string getNumber() const { return number; }
    
    std::string getFormattedNumber() const {
        return "+" + countryCode + " " + areaCode + " " + number;
    }
};

class Product {
private:
    std::string name;
    double price;
    Supplier supplier;
    
public:
    Product(std::string n, double p, Supplier s) 
        : name(n), price(p), supplier(s) {}
        
    std::string getName() const { return name; }
    double getPrice() const { return price; }
    Supplier getSupplier() const { return supplier; }
};

class Inventory {
private:
    std::vector<Product> products;
    
public:
    void addProduct(const Product& product) {
        products.push_back(product);
    }
    
    Product getProduct(int index) const {
        return products[index];
    }
    
    int getProductCount() const {
        return products.size();
    }
};

// 客户端代码使用长消息链
void clientCode(const Inventory& inventory) {
    // 获取产品0的供应商的联系信息的电话号码的格式化字符串
    std::string phoneNumber = inventory.getProduct(0).getSupplier().getContactInfo().getPhoneNumber().getFormattedNumber();
    std::cout << "Supplier phone: " << phoneNumber << std::endl;
    
    // 获取产品0的供应商的地址的城市
    std::string city = inventory.getProduct(0).getSupplier().getAddress().getCity();
    std::cout << "Supplier city: " << city << std::endl;
    
    // 获取产品0的供应商的国家
    std::string country = inventory.getProduct(0).getSupplier().getAddress().getCountry();
    std::cout << "Supplier country: " << country << std::endl;
}
