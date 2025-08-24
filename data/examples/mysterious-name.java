import java.util.*;

class DataProcessor {
    // Mysterious variable names
    private int x = 100;
    private String s = "default";
    private List<Object> lst = new ArrayList<>();
    
    // Mysterious method names
    public void proc(String inp) {
        // What does 'proc' do? What is 'inp'?
        String tmp = inp.toLowerCase();
        lst.add(tmp);
    }
    
    public int calc(int a, int b) {
        // What kind of calculation?
        return a * b + x;
    }
    
    public boolean chk(Object obj) {
        // Check what?
        return obj != null && obj.toString().length() > 5;
    }
    
    // Mysterious class with unclear responsibility
    static class Mgr {
        private Map<String, Object> data = new HashMap<>();
        
        public void handle(String k, Object v) {
            // Handle what? What operation?
            data.put(k, v);
        }
        
        public Object get(String k) {
            return data.get(k);
        }
        
        public void doStuff() {
            // What stuff?
            data.clear();
        }
    }
    
    // Method with misleading name
    public void calculateTotal() {
        // This method doesn't calculate anything!
        System.out.println("Processing completed");
        lst.clear();
    }
    
    // Abbreviated names that lose meaning
    public void updateUsrPrf(String usrId, Map<String, String> prfData) {
        // usr = user? prf = profile? 
        for (String k : prfData.keySet()) {
            // More mysterious single letters
            String v = prfData.get(k);
            System.out.println(k + ": " + v);
        }
    }
    
    // Generic unhelpful names
    public void processInfo(List<String> items) {
        // What kind of info? What processing?
        for (String item : items) {
            String result = item.trim();
            if (result.length() > 0) {
                lst.add(result);
            }
        }
    }
}
