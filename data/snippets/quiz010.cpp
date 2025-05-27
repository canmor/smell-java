class EmailNotifier {
public:
    void sendNotification(const std::string& recipient, const std::string& subject, 
                        const std::string& message) {
        std::cout << "Sending email to: " << recipient << std::endl;
        std::cout << "Subject: " << subject << std::endl;
        std::cout << "Message: " << message << std::endl;
        std::cout << "Email sent successfully!" << std::endl;
    }
    
    bool checkDelivery(const std::string& messageId) {
        // 检查电子邮件是否已送达
        std::cout << "Checking email delivery status..." << std::endl;
        return true;
    }
};

class SMSAlertSystem {
public:
    // 功能类似但接口不同
    void alertUser(const std::string& phoneNumber, const std::string& alertContent) {
        std::cout << "Sending SMS alert to: " << phoneNumber << std::endl;
        std::cout << "Alert content: " << alertContent << std::endl;
        std::cout << "SMS alert sent successfully!" << std::endl;
    }
    
    bool hasBeenDelivered(const std::string& alertId) {
        // 检查短信是否已送达
        std::cout << "Checking SMS delivery status..." << std::endl;
        return true;
    }
};

class PushNotificationManager {
public:
    // 又一个类似功能但不同接口的类
    void pushAlert(const std::string& deviceToken, const std::string& title, 
                 const std::string& body, bool highPriority) {
        std::cout << "Pushing notification to device: " << deviceToken << std::endl;
        std::cout << "Title: " << title << std::endl;
        std::cout << "Body: " << body << std::endl;
        std::cout << "Priority: " << (highPriority ? "High" : "Normal") << std::endl;
        std::cout << "Push notification sent!" << std::endl;
    }
    
    bool verifyDelivery(const std::string& notificationId) {
        // 检查推送通知是否已送达
        std::cout << "Checking push notification delivery status..." << std::endl;
        return true;
    }
};
