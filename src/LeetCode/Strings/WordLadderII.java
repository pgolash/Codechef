package LeetCode.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by prashantgolash on 26/01/16.
 */

public class WordLadderII {
    /**
     * Helper function to build a directed graph with levels using BFS:
     * - the graph is rooted at `source'
     * - the last level contains only `sink'
     * - the graph is represented by recording all parents of a word
     * - all intermediate words must exist in the dictionary.
     * Return an empty graph if `sink' is not reachable from `source'.
     */
    private HashMap<String, HashSet<String>> buildGraph(String source, String sink, HashSet<String> dict) {

        HashMap<String, HashSet<String>> parents = new HashMap<>();

        // in BFS, when testing if a node can be added to the new
        // level we only need to test if it has been visited in the
        // previous two levels.
        HashSet<String> previousLevel = null;
        HashSet<String> currentLevel = new HashSet<>();
        currentLevel.add(source);

        // creating levels using BFS
        boolean reachedEnd = false;
        while (!reachedEnd) {
            HashSet<String> newLevel = new HashSet<>();
            // search for unvisited neighbors of each word in the current level
            for (String word : currentLevel) {
                for (int i = 0; i < word.length(); ++i) {
                    char[] chars = word.toCharArray();
                    for (chars[i] = 'a'; chars[i] <= 'z'; ++chars[i]) {
                        if (chars[i] == word.charAt(i)) {
                            continue;
                        }

                        // create a new word by changing exactly one letter
                        String newWord = new String(chars);
                        if (!dict.contains(newWord) || currentLevel.contains(newWord)
                                || previousLevel != null && previousLevel.contains(newWord)) {
                            continue;
                        }

                        // even if we found `sink', we don't "break": we need
                        // to find all parents of `sink'.
                        if (newWord.equals(sink)) { reachedEnd = true; }

                        newLevel.add(newWord);
                        if (!parents.containsKey(newWord)) {
                            parents.put(newWord, new HashSet<String>());
                        }
                        parents.get(newWord).add(word);
                    }
                }
            }
            if (newLevel.isEmpty()) {
                break;
            }

            previousLevel = currentLevel;
            currentLevel = newLevel;
        }

        if (reachedEnd) {
            // if we reached `sink', delete all other words in the last level.
            currentLevel.clear();
            currentLevel.add(sink);
        } else {
            // if we can't reach `sink', return an empty graph
            parents.clear();
        }
        return parents;
    }


    //Helper: generate all paths using DFS
    /** Use DFS to recursively generate all backward paths of words.
     * We assume that:
     * - partialPath is valid
     * - it is valid to append nextWord to partialPath
     */
    private void generatePaths(ArrayList<String> partialPath,
                               String nextWord,
                               HashMap<String, HashSet<String>> parents,
                               List<List<String>> paths) {

        ArrayList<String> extendedPath = new ArrayList<>(partialPath);
        extendedPath.add(nextWord);

        if (!parents.containsKey(nextWord)) {
            // we've reached the root
            paths.add(extendedPath);
            return;
        }
        for (String parent : parents.get(nextWord)) {
            generatePaths(extendedPath, parent, parents, paths);
        }
    }


    public List<List<String>> findLadders(String start, String end, HashSet<String> dict) {

        List<List<String>> paths = new ArrayList<>();
        if (!dict.contains(start) || !dict.contains(end)) { return paths; }

        if (start.equals(end)) {
            ArrayList<String> trivial = new ArrayList<>();
            trivial.add(start);
            paths.add(trivial);
            return paths;
        }

        // find all levels using BFS backwardly:
        // source --> end, sink --> start
        HashMap<String, HashSet<String>> parents = buildGraph(end, start, dict);
        if (parents.isEmpty()) { return paths; }

        ArrayList<String> partialPath = new ArrayList<>();
        generatePaths(partialPath, start, parents, paths);
        return paths;
    }
}