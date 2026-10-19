class Solution {
    HashMap<String, List<Integer>> map;

    public List<Integer> diffWaysToCompute(String expression) {
        map = new HashMap<>();
        return solve(expression);
    }

    private List<Integer> solve(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (!Character.isDigit(ch)) {
                List<Integer> left = solve(expression.substring(0, i));
                List<Integer> right = solve(expression.substring(i + 1));

                for (int x : left) {
                    for (int y : right) {
                        if (ch == '+') {
                            result.add(x + y);
                        } else if (ch == '-') {
                            result.add(x - y);
                        } else {
                            result.add(x * y);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        map.put(expression, result);
        return result;
    }
}