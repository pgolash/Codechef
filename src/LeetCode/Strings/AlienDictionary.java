package LeetCode.Strings;

import java.util.*;

/**
 * Created by prashantgolash on 27/01/16.
 */
public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, HashSet<Character>> hashmap = new HashMap();
        int[] pre = new int[26];

        for(int i = 0; i < words.length; i++){
            //put every letter into map
            char[] chs = words[i].toCharArray();
            for(char c : chs) {
                if (!hashmap.containsKey(c)) {
                    hashmap.put(c, new HashSet<Character>());
                }
            }
            if(i == 0)  continue;

            //from the second element, compare itself to its previous element and find the order of letters
            int p = 0;
            int len = Math.min(words[i-1].length(), words[i].length());

            while(p < len && words[i-1].charAt(p) == words[i].charAt(p)) {
                p++;
            }

            if(p == len) {
                continue;
            }

            char ch1 = words[i-1].charAt(p);
            char ch2 = words[i].charAt(p);

            if(hashmap.get(ch1).add(ch2)) {
                pre[ch2 - 'a']++;
            }
        }

        //take in those characters that no previous character needed
        Queue<Character> queue = new LinkedList();
        for(int i = 0; i < pre.length; i++){
            char c = (char)('a' + i);
            if(pre[i] == 0 && hashmap.containsKey(c)) {
                queue.offer(c);
            }
        }

        //consume the character after all previous characters showed up
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char cur = queue.poll();
            sb.append(cur);
            for(Object ob : hashmap.get(cur)){
                char ch = (char)ob;
                pre[ch -'a']--;
                if(pre[ch-'a'] == 0){
                    queue.add(ch);
                }
            }
        }
        //find those characters that will never be used (invalid order e.g. cycle)
        for(int i = 0; i < 26; i++){
            if(pre[i] > 0)
                return "";
        }
        return sb.toString();
    }
}
