class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        // Stores all prefixes from arr1
        HashSet<String> set = new HashSet<>();

        // Generate all prefixes from arr1
        for (int num : arr1) {

            String s = String.valueOf(num);

            String prefix = "";

            for (char ch : s.toCharArray()) {
                prefix += ch;
                set.add(prefix);
            }
        }

        int maxLen = 0;

        // Check prefixes of arr2 numbers
        for (int num : arr2) {

            String s = String.valueOf(num);

            String prefix = "";

            for (char ch : s.toCharArray()) {

                prefix += ch;

                // If prefix exists in arr1 prefixes
                if (set.contains(prefix)) {
                    maxLen = Math.max(maxLen, prefix.length());
                }
            }
        }

        return maxLen;
    }
}