class Bird {
public:
    virtual void fly() {
        std::cout << "Flying..." << std::endl;
    }
    
    virtual void eat() {
        std::cout << "Eating..." << std::endl;
    }
    
    virtual void makeSound() {
        std::cout << "Chirp..." << std::endl;
    }
    
    virtual void layEggs() {
        std::cout << "Laying eggs..." << std::endl;
    }
};

class Penguin : public Bird {
public:
    // 被拒绝的遗赠：企鹅不能飞
    void fly() override {
        throw std::runtime_error("Penguins can't fly!");
    }
    
    void makeSound() override {
        std::cout << "Squawk..." << std::endl;
    }
    
    void swim() {
        std::cout << "Swimming..." << std::endl;
    }
};

class Ostrich : public Bird {
public:
    // 鸵鸟也不能飞
    void fly() override {
        throw std::runtime_error("Ostriches can't fly!");
    }
    
    void run() {
        std::cout << "Running fast..." << std::endl;
    }
};
