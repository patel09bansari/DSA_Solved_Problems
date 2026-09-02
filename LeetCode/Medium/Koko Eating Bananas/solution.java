class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long l = 1;
        long max = piles[0];
        for(int i=1; i<piles.length; i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }
        long high = max;
        long ans = max;

     while(l <= high){
            long mid = l + (high-l)/2;
            if(isPossible(piles, h, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                l=mid+1;
            }
        } return (int) ans;
    } 

public boolean isPossible(int piles[], int h, long mid){
    long actualtime = 0;
    for(int i=0; i<piles.length; i++){
        // if(piles[i]mid){
        actualtime+=piles[i]/mid;
        // }
        if(piles[i] % mid != 0){
            actualtime++;
        }
    }       return actualtime <= h;

}


}