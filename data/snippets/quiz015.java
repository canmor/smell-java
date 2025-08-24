import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class FileUtil {
    public boolean fileExists(String filename) {
        File file = new File(filename);
        return file.exists();
    }
}

class DateFormatter {
    public String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }
}

class IntegerWrapper {
    private int value;
    
    public IntegerWrapper(int v) {
        this.value = v;
    }
    
    public int getValue() {
        return value;
    }
    
    public void setValue(int v) {
        this.value = v;
    }
    
    public boolean isPositive() {
        return value > 0;
    }
    
    public boolean isNegative() {
        return value < 0;
    }
}

class StringChecker {
    public boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

class EmailValidator {
    public boolean isValid(String email) {
        return email != null && email.contains("@");
    }
}

class SimpleCalculator {
    public double add(double a, double b) {
        return a + b;
    }
}

class Counter {
    private int count = 0;
    
    public void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

class ClientCode {
    public void demonstrateUsage() {
        FileUtil fileUtil = new FileUtil();
        if (fileUtil.fileExists("data.txt")) {
            System.out.println("File exists");
        }
        
        DateFormatter formatter = new DateFormatter();
        String dateStr = formatter.formatDate(LocalDate.now());
        System.out.println("Today: " + dateStr);
        
        IntegerWrapper number = new IntegerWrapper(42);
        if (number.isPositive()) {
            System.out.println("Value is positive: " + number.getValue());
        }
        
        StringChecker checker = new StringChecker();
        if (checker.isEmpty("")) {
            System.out.println("String is empty");
        }
        
        EmailValidator validator = new EmailValidator();
        if (validator.isValid("user@example.com")) {
            System.out.println("Email is valid");
        }
        
        SimpleCalculator calc = new SimpleCalculator();
        double result = calc.add(5.0, 3.0);
        System.out.println("Result: " + result);
        
        Counter counter = new Counter();
        counter.increment();
        System.out.println("Count: " + counter.getCount());
    }
}
