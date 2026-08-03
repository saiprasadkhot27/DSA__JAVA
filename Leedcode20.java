import java.util.ArrayDeque;
import java.util.Deque;

public class Leedcode20 {
    
    public static boolean isValid(String s) {
        // Use Deque instead of Stack for better performance
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));     // Output: true
        System.out.println(isValid("()[]{}")); // Output: true
        System.out.println(isValid("(]"));     // Output: false
        System.out.println(isValid("([)]"));   // Output: false
    }
}
