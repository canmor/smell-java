class Employee {
    private String name;
    private double salary;
    private String department;
    private String address;
    private String email;
    
    // Needs to be modified due to payroll policy changes
    public double calculatePay() {
        if ("Engineering".equals(department)) {
            return salary * 1.2;
        } else if ("Sales".equals(department)) {
            return salary * 1.1;
        } else if ("Management".equals(department)) {
            return salary * 1.5;
        }
        return salary;
    }
    
    // Needs to be modified due to tax law changes
    public double calculateTax() {
        double pay = calculatePay();
        if (pay > 100000) {
            return pay * 0.35;
        } else if (pay > 50000) {
            return pay * 0.25;
        }
        return pay * 0.15;
    }
    
    // Needs to be modified due to report format changes
    public String generateReport() {
        return "Employee: " + name + 
               "\nDepartment: " + department +
               "\nPay: " + String.valueOf(calculatePay()) +
               "\nTax: " + String.valueOf(calculateTax());
    }
    
    // Needs to be modified due to database structure changes
    public void saveToDatabase() {
        // Database save logic
        System.out.println("Saving to database...");
    }
    
    // Needs to be modified due to email system changes
    public void sendPayslip() {
        System.out.println("Sending payslip to: " + this.email);
    }
    
    // Getters and setters - may change due to data format requirements
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
