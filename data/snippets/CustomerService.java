public class CustomerService {
    
    public boolean registerCustomer(String name, String email, String phone,
                                  String street, String city, String zipCode, 
                                  String country, String creditCardNumber,
                                  String birthday, String ssn, String companyName,
                                  String website, String faxNumber) {
        
        if (email == null || !email.contains("@") || !email.contains(".")) {
            return false;
        }
        
        if (phone == null || phone.length() < 10 || !phone.matches("\\d+")) {
            return false;
        }
        
        if (zipCode == null || zipCode.length() != 5 || !zipCode.matches("\\d{5}")) {
            return false;
        }
        
        if (creditCardNumber == null || creditCardNumber.length() != 16 || 
            !creditCardNumber.matches("\\d{16}")) {
            return false;
        }
        
        if (ssn == null || ssn.length() != 11 || !ssn.matches("\\d{3}-\\d{2}-\\d{4}")) {
            return false;
        }
        
        if (birthday == null || !birthday.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }
        
        if (website != null && !website.startsWith("http")) {
            return false;
        }
        
        String fullAddress = street + ", " + city + " " + zipCode + ", " + country;
        saveCustomer(name, email, phone, fullAddress, creditCardNumber, birthday, ssn, 
                    companyName, website, faxNumber);
        return true;
    }
    
    public boolean processPayment(String creditCardNumber, String expiryDate, 
                                String cvv, String amount, String currency) {
        
        if (creditCardNumber == null || creditCardNumber.length() != 16 || 
            !creditCardNumber.matches("\\d{16}")) {
            return false;
        }
        
        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            return false;
        }
        
        if (cvv == null || cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            return false;
        }
        
        double amountValue = Double.parseDouble(amount);
        if (amountValue <= 0) {
            return false;
        }
        
        if (!currency.equals("USD") && !currency.equals("EUR") && !currency.equals("CNY")) {
            return false;
        }
        
        return chargeCard(creditCardNumber, expiryDate, cvv, amountValue, currency);
    }
    
    public boolean updateCustomerContact(String customerId, String newEmail, 
                                       String newPhone, String newAddress) {
        
        if (customerId == null || !customerId.matches("\\d{8}")) {
            return false;
        }
        
        if (newEmail != null && (!newEmail.contains("@") || !newEmail.contains("."))) {
            return false;
        }
        
        if (newPhone != null && (newPhone.length() < 10 || !newPhone.matches("\\d+"))) {
            return false;
        }
        
        return updateContact(customerId, newEmail, newPhone, newAddress);
    }
    
    public String formatCustomerInfo(String name, String email, String phone, 
                                   String street, String city, String zipCode,
                                   String birthday, String membershipLevel) {
        
        String formattedPhone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + 
                               "-" + phone.substring(6);
        
        String formattedBirthday = birthday.substring(5, 7) + "/" + 
                                  birthday.substring(8, 10) + "/" + 
                                  birthday.substring(0, 4);
        
        String fullAddress = street + ", " + city + " " + zipCode;
        
        return String.format("Name: %s\nEmail: %s\nPhone: %s\nAddress: %s\nBirthday: %s\nLevel: %s",
                           name, email, formattedPhone, fullAddress, formattedBirthday, membershipLevel);
    }
    
    private void saveCustomer(String name, String email, String phone, String address, 
                            String creditCardNumber, String birthday, String ssn,
                            String companyName, String website, String faxNumber) {
        // 保存到数据库
    }
    
    private boolean chargeCard(String creditCardNumber, String expiryDate, String cvv, 
                             double amount, String currency) {
        // 处理支付
        return true;
    }
    
    private boolean updateContact(String customerId, String email, String phone, String address) {
        // 更新联系信息
        return true;
    }
}
