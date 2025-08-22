import java.util.*;
import java.util.function.*;

// Overly designed abstraction layers
abstract class AbstractDataProcessor<T> {
    public abstract void process(T data);
    public void preProcess(T data) {}
    public void postProcess(T data) {}
    public boolean shouldProcess(T data) { return true; }
    public void onError(Exception e) {}
    public void onSuccess(T data) {}
}

class ConfigurableDataProcessor<T> extends AbstractDataProcessor<T> {
    private Map<String, Consumer<T>> processors;
    private List<Predicate<T>> filters;
    private List<Consumer<T>> preprocessors;
    private List<Consumer<T>> postprocessors;
    
    public ConfigurableDataProcessor() {
        this.processors = new HashMap<>();
        this.filters = new ArrayList<>();
        this.preprocessors = new ArrayList<>();
        this.postprocessors = new ArrayList<>();
    }
    
    public void addProcessor(String name, Consumer<T> processor) {
        processors.put(name, processor);
    }
    
    public void addFilter(Predicate<T> filter) {
        filters.add(filter);
    }
    
    public void addPreprocessor(Consumer<T> preprocessor) {
        preprocessors.add(preprocessor);
    }
    
    @Override
    public void process(T data) {
        // Complex processing logic, but actually only used in one way
        for (Consumer<T> preprocessor : preprocessors) {
            preprocessor.accept(data);
        }
        
        for (Predicate<T> filter : filters) {
            if (!filter.test(data)) return;
        }
        
        for (Consumer<T> processor : processors.values()) {
            processor.accept(data);
        }
    }
}

// What we actually need - a simple implementation
class SimpleStringProcessor {
    public void process(String data) {
        System.out.println("Processing: " + data);
    }
}
