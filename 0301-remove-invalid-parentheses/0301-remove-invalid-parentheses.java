class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new LinkedList<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);
        set.add(s);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String str = q.poll();

                int b = 0;
                boolean valid = true;

                for (char ch : str.toCharArray()) {
                    if (ch == '(') {
                        b++;
                    } else if (ch == ')') {
                        b--;

                        if (b < 0) {
                            valid = false;
                            break;
                        }
                    }
                }

                if (valid && b == 0) {
                    ans.add(str);
                } 
                else if (ans.isEmpty()) {
                    for (int j = 0; j < str.length(); j++) {

                        if (str.charAt(j) != '(' && str.charAt(j) != ')')
                            continue;

                        String newStr =
                            str.substring(0, j) + str.substring(j + 1);

                        if (set.add(newStr)) {
                            q.offer(newStr);
                        }
                    }
                }
            }

            if (!ans.isEmpty()) {
                return ans;
            }
        }

        return ans;
    }
}