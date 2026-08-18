class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        String[] words = sentence.split(" ");
        StringBuilder suffixA = new StringBuilder("a");
        
        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            
            String word = words[i];
            char firstChar = word.charAt(0);
            
            // Check if word starts with a vowel
            if (vowels.indexOf(firstChar) != -1) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }
            
            // Append "ma" and trailing "a"s
            result.append("ma").append(suffixA);
            suffixA.append("a");
        }
        
        return result.toString();
    }
}