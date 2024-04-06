package org.example.string;

// https://leetcode.com/problems/word-search/description/

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean found = false;
        HashMap<Character, List<Pair<Integer, Integer>>> map = new HashMap<Character, List<Pair<Integer, Integer>>>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                List<Pair<Integer, Integer>> ls = map.getOrDefault(board[i][j], new ArrayList<>());
                ls.add(new Pair(i,j));
                map.put(board[i][j], ls);
            }
        }
        if(word.length() == 1) {
            return map.containsKey(word.charAt(0));
        }
        if(map.containsKey(word.charAt(0))) {
            Iterator<Pair<Integer, Integer>> itr = map.get(word.charAt(0)).iterator();
            while(itr.hasNext()){
                Pair p = itr.next();
                 if(dfs(board, word, 0, p )) return true;
            }
        }

    return false;
    }

    private boolean dfs(char[][] board, String word, int idx, Pair<Integer, Integer> pos) {
        if(idx == word.length()) return true;
        if(board[pos.getKey()][pos.getValue()] == word.charAt(idx)) {
            Character c = board[pos.getKey()][pos.getValue()];
            board[pos.getKey()][pos.getValue()] = '@';
            boolean top = pos.getKey()>=1?dfs(board, word, idx+1, new Pair<>(pos.getKey()-1,pos.getValue())):false;
            boolean left = pos.getValue()>=1?dfs(board, word, idx+1, new Pair<>(pos.getKey(),pos.getValue()-1)):false;
            boolean bottom = pos.getKey()<=board.length-2?dfs(board, word, idx+1, new Pair<>(pos.getKey()+1,pos.getValue())):false;
            boolean right = pos.getValue()<=board[0].length-2?dfs(board, word, idx+1, new Pair<>(pos.getKey(),pos.getValue()+1)):false;
            if(top || left || bottom || right) {
                return true;
            } else {
                board[pos.getKey()][pos.getValue()] = c;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean res = new WordSearch().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},  "ABCCED");
        System.out.println(res);
    }
}
