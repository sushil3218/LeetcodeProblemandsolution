class Solution {
    public boolean isPalindrome(String s) { 
        String t =""; 
       String a= s.toLowerCase();
        for(int i =0; i<a.length(); i++){
            char ch = a.charAt(i);
            if((ch>='a' && ch<='z')|| (ch>='0'&& ch<='9')){
                t = t + ch ;
            }
        }   
        System.out.println(t);
        if(t.length()<0 || t.length() == 1){
            return true ;
        }
        int i =0; 
        int j = t.length()-1;
        while(i<=j){
            if(t.charAt(i) != t.charAt(j)){
                return false ;
            }
              i++;
              j--;
              //System.out.print(t.charAt(i)+" "+t.charAt(j)+" ");
            }
        
        return true;
    }
}