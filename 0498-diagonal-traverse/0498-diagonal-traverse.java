class Solution {
    public int[] findDiagonalOrder(int[][] mat) { 
        int rows = mat.length ;
        int colm = mat[0].length ;  
        int [] arr = new int [rows *colm ] ; 
         int z = 0 ;
        for(int i=0; i<rows +colm-1; i++ ){
            ArrayList<Integer> list = new ArrayList<>();
          int   row = (i < colm)?0:i - colm +1 ;
          int   col = (i < colm)?i : colm -1 ; 
            while(row < rows && col >=0){
                list.add(mat[row][col]);
                row ++ ;
                col -- ; 
            }
            if(i%2 == 0){
                for(int j= list.size()-1 ; j>=0; j--){
                    arr[z]=list.get(j);
                    z++;
         }
         }else {
                for(int nums : list ){
                 arr[z++] = nums ;
               }
                
            }
        
        } 
        return arr ;
    }
}