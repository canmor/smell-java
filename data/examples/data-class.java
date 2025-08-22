class Customer {
    private String name;
    private String email;
    private String address;
    private double creditLimit;
    
    // Only getters and setters, no other behavior
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public double getCreditLimit() { return creditLimit; }
    public void setCreditLimit(double creditLimit) { this.creditLimit = creditLimit; }
}

// Behavior is placed in other classes
class CustomerService {
    public boolean canPurchase(Customer customer, double amount) {
        return customer.getCreditLimit() >= amount;
    }
    
    public void updateCreditLimit(Customer customer, double newLimit) {
        customer.setCreditLimit(newLimit);
    }
}
