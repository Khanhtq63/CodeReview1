import java.util.HashMap;
import java.util.Map;

public class StringProcessor {
    private String inputString;

    // Constructor
    public StringProcessor(String inputString) {
        this.inputString = inputString;
    }

    // Chuyển đổi sang chữ hoa
    public String toUpperCase() {
        return inputString.toUpperCase();
    }

    // Chuyển đổi sang chữ thường
    public String toLowerCase() {
        return inputString.toLowerCase();
    }

    // Đảo ngược trạng thái chữ (từ hoa sang thường và ngược lại)
    public String toggleCase() {
        char[] charArray = inputString.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c)) {
                charArray[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                charArray[i] = Character.toUpperCase(c);
            }
        }
        return new String(charArray);
    }

    // Tìm kiếm chuỗi con
    public boolean contains(String substring) {
        return inputString.contains(substring);
    }

    // Trích xuất chuỗi con
    public String substring(int startIndex, int endIndex) {
        return inputString.substring(startIndex, endIndex);
    }

    // Thay thế chuỗi con trong một chuỗi
    public String replace(String target, String replacement) {
        return inputString.replace(target, replacement);
    }

    // Kiểm tra chuỗi có phải là chuỗi đối xứng hay không
    public boolean isPalindrome() {
        String reversed = new StringBuilder(inputString).reverse().toString();
        return inputString.equals(reversed);
    }

    // Đếm số lượng từ trong chuỗi
    public int countWords() {
        // Sử dụng phương thức split để tách chuỗi thành các từ
        String[] words = inputString.split("\\s+");
        return words.length;
    }

    // Đếm tần suất xuất hiện của mỗi ký tự trong chuỗi
    public Map<Character, Integer> characterFrequency() {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : inputString.toCharArray()) {
            // Nếu ký tự đã tồn tại trong bản đồ, tăng tần suất lên 1
            // Ngược lại, thêm ký tự vào bản đồ với tần suất là 1
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        StringProcessor processor = new StringProcessor("Hello, World!");
        // Test các phương thức
        System.out.println("Original: " + processor.inputString);
        System.out.println("To Upper Case: " + processor.toUpperCase());
        System.out.println("To Lower Case: " + processor.toLowerCase());
        System.out.println("Toggle Case: " + processor.toggleCase());
        System.out.println("Contains 'World': " + processor.contains("World"));
        System.out.println("Substring (7, 12): " + processor.substring(7, 12));
        System.out.println("Replace 'Hello' with 'Hi': " + processor.replace("Hello", "Hi"));
        StringProcessor processor1 = new StringProcessor("level");
        System.out.println("Is Palindrome: " + processor1.isPalindrome());

        StringProcessor wordProcessor = new StringProcessor("Hello, World! This is a test.");
        System.out.println("Word Count: " + wordProcessor.countWords());

        StringProcessor frequencyProcessor = new StringProcessor("abracadabra");
        System.out.println("Character Frequency: " + frequencyProcessor.characterFrequency());
    }
}
