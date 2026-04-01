class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> strev = new Stack<>();

        for (int i : asteroids) {
            if (i >= 0) {
                st.push(i);
            }
            else if (!st.isEmpty() && st.peek() > 0 && st.peek() == -i) {
                st.pop();
            }
            else if (!st.isEmpty() && st.peek() > 0 && st.peek() > -i) {
                continue;
            }
            else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -i) {
                    st.pop();
                }
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(i);
                }
                else if (st.peek() == -i) {
                    st.pop();
                }
            }
        }

        int[] arr = new int[st.size()];
        int k = 0;
        while (!st.isEmpty()) {
            strev.push(st.pop());
        }
        while (!strev.isEmpty()) {
            arr[k++] = strev.pop();
        }

        return arr;
    }
}