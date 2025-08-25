import java.util.*;

class Product {
    private String name;
    private double price;
    private String category;
    private boolean inStock;
    
    public Product(String name, double price, String category, boolean inStock) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
    }
    
    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public boolean isInStock() { return inStock; }
}

class ProductService {
    
    // Traditional loop-based approach - outdated style
    public List<String> getExpensiveProductNames(List<Product> products) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getPrice() > 100 && product.isInStock()) {
                result.add(product.getName().toUpperCase());
            }
        }
        return result;
    }
    
    // Another traditional loop with complex logic
    public double calculateTotalValue(List<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            if (product.isInStock()) {
                if (product.getCategory().equals("Electronics")) {
                    total += product.getPrice() * 1.1; // Add 10% markup
                } else if (product.getCategory().equals("Books")) {
                    total += product.getPrice() * 0.9; // 10% discount
                } else {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }
    
    // Nested loops - hard to understand
    public Map<String, Integer> getCategoryProductCount(List<Product> products) {
        Map<String, Integer> result = new HashMap<>();
        List<String> categories = new ArrayList<>();
        
        // First loop to collect unique categories
        for (Product product : products) {
            boolean found = false;
            for (String category : categories) {
                if (category.equals(product.getCategory())) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                categories.add(product.getCategory());
            }
        }
        
        // Second loop to count products in each category
        for (String category : categories) {
            int count = 0;
            for (Product product : products) {
                if (product.getCategory().equals(category) && product.isInStock()) {
                    count++;
                }
            }
            result.put(category, count);
        }
        return result;
    }
    
    // Traditional loop for finding items
    public List<Product> findProductsByPriceRange(List<Product> products, 
                                                  double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && 
                product.getPrice() <= maxPrice && 
                product.isInStock()) {
                result.add(product);
            }
        }
        return result;
    }
    
    // Loop with side effects and accumulation
    public void generateReport(List<Product> products) {
        int totalProducts = 0;
        int inStockProducts = 0;
        double totalValue = 0.0;
        List<String> expensiveItems = new ArrayList<>();
        
        for (Product product : products) {
            totalProducts++;
            
            if (product.isInStock()) {
                inStockProducts++;
                totalValue += product.getPrice();
                
                if (product.getPrice() > 200) {
                    expensiveItems.add(product.getName());
                }
            }
        }
        
        System.out.println("Total products: " + totalProducts);
        System.out.println("In stock: " + inStockProducts);
        System.out.println("Total value: " + totalValue);
        System.out.println("Expensive items: " + expensiveItems);
    }
    
    // Traditional loop for data transformation
    public List<String> createProductSummaries(List<Product> products) {
        List<String> summaries = new ArrayList<>();
        for (Product product : products) {
            if (product.isInStock()) {
                String summary = product.getName() + " (" + product.getCategory() + 
                               ") - $" + product.getPrice();
                summaries.add(summary);
            }
        }
        return summaries;
    }
}
