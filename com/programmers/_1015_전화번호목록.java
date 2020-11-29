package com.programmers;
import java.util.Arrays;
import java.util.Comparator;

public class _1015_전화번호목록 {

    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[10];
            this.isEnd = false;
        }
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        boolean insert(String word) {
            TrieNode cur = root;
            int len = word.length();

            for(int i = 0; i < len; i++) {
                int num = word.charAt(i) - '0';

                if(cur.children[num] == null) {
                    cur.children[num] = new TrieNode();
                }
                cur = cur.children[num];

                if(cur.isEnd && i + 1 < len) return false;
            }
            cur.isEnd = true;
            return true;
        }
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Trie trie = new Trie();
        for (String s : phone_book) {
            if(!trie.insert(s)) return false;
        }

        return true;
    }
}
