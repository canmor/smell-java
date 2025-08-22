import java.util.List;
import java.util.ArrayList;

class Company {
    private List<Department> departments;
    private String name;
    
    public Company() {
        this.departments = new ArrayList<>();
    }
    
    public Department getDepartment(int index) { 
        return departments.get(index); 
    }
    
    public String getName() { return name; }
    public int getDepartmentCount() { return departments.size(); }
    
    public void addDepartment(Department department) {
        departments.add(department);
    }
}

class Department {
    private List<Employee> employees;
    private Manager manager;
    private String name;
    
    public Department() {
        this.employees = new ArrayList<>();
    }
    
    public Employee getEmployee(int index) { 
        return employees.get(index); 
    }
    
    public Manager getManager() { return manager; }
    public String getName() { return name; }
    
    public void setManager(Manager manager) { this.manager = manager; }
    public void addEmployee(Employee employee) { employees.add(employee); }
}

class Manager {
    private String name;
    private Office office;
    private Employee assistant;
    
    public String getName() { return name; }
    public Office getOffice() { return office; }
    public Employee getAssistant() { return assistant; }
    
    public void setName(String name) { this.name = name; }
    public void setOffice(Office office) { this.office = office; }
    public void setAssistant(Employee assistant) { this.assistant = assistant; }
}

class Office {
    private String location;
    private String building;
    private int floor;
    
    public String getLocation() { return location; }
    public String getBuilding() { return building; }
    public int getFloor() { return floor; }
    
    public void setLocation(String location) { this.location = location; }
    public void setBuilding(String building) { this.building = building; }
    public void setFloor(int floor) { this.floor = floor; }
}

class Employee {
    private String name;
    private String position;
    
    public String getName() { return name; }
    public String getPosition() { return position; }
    
    public void setName(String name) { this.name = name; }
    public void setPosition(String position) { this.position = position; }
}

// Client code that requires long call chains
class CompanyService {
    
    // Long message chain example 1
    public void printManagerOffice(Company company) {
        String location = company.getDepartment(0).getManager().getOffice().getLocation();
        System.out.println("Manager office: " + location);
    }
    
    // Long message chain example 2
    public void printAssistantName(Company company) {
        String assistantName = company.getDepartment(0).getManager().getAssistant().getName();
        System.out.println("Assistant: " + assistantName);
    }
    
    // Even longer message chain example
    public void printManagerOfficeFloor(Company company) {
        int floor = company.getDepartment(0).getManager().getOffice().getFloor();
        System.out.println("Manager office floor: " + floor);
    }
    
    // Multiple chained calls in one method
    public void printDepartmentSummary(Company company) {
        Department dept = company.getDepartment(0);
        String managerName = dept.getManager().getName();
        String officeLocation = dept.getManager().getOffice().getLocation();
        String assistantName = dept.getManager().getAssistant().getName();
        String assistantPosition = dept.getManager().getAssistant().getPosition();
        
        System.out.println("Department Manager: " + managerName);
        System.out.println("Office: " + officeLocation);
        System.out.println("Assistant: " + assistantName + " (" + assistantPosition + ")");
    }
    
    // Another example showing violation of Law of Demeter
    public boolean isManagerOfficeOnTopFloor(Company company) {
        return company.getDepartment(0).getManager().getOffice().getFloor() > 10;
    }
    
    // Complex chain with conditional logic
    public String getManagerContactInfo(Company company) {
        Manager manager = company.getDepartment(0).getManager();
        if (manager.getAssistant() != null) {
            return "Contact " + manager.getAssistant().getName() + 
                   " at " + manager.getOffice().getLocation();
        } else {
            return "Contact " + manager.getName() + 
                   " directly at " + manager.getOffice().getLocation();
        }
    }
}
