class Vehicle {
public:
    virtual void startEngine() {
        std::cout << "Engine started." << std::endl;
    }
    
    virtual void stopEngine() {
        std::cout << "Engine stopped." << std::endl;
    }
    
    virtual void accelerate() {
        std::cout << "Accelerating..." << std::endl;
    }
    
    virtual void brake() {
        std::cout << "Braking..." << std::endl;
    }
    
    virtual void refuel() {
        std::cout << "Refueling with gasoline." << std::endl;
    }
    
    virtual void changeGear() {
        std::cout << "Changing gear." << std::endl;
    }
};

class ElectricBicycle : public Vehicle {
public:
    // 电动自行车没有引擎，覆盖并拒绝父类方法
    void startEngine() override {
        throw std::logic_error("Electric bicycles don't have engines!");
    }
    
    void stopEngine() override {
        throw std::logic_error("Electric bicycles don't have engines!");
    }
    
    // 电动自行车不使用汽油
    void refuel() override {
        throw std::logic_error("Electric bicycles don't use gasoline!");
    }
    
    // 大多数电动自行车没有变速箱
    void changeGear() override {
        throw std::logic_error("This electric bicycle doesn't have gears!");
    }
    
    // 添加电动自行车特有的方法
    void chargeBattery() {
        std::cout << "Charging battery." << std::endl;
    }
    
    // 正常使用的方法
    void accelerate() override {
        std::cout << "Electric bicycle accelerating." << std::endl;
    }
    
    void brake() override {
        std::cout << "Electric bicycle braking." << std::endl;
    }
};
