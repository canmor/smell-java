class Employee {
private:
    std::string name;
    double salary;
    std::string department;
    std::string address;
    std::string email;
    
public:
    // 因为薪资政策变化需要修改
    double calculatePay() {
        if (department == "Engineering") {
            return salary * 1.2;
        } else if (department == "Sales") {
            return salary * 1.1;
        } else if (department == "Management") {
            return salary * 1.5;
        }
        return salary;
    }
    
    // 因为税法变化需要修改
    double calculateTax() {
        double pay = calculatePay();
        if (pay > 100000) {
            return pay * 0.35;
        } else if (pay > 50000) {
            return pay * 0.25;
        }
        return pay * 0.15;
    }
    
    // 因为报告格式变化需要修改
    std::string generateReport() {
        return "Employee: " + name + 
               "\nDepartment: " + department +
               "\nPay: " + std::to_string(calculatePay()) +
               "\nTax: " + std::to_string(calculateTax());
    }
    
    // 因为数据库结构变化需要修改
    void saveToDatabase() {
        // 数据库保存逻辑
        std::cout << "Saving to database..." << std::endl;
    }
    
    // 因为邮件系统变化需要修改
    void sendPayslip() {
        std::string email = "employee@example.com";
        std::cout << "Sending payslip to: " << email << std::endl;
    }
};
