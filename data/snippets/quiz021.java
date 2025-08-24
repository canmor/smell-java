class Printer {
    public void print(String document) {
        System.out.println("Printing document: " + document);
    }
    
    public void scan(String fileName) {
        System.out.println("Scanning to file: " + fileName);
    }
    
    public boolean isOnline() {
        return true; // Assume printer is always online
    }
    
    public int getTonerLevel() {
        return 75; // Assume 75% toner remaining
    }
    
    public void calibrate() {
        System.out.println("Calibrating printer...");
    }
    
    public void printStatus() {
        System.out.println("Printer Status: Online, Toner: " + getTonerLevel() + "%");
    }
}

class PrinterFacade {
    private Printer printer;
    
    public PrinterFacade() {
        this.printer = new Printer();
    }
    
    public void printDocument(String document) {
        printer.print(document);
    }
    
    public void scanDocument(String fileName) {
        printer.scan(fileName);
    }
    
    public boolean isPrinterOnline() {
        return printer.isOnline();
    }
    
    public int getInkLevel() {
        return printer.getTonerLevel();
    }
    
    public void calibratePrinter() {
        printer.calibrate();
    }
    
    public void displayPrinterStatus() {
        printer.printStatus();
    }
}

class ClientCode {
    public void demonstrateMiddleMan() {
        PrinterFacade printerFacade = new PrinterFacade();
        
        printerFacade.printDocument("MyDocument.pdf");
        printerFacade.scanDocument("ScannedImage.jpg");
        
        if (printerFacade.isPrinterOnline()) {
            System.out.println("Printer is ready to use");
        }
        
        System.out.println("Current toner level: " + printerFacade.getInkLevel() + "%");
        printerFacade.calibratePrinter();
        printerFacade.displayPrinterStatus();
    }
}
