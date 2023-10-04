public static boolean isMatching(char a,char b){
    return (a=='(' && b==')') || (a=='[' && b==']') || (a=='{' && b=='}');
    }
public static String isBalanced(String s) {
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
            st.push(s.charAt(i));
        }
        else if (st.empty()) {
            return "NO";
        }
        else if (!st.empty()) {
            if (isMatching(st.peek(), s.charAt(i))) {
                st.pop();
            }
            else {
                return "NO";
            }
        }
        
    }
    if (st.empty()) {
        return "YES";
    }
    return "NO";
}