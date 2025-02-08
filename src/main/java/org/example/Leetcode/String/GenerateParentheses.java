package org.example.Leetcode.String;

// leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurssion(res, 0,0,n, "");
        return res;
    }
    private void recurssion(List<String> res, int open, int close, int n, String curStr) {
        //if(open == n && close == 0) return;
        if(open == close && close == n) {
        //if (curStr.length() == n * 2) {
            res.add(curStr);
            return;
        }

        if(open < n) {
            //curStr += '(';
            //open++;
            //recurssion(res, open, close, n, curStr);
            recurssion(res, open + 1, close, n, curStr + "(");
        }
        if(close < open) {
            //curStr += ')';
            //close++;
            //recurssion(res, open, close, n, curStr);
            recurssion(res, open, close+1, n, curStr + ")");
        }


    }

    public static void main(String[] args) {
        List<String> res = new GenerateParentheses().generateParenthesis(4);
        System.out.println(res);
    }
}

