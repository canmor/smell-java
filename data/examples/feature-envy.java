class Customer {
    private String name;
    private Address address;
    
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public void setName(String name) { this.name = name; }
    public void setAddress(Address address) { this.address = address; }
}

class Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;
    
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getZipCode() { return zipCode; }
    public String getCountry() { return country; }
    
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
    public void setCountry(String country) { this.country = country; }
}

class Invoice {
    private Customer customer;
    private double amount;
    
    // This method is more interested in Address class data
    public String getCustomerAddressInfo() {
        Address addr = customer.getAddress();
        return addr.getStreet() + ", " + 
               addr.getCity() + " " + 
               addr.getZipCode() + ", " +
               addr.getCountry();
    }
    
    // This method also primarily uses Customer data
    public String getCustomerSummary() {
        Address addr = customer.getAddress();
        return "Customer: " + customer.getName() + 
               " from " + addr.getCity() + ", " + addr.getCountry();
    }
    
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
