package io.octoprime.ps.fb.easy;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInteger(String pattern) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int number = 0;

        for (int i = 0; i < pattern.length(); i++) {

            char curr = pattern.charAt(i);

            if (curr == 'I' || curr == 'X' || curr == 'C') {
                if (i == pattern.length() - 1) {
                    number = number + map.get(curr);
                } else {
                    char next = pattern.charAt(i + 1);
                    if (next != curr && map.get(next) > map.get(curr)) {
                        number = number + (map.get(next) - map.get(curr));
                        i++;
                    } else {
                        number = number + map.get(curr);
                    }
                }
            } else {
                number = number + map.get(curr);
            }
        }
        return number;
    }

}
