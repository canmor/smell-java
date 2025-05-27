class Student {
private:
    std::string name;
    std::string id;
    std::vector<int> grades;
    
    // 允许其他类访问私有成员
    friend class CourseManager;
    friend class GradeCalculator;
    friend class SchoolReport;
    
public:
    Student(const std::string& name, const std::string& id) 
        : name(name), id(id) {}
    
    std::string getName() const { return name; }
    std::string getId() const { return id; }
    
    void addGrade(int grade) {
        grades.push_back(grade);
    }
};

class CourseManager {
public:
    void enrollStudent(Student& student, const std::string& courseCode) {
        std::cout << "Enrolling " << student.name << " in course " << courseCode << std::endl;
        // 直接访问并修改Student的私有属性
        student.id += "-" + courseCode;
    }
    
    void recordAttendance(Student& student, bool attended) {
        // 直接访问私有属性
        std::cout << "Recording attendance for " << student.name << " (" << student.id << ")" << std::endl;
    }
    
    void updateStudentGrades(Student& student, int newGrade) {
        // 直接操作私有数据
        student.grades.push_back(newGrade);
        std::cout << "Added grade " << newGrade << " for " << student.name << std::endl;
    }
};

class GradeCalculator {
public:
    double calculateAverage(const Student& student) {
        // 直接访问私有属性
        if (student.grades.empty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (int grade : student.grades) {
            sum += grade;
        }
        
        return static_cast<double>(sum) / student.grades.size();
    }
    
    bool hasPassed(const Student& student, int passingGrade) {
        // 直接访问并使用私有数据
        for (int grade : student.grades) {
            if (grade < passingGrade) {
                return false;
            }
        }
        return !student.grades.empty();
    }
};

class SchoolReport {
public:
    void printReport(const Student& student) {
        // 直接访问私有属性
        std::cout << "Report for " << student.name << " (ID: " << student.id << ")" << std::endl;
        std::cout << "Grades: ";
        
        for (int grade : student.grades) {
            std::cout << grade << " ";
        }
        std::cout << std::endl;
    }
    
    void modifyStudentRecords(Student& student, const std::string& newName) {
        // 直接修改私有数据
        student.name = newName;
    }
};
