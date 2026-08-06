class Solution {
    public int reverse(int x) { 
        long y  = 0 ; 

    while(x != 0){ 
      int pop  =  x % 10 ;
         x = x/10 ;  
        y = y*10+pop ;
     }  
     if(y<Integer.MIN_VALUE || y> Integer.MAX_VALUE){
        return 0;
   }
   return (int) y ;
}
}