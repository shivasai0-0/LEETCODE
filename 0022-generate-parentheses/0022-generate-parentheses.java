import java.util.*;

class Solution {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder st = new StringBuilder();
        solve(st, 0, 0, n);
        return list;
    }

    public void solve(StringBuilder st, int open, int close, int n) {

        if (open == n && close == n) {
            list.add(st.toString());
            return;
        }

        if (open > close && open < n) {

            st.append('(');
            solve(st, open + 1, close, n);
            st.deleteCharAt(st.length() - 1);

            st.append(')');
            solve(st, open, close + 1, n);
            st.deleteCharAt(st.length() - 1);
        }
        else if (open == close && open < n) {

            st.append('(');
            solve(st, open + 1, close, n);
            st.deleteCharAt(st.length() - 1);
        }
        else if (open == n) {

            st.append(')');
            solve(st, open, close + 1, n);
            st.deleteCharAt(st.length() - 1);
        }
    }
}