class Solution {
    public String maximumOddBinaryNumber(String s) {
        // StringBuilder sb = new StringBuilder();
        // int zero = 0;
        // int one = 1;
        //   for(int i=0; i<s.length(); i++){
        //         if(ch[i]==1){
        //             count++;
        //         }
          
        char arr[] = s.toCharArray();
        int n = s.length();
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            if(arr[i]=='1'){
                i++;
            }
            else if(arr[j]=='0'){
                j--;
            }
            else if(arr[i]=='0' && arr[j]=='1' && i<=j){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--; 
            }
        }
        arr[j] = '0';
        arr[n-1] = '1';
        return new String(arr);
    }
}




//          int count = 0;
//          char ch[] = s.toCharArray();
//             for(int i=0; i<ch.length; i++){
//                 if(ch[i]==1){
//                     count++;
//                 }
//             }
//             for(i=0; i<ch.length-1; i++){
//                if(count > 1){
//                 ch[i] = '1';
//                 count--;
//                } else {
//                 ch[i] = '0';
//             }
//             }
//             ch[ch.length-1] = '1';
//              return new String(ch);
// }
// }


















