package io.octoprime.ps.fb.hard;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();

        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String ns = new String(tmp);
            if (!m.containsKey(ns)) {
                List<String> l = new ArrayList<>(Arrays.asList(s));
                m.put(ns, l);
            } else {
                List<String> l = m.get(ns);
                l.add(s);
                m.put(ns, l);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : m.entrySet()) ans.add(entry.getValue());

        return ans;
    }
}
