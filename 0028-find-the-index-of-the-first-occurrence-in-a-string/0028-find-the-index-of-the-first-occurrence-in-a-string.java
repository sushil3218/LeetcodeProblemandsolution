class Solution {
    public int strStr(String haystack, String needle) { 
        if(needle.length() > haystack.length()){
            return -1;
        }
        for(int i =0 ; i<=haystack.length()-needle.length(); i++){
            String s = "";
            for(int j = i; j < i + needle.length(); j++){
                 s = s + haystack.charAt(j);
                 if(s.equals(needle)){
                    return i ;
                 }
            }
        } 
         return -1 ;
    }
}