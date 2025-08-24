import java.util.List;
import java.util.ArrayList;

class Address {
    private String street;
    private String city;
    private String postalCode;
    private String country;
    
    public Address(String street, String city, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }
    
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }
    public String getCountry() { return country; }
}

class PhoneNumber {
    private String countryCode;
    private String areaCode;
    private String number;
    
    public PhoneNumber(String countryCode, String areaCode, String number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }
    
    public String getCountryCode() { return countryCode; }
    public String getAreaCode() { return areaCode; }
    public String getNumber() { return number; }
    
    public String getFormattedNumber() {
        return "+" + countryCode + " " + areaCode + " " + number;
    }
}

class ContactInfo {
    private String email;
    private PhoneNumber phoneNumber;
    private String website;
    
    public ContactInfo(String email, PhoneNumber phoneNumber, String website) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }
    
    public String getEmail() { return email; }
    public PhoneNumber getPhoneNumber() { return phoneNumber; }
    public String getWebsite() { return website; }
}

class Supplier {
    private String name;
    private Address address;
    private ContactInfo contactInfo;
    
    public Supplier(String name, Address address, ContactInfo contactInfo) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }
    
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public ContactInfo getContactInfo() { return contactInfo; }
}

class Product {
    private String name;
    private double price;
    private Supplier supplier;
    
    public Product(String name, double price, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public Supplier getSupplier() { return supplier; }
}

class Inventory {
    private List<Product> products;
    
    public Inventory() {
        this.products = new ArrayList<>();
    }
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public Product getProduct(int index) {
        return products.get(index);
    }
    
    public int getProductCount() {
        return products.size();
    }
}

class ClientCode {
    public void processInventory(Inventory inventory) {
        String phoneNumber = inventory.getProduct(0).getSupplier().getContactInfo().getPhoneNumber().getFormattedNumber();
        System.out.println("Supplier phone: " + phoneNumber);
        
        String city = inventory.getProduct(0).getSupplier().getAddress().getCity();
        System.out.println("Supplier city: " + city);
        
        String country = inventory.getProduct(0).getSupplier().getAddress().getCountry();
        System.out.println("Supplier country: " + country);
        
        String email = inventory.getProduct(0).getSupplier().getContactInfo().getEmail();
        System.out.println("Supplier email: " + email);
    }
}
