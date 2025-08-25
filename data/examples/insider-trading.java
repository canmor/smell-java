import java.util.*;

// example: classes sharing data through back channels
class EmailService {
    private Map<String, String> emailTemplates = new HashMap<>();
    
    public String getTemplate(String type) {
        return emailTemplates.get(type);
    }
    
    public void setTemplate(String type, String template) {
        emailTemplates.put(type, template);
    }
    
    // Exposing internal map - dangerous
    public Map<String, String> getAllTemplates() {
        return emailTemplates; // Direct access to internal data
    }
}

class NotificationService {
    private EmailService emailService;
    
    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }
    
    public void customizeNotifications() {
        // Directly manipulating EmailService's internal data
        Map<String, String> templates = emailService.getAllTemplates();
        templates.put("welcome", "Custom welcome message"); // Back-channel modification
        templates.remove("spam"); // Direct manipulation of another class's data
    }
}
