package org.example.Leetcode.stack;

//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/?envType=problem-list-v2&envId=stack

import java.util.Stack;

public class PreorderSerialization {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty() || preorder.length() < 3) {
            return false;
        }
        Stack<String> st = new Stack<>();
        for(String c : preorder.split(",")) {
            st.push(c);
            while(st.peek().equals("#") && st.size() >= 2 && st.get(st.size()-2).equals("#")) {
                st.pop();
                st.pop();
                if(st.isEmpty()) {
                    return false;
                }
                st.pop();
                st.push(c);

            }
        }
        return st.size() == 1 && st.peek().equals("#")?true:false;
    }

    public static void main(String[] args) {
        PreorderSerialization preorderSerialization = new PreorderSerialization();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean result = preorderSerialization.isValidSerialization(preorder);
        System.out.println(result); // Output: true
    }
}
