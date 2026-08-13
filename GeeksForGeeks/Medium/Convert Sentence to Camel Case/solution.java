class Solution {
    public String convertToCamelCase(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Skip spaces
            if (ch == ' ') continue;

            // If the PREVIOUS character was a space, capitalize this character
            if (i > 0 && s.charAt(i - 1) == ' ') {
                result.append(Character.toUpperCase(ch));
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}