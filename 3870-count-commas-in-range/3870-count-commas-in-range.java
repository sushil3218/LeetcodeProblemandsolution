class Solution {
    public int countCommas(int n) {
        int count  = 0;
        if(n<1000){
            return 0;
        }else {
          for(int i =1; i<=n; i++){
            if(i>=1000){
                count++;
            }
          }

        }
        return count;
    }
}