class Solution {
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder();
        String[] words = title.split(" ");
        for(int i=0; i<words.length; i++){
            String word = words[i].toLowerCase(); 
            if(word.length() > 2){
               word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            } 
            // else {
            //     word = word.toLowerCase();
            // }
        sb.append(word);
            if(i<words.length-1){
                sb.append(" ");
            }
        } return sb.toString();
    }
}