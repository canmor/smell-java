class FileHelper {
    public boolean exists(String filename) {
        return filename != null && !filename.isEmpty();
    }
}

class StringProcessor {
    public String process(String input) {
        return input.trim();
    }
}
