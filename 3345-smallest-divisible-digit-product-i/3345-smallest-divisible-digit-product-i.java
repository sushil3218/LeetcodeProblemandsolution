class Solution { 
    public static int product (int n ){
        int product = 0 ;
        int sum =  1; 
        while(n>0){
        product = n%10 ; 
       sum = sum*product ;
        n = n/10 ;
        }
        return sum;
    }
    public int smallestNumber(int n, int t) {
        for(int i =n; ; i++){ 
           if(product(i)%t == 0){
            return i ;
           }
        }
      
    }
}