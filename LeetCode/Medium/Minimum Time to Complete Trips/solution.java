class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 1;
        long min = time[0];
        for(int i=1; i<time.length; i++){
            if(time[i]<min){
                min = time[i];
            }
        }
        long h = min * totalTrips;
        long ans = -1;
        while(l <= h){
            long mid = l + (h-l)/2;
            if(isPossible(time, totalTrips, mid)){
                ans = mid;
                h = mid - 1;
            } else {
                l=mid+1;
            }
        } return ans;
    } 
    public boolean isPossible(int time[], int totalTrips, long  mid){
         long actualTrip = 0;
        for(int i=0; i<time.length; i++){
            actualTrip += mid/time[i];
        }
        return actualTrip >= totalTrips;
    } 
}

