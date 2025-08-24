import java.util.List;
import java.util.ArrayList;

class Report {
    private String title;
    private String content;
    
    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }
    
    public String getTitle() { return title; }
    public String getContent() { return content; }
}

class ReportData {
    private List<Double> values;
    private List<String> labels;
    private String dataSource;
    
    public ReportData() {
        this.values = new ArrayList<>();
        this.labels = new ArrayList<>();
    }
    
    public void addValue(double value) { values.add(value); }
    public void addLabel(String label) { labels.add(label); }
    public void setDataSource(String source) { dataSource = source; }
    
    public List<Double> getValues() { return values; }
    public List<String> getLabels() { return labels; }
    public String getDataSource() { return dataSource; }
    public int getDataCount() { return values.size(); }
}

class ReportFormatter {
    
    public String formatChartData(ReportData data) {
        StringBuilder result = new StringBuilder();
        
        result.append("Chart Data (from ").append(data.getDataSource()).append("):\n");
        result.append("Total data points: ").append(data.getDataCount()).append("\n");
        
        List<Double> values = data.getValues();
        List<String> labels = data.getLabels();
        
        for (int i = 0; i < values.size() && i < labels.size(); i++) {
            result.append(labels.get(i)).append(": ").append(values.get(i)).append("\n");
        }
        
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        double average = values.isEmpty() ? 0 : sum / values.size();
        result.append("Average: ").append(average).append("\n");
        
        return result.toString();
    }
    
    public String generateSummary(ReportData data) {
        StringBuilder result = new StringBuilder();
        result.append("Summary from ").append(data.getDataSource()).append(":\n");
        
        List<Double> values = data.getValues();
        
        if (values.isEmpty()) {
            result.append("No data available.");
            return result.toString();
        }
        
        double max = values.get(0);
        double min = values.get(0);
        
        for (double value : values) {
            if (value > max) max = value;
            if (value < min) min = value;
        }
        
        result.append("Range: ").append(min).append(" to ").append(max).append("\n");
        result.append("Number of data points: ").append(data.getDataCount()).append("\n");
        
        return result.toString();
    }
    
    public String formatReport(Report report) {
        return "Report: " + report.getTitle() + "\n\n" + report.getContent();
    }
}
