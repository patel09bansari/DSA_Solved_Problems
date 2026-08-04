class Solution {
    public int totalMoney(int n) {
        int total = 0;
        int mondayMoney = 1;
        int currentMon = mondayMoney;

        for(int day=1; day<=n; day++){
            total+=currentMon;
            currentMon++;

            if(day%7==0){
                mondayMoney++;
                currentMon = mondayMoney;
            }
        }
         return total;
    }
}