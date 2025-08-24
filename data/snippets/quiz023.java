import java.util.*;

class UserService {
    private double discountRate = 0.1;
    private String defaultStatus = "active";
    private int maxRetries = 3;
    
    public void proc(String inp) {
        String cleanInput = inp.trim().toLowerCase();
        if (cleanInput.length() > 0) {
            System.out.println("Processing: " + cleanInput);
        }
    }
    
    public double calc(double amt) {
        double r = amt * (1 - discountRate);
        return r;
    }
    
    public boolean chk(Object obj) {
        return obj != null && obj.toString().length() > 5;
    }
    
    public void upd(Map<String, String> data) {
        for (String k : data.keySet()) {
            String v = data.get(k);
            System.out.println(k + ": " + v);
        }
    }
    
    static class Mgr {
        public void handle(String s) {
            System.out.println("处理: " + s);
        }
        
        public String get() {
            return "结果";
        }
    }
}
