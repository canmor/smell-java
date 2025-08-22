class User {
    private String firstName;
    private String lastName;
    private String email;           // Should be Email value object
    private String phone;           // Should be PhoneNumber value object
    private String street;          // Should be Address value object
    private String city;
    private String zipCode;         // Should be ZipCode value object
    private String country;
    private String currency;        // Should be Currency value object
    private double salary;          // Should be Money value object
    private String employeeId;      // Should be EmployeeId value object
    private String socialSecurityNumber; // Should be SSN value object
    
    // Validation logic scattered and duplicated
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public boolean isValidPhone(String phone) {
        return phone != null && phone.length() >= 10 && phone.matches("\\d+");
    }
    
    public boolean isValidZipCode(String zipCode) {
        return zipCode != null && zipCode.matches("\\d{5}(-\\d{4})?");
    }
    
    public boolean isValidEmployeeId(String employeeId) {
        return employeeId != null && employeeId.matches("EMP\\d{6}");
    }
    
    public boolean isValidSSN(String ssn) {
        return ssn != null && ssn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
    
    // Methods that show lack of type safety
    public void updateContact(String email, String phone) {
        // Easy to accidentally swap these parameters!
        if (isValidEmail(email)) {
            this.email = email;
        }
        if (isValidPhone(phone)) {
            this.phone = phone;
        }
    }
    
    public void updateAddress(String street, String city, String zipCode, String country) {
        // Too many string parameters - easy to mix up
        this.street = street;
        this.city = city;
        if (isValidZipCode(zipCode)) {
            this.zipCode = zipCode;
        }
        this.country = country;
    }
    
    public void updateEmployeeInfo(String employeeId, String ssn, double salary, String currency) {
        // More primitive obsession - mixing different concepts
        if (isValidEmployeeId(employeeId)) {
            this.employeeId = employeeId;
        }
        if (isValidSSN(ssn)) {
            this.socialSecurityNumber = ssn;
        }
        this.salary = salary;
        this.currency = currency;
    }
    
    public String getFullAddress() {
        return street + ", " + city + " " + zipCode + ", " + country;
    }
    
    public String getFormattedSalary() {
        return currency + " " + String.format("%.2f", salary);
    }
    
    // Business logic mixed with validation
    public boolean canReceivePromotion() {
        return isValidEmployeeId(employeeId) && 
               salary > 50000 && 
               socialSecurityNumber != null;
    }
    
    // Demonstration of problems with primitive obsession
    public static void demonstrateProblems() {
        User user = new User();
        
        // Easy to mix up parameters of same type
        user.updateContact("123-456-7890", "john@example.com"); // Oops! Swapped email and phone
        
        // Long parameter lists with similar types
        user.updateAddress("USA", "New York", "123 Main St", "10001"); // Wrong order!
        
        // Validation logic scattered and repeated
        String email1 = "test@example.com";
        String email2 = "another@test.com";
        // Need to validate emails everywhere they're used
        if (user.isValidEmail(email1) && user.isValidEmail(email2)) {
            // Do something with emails
        }
    }
    
    // Getters and setters with no validation
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; } // No validation!
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; } // No validation!
    
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; } // No validation!
    
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}

// Example of business logic that suffers from primitive obsession
class PayrollService {
    
    // Methods with too many primitive parameters
    public double calculateTax(double salary, String currency, String country, String state) {
        // Complex logic using primitives instead of value objects
        double taxRate = 0.0;
        
        if ("USA".equals(country)) {
            if ("CA".equals(state)) {
                taxRate = 0.13;
            } else if ("NY".equals(state)) {
                taxRate = 0.12;
            }
        } else if ("Canada".equals(country)) {
            taxRate = 0.15;
        }
        
        // Currency conversion logic mixed in
        if ("EUR".equals(currency)) {
            salary = salary * 1.1; // Simplified conversion
        }
        
        return salary * taxRate;
    }
    
    // Another method showing primitive obsession
    public void sendPayslip(String email, String employeeId, double salary, String currency) {
        // Validation scattered here too
        if (email.contains("@") && employeeId.matches("EMP\\d{6}")) {
            System.out.println("Sending payslip to " + email);
            System.out.println("Employee: " + employeeId);
            System.out.println("Salary: " + currency + " " + salary);
        }
    }
}
