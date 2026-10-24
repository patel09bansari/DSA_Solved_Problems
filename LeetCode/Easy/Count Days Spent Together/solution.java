class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int aliceArrival = convertToDayOfYear(arriveAlice, daysInMonths);
        int aliceLeaving = convertToDayOfYear(leaveAlice, daysInMonths);
        int bobArrival = convertToDayOfYear(arriveBob, daysInMonths);
        int bobLeaving = convertToDayOfYear(leaveBob, daysInMonths);
        
        int startTogether = Math.max(aliceArrival, bobArrival);
        int endTogether = Math.min(aliceLeaving, bobLeaving);
        
        return Math.max(0, endTogether - startTogether + 1);
    }
    
    private int convertToDayOfYear(String date, int[] daysInMonths) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }
        return dayOfYear;
    }
}