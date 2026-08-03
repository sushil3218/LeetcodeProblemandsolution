class Solution {
    public int firstUniqChar(String s) { 
        char t = '0';
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
             map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : s.toCharArray()){
            if(map.get(ch) == 1){
                 t = ch ;
                 break ;
            }
        } 
         return s.indexOf(t) ;
     }
}