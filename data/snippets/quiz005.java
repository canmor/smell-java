public class CustomerService {
    
    public boolean registerCustomer(String name, String email, String phone,
                                  String street, String city, String zipCode, 
                                  String country, String creditCardNumber) {
        
        if (!isValidEmail(email)) {
            return false;
        }
        
        if (!isValidPhone(phone)) {
            return false;
        }
        
        if (!isValidZipCode(zipCode)) {
            return false;
        }
        
        if (!isValidCreditCard(creditCardNumber)) {
            return false;
        }
        
        String fullAddress = formatAddress(street, city, zipCode, country);
        saveCustomer(name, email, phone, fullAddress, creditCardNumber);
        return true;
    }
    
    public boolean processPayment(String creditCardNumber, String expiryDate, 
                                String cvv, String amount, String currency) {
        
        if (!isValidCreditCard(creditCardNumber)) {
            return false;
        }
        
        if (!isValidExpiryDate(expiryDate)) {
            return false;
        }
        
        if (!isValidCvv(cvv)) {
            return false;
        }
        
        if (!isValidAmount(amount)) {
            return false;
        }
        
        if (!isValidCurrency(currency)) {
            return false;
        }
        
        return chargeCard(creditCardNumber, expiryDate, cvv, amount, currency);
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    private boolean isValidPhone(String phone) {
        return phone != null && phone.length() >= 10 && phone.matches("\\d+");
    }
    
    private boolean isValidZipCode(String zipCode) {
        return zipCode != null && zipCode.length() == 5 && zipCode.matches("\\d{5}");
    }
    
    private boolean isValidCreditCard(String creditCardNumber) {
        return creditCardNumber != null && creditCardNumber.length() == 16 && 
               creditCardNumber.matches("\\d{16}");
    }
    
    private boolean isValidExpiryDate(String expiryDate) {
        return expiryDate != null && expiryDate.matches("\\d{2}/\\d{2}");
    }
    
    private boolean isValidCvv(String cvv) {
        return cvv != null && cvv.length() == 3 && cvv.matches("\\d{3}");
    }
    
    private boolean isValidAmount(String amount) {
        try {
            double value = Double.parseDouble(amount);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private boolean isValidCurrency(String currency) {
        return currency != null && 
               (currency.equals("USD") || currency.equals("EUR") || currency.equals("CNY"));
    }
    
    private String formatAddress(String street, String city, String zipCode, String country) {
        return street + ", " + city + " " + zipCode + ", " + country;
    }
    
    private void saveCustomer(String name, String email, String phone, 
                            String address, String creditCardNumber) {
        // Save to database
    }
    
    private boolean chargeCard(String creditCardNumber, String expiryDate, 
                             String cvv, String amount, String currency) {
        // Process payment
        return true;
    }
}
