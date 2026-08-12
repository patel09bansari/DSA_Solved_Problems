class Solution {
    public String toggleCase(String s) {
        // code here
        String res = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                res += Character.toLowerCase(ch);
            } else {
                res += Character.toUpperCase(ch);
            }
        } return res; 
        
    }
}
