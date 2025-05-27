class Report {
private:
    std::string title;
    std::string content;
    
public:
    Report(const std::string& title, const std::string& content) 
        : title(title), content(content) {}
        
    std::string getTitle() const { return title; }
    std::string getContent() const { return content; }
};

class ReportData {
private:
    std::vector<double> values;
    std::vector<std::string> labels;
    std::string dataSource;
    
public:
    void addValue(double value) { values.push_back(value); }
    void addLabel(const std::string& label) { labels.push_back(label); }
    void setDataSource(const std::string& source) { dataSource = source; }
    
    std::vector<double> getValues() const { return values; }
    std::vector<std::string> getLabels() const { return labels; }
    std::string getDataSource() const { return dataSource; }
    int getDataCount() const { return values.size(); }
};

class ReportFormatter {
public:
    // 这个方法对ReportData类的数据特别感兴趣
    std::string formatChartData(const ReportData& data) {
        std::stringstream result;
        
        // 访问大量ReportData的数据和方法
        result << "Chart Data (from " << data.getDataSource() << "):\n";
        result << "Total data points: " << data.getDataCount() << "\n";
        
        auto values = data.getValues();
        auto labels = data.getLabels();
        
        for (size_t i = 0; i < values.size() && i < labels.size(); ++i) {
            result << labels[i] << ": " << values[i] << "\n";
        }
        
        // 计算一些统计数据
        double sum = 0;
        for (double value : values) {
            sum += value;
        }
        double average = values.empty() ? 0 : sum / values.size();
        
        result << "Average: " << average << "\n";
        
        return result.str();
    }
    
    // 这个方法也过度使用ReportData的数据
    std::string generateSummary(const ReportData& data) {
        std::stringstream result;
        result << "Summary from " << data.getDataSource() << ":\n";
        
        auto values = data.getValues();
        
        if (values.empty()) {
            result << "No data available.";
            return result.str();
        }
        
        // 找出最大值和最小值
        double max = values[0];
        double min = values[0];
        
        for (double value : values) {
            if (value > max) max = value;
            if (value < min) min = value;
        }
        
        result << "Range: " << min << " to " << max << "\n";
        result << "Number of data points: " << data.getDataCount() << "\n";
        
        return result.str();
    }
    
    std::string formatReport(const Report& report) {
        return "Report: " + report.getTitle() + "\n\n" + report.getContent();
    }
};
