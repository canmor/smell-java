import java.util.*;

class Employee {
    private String name;
    private String department;
    private double salary;
    private int experience;
    
    public Employee(String name, String department, double salary, int experience) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
    }
    
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }
}

class EmployeeAnalyzer {
    
    public List<String> getHighPaidEmployeeNames(List<Employee> employees) {
        List<String> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getSalary() > 80000 && emp.getExperience() > 5) {
                result.add(emp.getName().toUpperCase());
            }
        }
        return result;
    }
    
    public double calculateAverageSalary(List<Employee> employees, String department) {
        double totalSalary = 0.0;
        int count = 0;
        for (Employee emp : employees) {
            if (emp.getDepartment().equals(department)) {
                totalSalary += emp.getSalary();
                count++;
            }
        }
        return count > 0 ? totalSalary / count : 0.0;
    }
    
    public Map<String, Integer> getDepartmentCounts(List<Employee> employees) {
        Map<String, Integer> counts = new HashMap<>();
        for (Employee emp : employees) {
            String dept = emp.getDepartment();
            if (counts.containsKey(dept)) {
                counts.put(dept, counts.get(dept) + 1);
            } else {
                counts.put(dept, 1);
            }
        }
        return counts;
    }
}
