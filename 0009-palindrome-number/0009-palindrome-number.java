class Solution {
    public boolean isPalindrome(int x) {
        int  n = 0;  
        int a = x ; 
        if(x<0){
            return false ;
        }
        while(x !=0){ 
            n = n * 10 ;
            n = n + x %10 ;
            x = x/10;
        }  
        System.out.println(n) ;
        if(n == a){
            return true ;
        }
        return false ;
    }
}