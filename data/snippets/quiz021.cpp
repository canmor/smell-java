class Printer {
public:
    void print(const std::string& document) {
        std::cout << "Printing document: " << document << std::endl;
    }
    
    void scan(const std::string& fileName) {
        std::cout << "Scanning to file: " << fileName << std::endl;
    }
    
    bool isOnline() const {
        return true;  // 假设打印机总是在线
    }
    
    int getTonerLevel() const {
        return 75;  // 假设墨粉剩余75%
    }
    
    void calibrate() {
        std::cout << "Calibrating printer..." << std::endl;
    }
};

// 这个类只是简单地委托给Printer
class PrinterFacade {
private:
    Printer printer;
    
public:
    // 所有方法都只是简单地委托
    void printDocument(const std::string& document) {
        printer.print(document);
    }
    
    void scanDocument(const std::string& fileName) {
        printer.scan(fileName);
    }
    
    bool isPrinterOnline() const {
        return printer.isOnline();
    }
    
    int getInkLevel() const {
        return printer.getTonerLevel();
    }
    
    void calibratePrinter() {
        printer.calibrate();
    }
};

// 另一个中间人例子
class EmailSender {
public:
    void sendEmail(const std::string& to, const std::string& subject, const std::string& body) {
        std::cout << "Sending email to: " << to << std::endl;
        std::cout << "Subject: " << subject << std::endl;
        std::cout << "Body: " << body << std::endl;
    }
    
    void addAttachment(const std::string& filePath) {
        std::cout << "Adding attachment: " << filePath << std::endl;
    }
    
    void setHighPriority() {
        std::cout << "Setting high priority" << std::endl;
    }
    
    void setLowPriority() {
        std::cout << "Setting low priority" << std::endl;
    }
};

// 中间人类
class NotificationService {
private:
    EmailSender emailSender;
    
public:
    // 简单地委托给EmailSender
    void sendEmailNotification(const std::string& to, const std::string& subject, const std::string& body) {
        emailSender.sendEmail(to, subject, body);
    }
    
    void addEmailAttachment(const std::string& filePath) {
        emailSender.addAttachment(filePath);
    }
    
    void setHighPriorityEmail() {
        emailSender.setHighPriority();
    }
    
    void setLowPriorityEmail() {
        emailSender.setLowPriority();
    }
};

// 客户端代码
void clientCode() {
    PrinterFacade printerFacade;
    printerFacade.printDocument("MyDocument.pdf");
    printerFacade.scanDocument("ScannedImage.jpg");
    
    if (printerFacade.isPrinterOnline()) {
        std::cout << "Printer is online" << std::endl;
    }
    
    std::cout << "Toner level: " << printerFacade.getInkLevel() << "%" << std::endl;
    
    // 同样使用另一个中间人
    NotificationService notificationService;
    notificationService.sendEmailNotification("user@example.com", "Test", "This is a test email");
    notificationService.addEmailAttachment("report.pdf");
}
