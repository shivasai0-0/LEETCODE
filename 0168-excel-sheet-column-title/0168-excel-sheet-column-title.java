class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--; 
            int remainder = columnNumber % 26;
            sb.append((char) ('A' + remainder));
            columnNumber /= 26;
        }
        
        // Since we gathered characters from right to left, reverse the result
        return sb.reverse().toString();
    }
}