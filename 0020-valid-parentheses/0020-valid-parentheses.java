class Solution {
    public boolean isValid(String s) {
       Stack<Character> list = new Stack<>();
       for(char ch : s.toCharArray()){
        if(ch=='(' || ch=='[' || ch =='{'){
            list.push(ch);
        } else {
        if(list.isEmpty()){
            return false ;
        }
         char top = list.peek();
         if((ch == ')' && top == '(')||
         (ch == ']' && top == '[') ||
           ( ch =='}' && top == '{')){
                 list.pop();
            }else{
                return false ;
            }
       } 
    }
       return list.isEmpty();
    }
}