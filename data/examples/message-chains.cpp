class Company {
private:
    std::vector<Department> departments;
    std::string name;
    
public:
    Department& getDepartment(int index) { return departments[index]; }
    std::string getName() const { return name; }
    size_t getDepartmentCount() const { return departments.size(); }
};

class Department {
private:
    std::vector<Employee> employees;
    Manager manager;
    std::string name;
    
public:
    Employee& getEmployee(int index) { return employees[index]; }
    Manager& getManager() { return manager; }
    std::string getName() const { return name; }
};

class Manager {
private:
    std::string name;
    Office office;
    Employee* assistant;
    
public:
    std::string getName() const { return name; }
    Office& getOffice() { return office; }
    Employee* getAssistant() { return assistant; }
};

class Office {
private:
    std::string location;
    std::string building;
    int floor;
    
public:
    std::string getLocation() const { return location; }
    int getFloor() const { return floor; }
};

class Employee {
private:
    std::string name;
    std::string position;
    
public:
    std::string getName() const { return name; }
    std::string getPosition() const { return position; }
};

// 客户端代码需要很长的调用链
void printManagerOffice(Company& company) {
    std::string location = company.getDepartment(0).getManager().getOffice().getLocation();
    std::cout << "Manager office: " << location << std::endl;
}

void printAssistantName(Company& company) {
    std::string assistantName = company.getDepartment(0).getManager().getAssistant()->getName();
    std::cout << "Assistant: " << assistantName << std::endl;
}
