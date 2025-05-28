package data_structure;

class BracketStack {
    private char[] arr;
    private int top;

    public BracketStack(int size) {
        arr = new char[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char c) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = c;
        }
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return '\0';
        } else {
            return arr[top--];
        }
    }
}

public class Expressionmatch {
    public static boolean checkExpression(String exp) {
        int i;
        char temp;
        BracketStack st = new BracketStack(20); 
        for (i = 0; i < exp.length(); i++) {
            char currentChar = exp.charAt(i);

            if (currentChar == '[' || currentChar == '{' || currentChar == '(') {
                st.push(currentChar);
            }

            if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
                if (st.isEmpty()) {
                    System.out.println("Stack is empty, unmatched closing bracket.");
                    return false;
                }
                temp = st.pop();

                if (!match(temp, currentChar)) {
                    return false;
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        } else {
            System.out.println("There are unmatched opening brackets.");
            return false;
        }
    }

    public static boolean match(char opening, char closing) {
        return (opening == '(' && closing == ')') || 
               (opening == '{' && closing == '}') || 
               (opening == '[' && closing == ']');
    }

    public static void main(String[] args) {
        String str = "{8 + 4 * (3 * 2)} + (7 * 9) + 3}"; 

        if (checkExpression(str)) {
            System.out.println("Valid Expression");
        } else {
            System.out.println("Invalid Expression");
        }
    }
}
