

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
// Программа для обращения к ArrayList
public class Lesson_4task1 {
    public static<T> List<T> reverseList(List<T> list)
    {
        // Делаем копию и переворачиваем
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }
 
    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
 
        List<Integer> reverse = reverseList(list);
        System.out.println(reverse);
    }
}
/*
Task 2
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> leftSymbols = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                leftSymbols.push(c);
            }

            else if (c == ')' && !leftSymbols.isEmpty() && leftSymbols.peek() == '(') {
                leftSymbols.pop();
            } else if (c == '}' && !leftSymbols.isEmpty() && leftSymbols.peek() == '{') {
                leftSymbols.pop();
            } else if (c == ']' && !leftSymbols.isEmpty() && leftSymbols.peek() == '[') {
                leftSymbols.pop();
            }

            else {
                return false;
            }
        }
        return leftSymbols.isEmpty();
    }
}

*/

