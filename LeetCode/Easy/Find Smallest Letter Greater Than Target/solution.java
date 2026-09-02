class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int s = 0;
        int e = letters.length-1;
        int ans = 0;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(target < letters[mid]){
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return letters[ans];
    }
}