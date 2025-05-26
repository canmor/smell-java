---
slug: "message-chains"
nameCn: "过长的消息链"
nameEn: "Message Chains"
category: "Couplers"
description: "客户端需要通过一长串的方法调用来获取所需的对象。"
exampleFile: "message-chains.cpp"
---

# 简介

当客户端需要通过一系列的方法调用来获取最终需要的对象时，就出现了消息链。这增加了客户端与多个类的耦合，违反了迪米特法则。

## 识别要点

- 长串的方法调用链
- 客户端需要了解对象的内部结构
- 修改中间对象会影响客户端代码
- 违反了"只与直接朋友交谈"的原则

## 重构建议

1. **隐藏委托关系**：在中间类中提供便捷方法
2. **提取方法**：将长链调用封装为方法
3. **移动方法**：将方法移到更合适的类中
4. **引入局部扩展**：为现有类添加便捷方法

## 说明

客户端需要通过很长的调用链才能获取办公室位置，应该在Company类中提供直接的方法，如getManagerOfficeLocation()。
\`\`\`

```cpp file="data/examples/message-chains.cpp"
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
    std::string getBuilding() const { return building; }
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
    std::string location = company.getDepartment(0)
                                 .getManager()
                                 .getOffice()
                                 .getLocation();
    std::cout << "Manager office: " << location << std::endl;
}

void printAssistantName(Company& company) {
    std::string assistantName = company.getDepartment(0)
                                      .getManager()
                                      .getAssistant()
                                      ->getName();
    std::cout << "Assistant: " << assistantName << std::endl;
}
