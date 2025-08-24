import java.util.List;
import java.util.ArrayList;

class Student {
    String name;
    String id;
    List<Integer> grades;
    
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }
    
    public String getName() { return name; }
    public String getId() { return id; }
    
    public void addGrade(int grade) {
        grades.add(grade);
    }
}

class CourseManager {
    public void enrollStudent(Student student, String courseCode) {
        System.out.println("Enrolling " + student.name + " in course " + courseCode);
        student.id += "-" + courseCode;
    }
    
    public void updateStudentGrades(Student student, int newGrade) {
        student.grades.add(newGrade);
        System.out.println("Added grade " + newGrade + " for " + student.name);
    }
}

class GradeCalculator {
    public double calculateAverage(Student student) {
        if (student.grades.isEmpty()) {
            return 0.0;
        }
        
        int sum = 0;
        for (int grade : student.grades) {
            sum += grade;
        }
        
        return (double) sum / student.grades.size();
    }
    
    public boolean hasPassed(Student student, int passingGrade) {
        for (int grade : student.grades) {
            if (grade < passingGrade) {
                return false;
            }
        }
        return !student.grades.isEmpty();
    }
}

class SchoolReport {
    public void printReport(Student student) {
        System.out.println("Report for " + student.name + " (ID: " + student.id + ")");
        System.out.print("Grades: ");
        
        for (int grade : student.grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
    }
    
    public void modifyStudentRecords(Student student, String newName) {
        student.name = newName;
    }
}
